package com.example.sneakersshop.Model.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sneakersshop.Model.Entity.Cart

@Dao
interface CartDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cart: Cart)

    @Delete
    suspend fun delete(cart: Cart)

    @Query("SELECT * FROM cart_table WHERE id == :id")
    suspend fun getCart(id: Int): Cart

    @Query("SELECT * FROM cart_table")
    suspend fun getAllCarts(): List<Cart>

    @Query("SELECT * FROM cart_table WHERE orderId == :id")
    suspend fun getAllCartsOfOrder(id: Int): List<Cart>


    @Query("SELECT * FROM cart_table WHERE userId == :userID AND orderId == -1")
    suspend fun getAllCartsOfUser(userID: Int): List<Cart>

    @Query("UPDATE cart_table SET orderId = :newOrderId WHERE userId = :userId AND orderId = -1")
    suspend fun updateOrderIds(userId: Int, newOrderId: Long)

    @Query("DELETE FROM cart_table")
    suspend fun deleteAll()
}