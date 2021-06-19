package la321.katy.com.fatcat.model.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import la321.katy.com.fatcat.model.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUsers(): List<User>

    @Insert
    fun insertUser(user: User)

    @Query("DELETE FROM users")
    fun deleteUsers()
}