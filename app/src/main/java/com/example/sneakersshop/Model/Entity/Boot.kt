package com.example.sneakersshop.Model.Entity

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_table")
data class Boot(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "priceText") val priceText: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "drawable") @DrawableRes val drawable: Int
)