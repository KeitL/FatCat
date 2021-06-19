package la321.katy.com.fatcat.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import la321.katy.com.fatcat.model.FeedingDate

@Dao
interface FeedingDatesDao {
    @Query("SELECT * FROM feeding_days")
    fun getAllFeedings(): List<FeedingDate>

    @Insert
    fun insertFeedings(feeding: FeedingDate)

    @Query("DELETE FROM feeding_days")
    fun deleteFeedings()
}