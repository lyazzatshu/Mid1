package com.example.mid1.domain.repository

import com.example.mid1.domain.model.YourEntity

interface YourRepository {
    suspend fun getAllItems(): List<YourEntity>
    suspend fun insertItem(item: YourEntity)
}
