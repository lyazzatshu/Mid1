package com.example.mid1.domain.usecase

import com.example.mid1.domain.model.YourEntity
import com.example.mid1.domain.repository.YourRepository

class YourUseCase(
    private val repository: YourRepository
) {
    suspend fun getAllItems(): List<YourEntity> {
        return repository.getAllItems()
    }

    suspend fun insertItem(item: YourEntity) {
        repository.insertItem(item)
    }
}
