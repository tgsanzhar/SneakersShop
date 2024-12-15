package com.example.sneakersshop.Model

import androidx.room.*
import com.example.sneakersshop.Model.DAO.BootDao
import com.example.sneakersshop.Model.DAO.CartDao
import com.example.sneakersshop.Model.DAO.OrderDao
import com.example.sneakersshop.Model.DAO.UserDao
import com.example.sneakersshop.Model.Entity.Boot
import com.example.sneakersshop.Model.Entity.Cart
import com.example.sneakersshop.Model.Entity.Order
import com.example.sneakersshop.Model.Entity.User

@Database(entities = [User::class, Boot::class, Cart::class, Order::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun bootDao(): BootDao
    abstract fun cartDao(): CartDao
    abstract fun orderDao(): OrderDao
}


