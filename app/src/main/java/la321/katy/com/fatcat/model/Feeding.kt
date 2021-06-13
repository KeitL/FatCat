package la321.katy.com.fatcat.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feedings")
data class Feeding(
        @PrimaryKey
        var feedingId:String,
        var feedingTime:String,
        var feedingPortion:Long,
        var petOwner:String)