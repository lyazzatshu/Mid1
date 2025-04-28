package com.example.mid1.domain.usecase

import com.example.mid1.domain.model.YourEntity
import com.example.mid1.domain.repository.YourRepository

class GetAllItemsUseCase(
    private val repository: YourRepository
) {
    suspend operator fun invoke(): List<YourEntity> {
        return repository.getAllItems()
    }
}
