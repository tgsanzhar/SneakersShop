package com.example.sneakersshop.Model.Entity

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_table")
data class Cart(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "priceText") val priceText: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "drawable") @DrawableRes val drawable: Int,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "orderId") val orderId: Int,
    @ColumnInfo(name = "count") var count: Int,
)