package la321.katy.com.fatcat

import la321.katy.com.fatcat.model.Database

import android.content.Context
import androidx.room.Room
import la321.katy.com.fatcat.model.FeedingDate
import la321.katy.com.fatcat.model.User

object DbHelper {
    private var database: Database? = null

    private val feedingDatesDao by lazy { feedingDatesDao() }
    private val userDao by lazy { userDao() }
    fun init(context: Context) {
        if (database != null) return
        database = Room.databaseBuilder(
                context,
                Database::class.java, "database-name"
        ).fallbackToDestructiveMigration().build()
    }

    private fun feedingDatesDao() = database?.feedingDao()
            ?: throw ExceptionInInitializerError("DataBase is null need to call init first")
    private fun userDao() = database?.usersDao()
            ?: throw ExceptionInInitializerError("DataBase is null need to call init first")

    fun createFeeding(feedingDate: FeedingDate, dbStatusListener: DBStatusListener<FeedingDate>) {
        App().getDBExecutor().execute {
            feedingDatesDao.insertFeedings(feedingDate)
            App().getMyMainExecutor().execute {
                dbStatusListener.onSuccess(feedingDate)
            }
        }
    }

    fun getAllFeedings(dbStatusListener: DBStatusListener<List<FeedingDate>>) {
        App().getDBExecutor().execute {
            val list = feedingDatesDao.getAllFeedings()
            App().getMyMainExecutor().execute {
                dbStatusListener.onSuccess(list)
            }
        }
    }

    fun createUser(user: User,dbStatusListener: DBStatusListener<User>){
        App().getDBExecutor().execute {
            userDao.insertUser(user)
            App().getMyMainExecutor().execute {
                dbStatusListener.onSuccess(user)
            }
        }
    }

    fun getUser(dbStatusListener: DBStatusListener<User>){
        var user:User?
        App().getDBExecutor().execute {
            user = userDao.getUsers()[0]
            App().getMyMainExecutor().execute {
                dbStatusListener.onSuccess(user)
            }
        }
    }


}