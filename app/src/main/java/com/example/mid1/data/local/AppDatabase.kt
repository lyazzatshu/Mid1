package com.example.mid1.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [YourEntityEntity::class],
    version = 2,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun yourDao(): YourDao
}
