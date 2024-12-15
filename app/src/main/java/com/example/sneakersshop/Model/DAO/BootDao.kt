package com.example.sneakersshop.Model.DAO

import androidx.room.*
import com.example.sneakersshop.Model.Entity.Boot

@Dao
interface BootDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(boot: Boot)

    @Delete
    suspend fun delete(boot: Boot)

    @Query("SELECT * FROM boot_table")
    suspend fun getAllBoots(): List<Boot>
}