package com.example.sneakersshop.Model

import androidx.room.*
import com.example.sneakersshop.Model.DAO.UserDao
import com.example.sneakersshop.Model.Entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}


