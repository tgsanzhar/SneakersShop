package com.example.sneakersshop.Model.Entity

import androidx.room.*

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "username") var username: String,
    @ColumnInfo(name = "password") var password: String,
)