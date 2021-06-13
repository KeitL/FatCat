package la321.katy.com.fatcat.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Feeding::class], version = 1, exportSchema = false)

abstract class Database : RoomDatabase() {
    abstract fun feedingDao(): FeedingDao
}
