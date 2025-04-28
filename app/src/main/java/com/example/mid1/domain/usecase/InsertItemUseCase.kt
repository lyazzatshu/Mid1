package com.example.mid1.domain.usecase

import com.example.mid1.domain.model.YourEntity
import com.example.mid1.domain.repository.YourRepository

class InsertItemUseCase(
    private val repository: YourRepository
) {
    suspend operator fun invoke(item: YourEntity) {
        repository.insertItem(item)
    }
}
