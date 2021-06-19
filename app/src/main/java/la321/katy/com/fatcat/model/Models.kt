package la321.katy.com.fatcat.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters

@Entity(tableName = "users")
data class User(
        @PrimaryKey
        val id:String,val userName:String, val password:String)


data class Feeding(
        var feedingId:String,
        var feedingTime:String,
        var feedingPortion:Long,
        var petOwner:String)

@TypeConverters(Converter::class)
@Entity(tableName = "feeding_days")
data class FeedingDate(
        @PrimaryKey
        var title:String, var items:List<Feeding>)