package com.example.mid1.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "your_entity_table")
data class YourEntityEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val description: String = ""
)
