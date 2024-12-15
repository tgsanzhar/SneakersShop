package com.example.sneakersshop.Model.Entity

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "order_table")
data class Order(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "user_id") val userid: Int,
    @ColumnInfo(name = "sum_money") val sumMoney: Int,
    @ColumnInfo(name = "count") val count: Int,
    @ColumnInfo(name = "createdAt") val createdAt: String,
)