package la321.katy.com.fatcat.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {
    @TypeConverter
    fun fromString(value: String?): List<Feeding> {
        val listType: Type = object : TypeToken<List<Feeding>>() {}.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromArrayList(ride: List<Feeding>): String? {
        val gson = Gson()
        return gson.toJson(ride)
    }
}