package com.example.mid1.data.mapper

import com.example.mid1.data.local.YourEntityEntity as DataYourEntity
import com.example.mid1.domain.model.YourEntity as DomainYourEntity

fun DataYourEntity.toDomain(): DomainYourEntity {
    return DomainYourEntity(
        id = id,
        name = name,
        description = description // ➡️ Обязательно добавить!
    )
}

fun DomainYourEntity.toData(): DataYourEntity {
    return DataYourEntity(
        id = id,
        name = name,
        description = description // ➡️ И сюда тоже!
    )
}
