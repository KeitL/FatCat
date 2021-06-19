package la321.katy.com.fatcat.model

import androidx.room.Database
import androidx.room.RoomDatabase
import la321.katy.com.fatcat.model.daos.FeedingDatesDao
import la321.katy.com.fatcat.model.daos.UserDao

@Database(entities = [FeedingDate::class, User::class], version = 3, exportSchema = false)

abstract class Database : RoomDatabase() {
    abstract fun feedingDao(): FeedingDatesDao
    abstract fun usersDao(): UserDao
}
