package com.example.sneakersshop.Model.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sneakersshop.Model.Entity.Order

@Dao
interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(order: Order) : Long

    @Delete
    suspend fun delete(order: Order)

    @Query("SELECT * FROM order_table WHERE id = :id")
    suspend fun getOrder(id: Int): Order

    @Query("SELECT * FROM order_table")
    suspend fun getAllOrders(): List<Order>

    @Query("SELECT * FROM order_table WHERE user_id == :userid")
    suspend fun getAllOrdersOfUser(userid: Int): List<Order>
}