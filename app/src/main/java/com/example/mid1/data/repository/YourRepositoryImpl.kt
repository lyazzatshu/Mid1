package com.example.mid1.data.repository

import com.example.mid1.data.local.YourDao
import com.example.mid1.data.mapper.toData
import com.example.mid1.data.mapper.toDomain
import com.example.mid1.domain.model.YourEntity
import com.example.mid1.domain.repository.YourRepository

class YourRepositoryImpl(
    private val dao: YourDao
) : YourRepository {

    override suspend fun getAllItems(): List<YourEntity> {
        return dao.getAll().map { it.toDomain() }
    }

    override suspend fun insertItem(item: YourEntity) {
        dao.insert(item.toData())
    }
}
