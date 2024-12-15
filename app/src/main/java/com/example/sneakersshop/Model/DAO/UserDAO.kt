package com.example.sneakersshop.Model.DAO

import androidx.room.*
import com.example.sneakersshop.Model.Entity.User

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User): Long

    @Delete
    suspend fun delete(user: User)

    @Query("SELECT * FROM user_table")
    suspend fun getAllUsers(): List<User>
}