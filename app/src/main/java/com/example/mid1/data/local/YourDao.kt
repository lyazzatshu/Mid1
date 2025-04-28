package com.example.mid1.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface YourDao {

    @Query("SELECT * FROM your_entity_table")
    suspend fun getAll(): List<YourEntityEntity>

    @Insert
    suspend fun insert(item: YourEntityEntity)
}
