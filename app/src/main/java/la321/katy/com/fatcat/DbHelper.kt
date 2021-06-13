package la321.katy.com.fatcat

import la321.katy.com.fatcat.model.Database

import android.content.Context
import androidx.room.Room
import la321.katy.com.fatcat.model.Feeding
import la321.katy.com.fatcat.model.FeedingDao

object DbHelper {
    private var database: Database? = null

    private val feedingDao by lazy { feedingDao() }
    fun init(context: Context) {
        if (database != null) return
        database = Room.databaseBuilder(
                context,
                Database::class.java, "database-name"
        ).fallbackToDestructiveMigration().build()
    }

    private fun feedingDao() = database?.feedingDao()
            ?: throw ExceptionInInitializerError("DataBase is null need to call init first")

    fun createFeeding(feeding: Feeding, dbStatusListener: DBStatusListener<Feeding>) {
        App().getDBExecutor().execute {
            feedingDao.insertFeedings(feeding)
            App().getMyMainExecutor().execute {
                dbStatusListener.onSuccess(feeding)
            }
        }
    }

    fun getAllFeedings(dbStatusListener: DBStatusListener<List<Feeding>>) {
        App().getDBExecutor().execute {
            val list = feedingDao.getAllFeedings()
            App().getMyMainExecutor().execute {
                dbStatusListener.onSuccess(list)
            }
        }
    }


}