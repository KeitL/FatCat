package la321.katy.com.fatcat.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FeedingDao {
    @Query("SELECT * FROM feedings")
    fun getAllFeedings(): List<Feeding>

    @Insert
    fun insertFeedings(feeding: Feeding)

    @Query("DELETE FROM feedings")
    fun deleteFeedings()

}