package com.pirro.stores.common.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.pirro.stores.common.entities.StoreEntity

@Dao
interface StoreDao {
    @Query( "SELECT * FROM StoreEntity")
    fun getAllStore(): MutableList<StoreEntity>

    @Query("SELECT * FROM StoreEntity where id = :id")
    fun getStoreById(id: Long): StoreEntity

    @Insert
    fun addStore(storeEntity: StoreEntity): Long

    @Update
    fun updateStore(storeEntity: StoreEntity)

    @Delete
    fun delateStore(storeEntity: StoreEntity)
}