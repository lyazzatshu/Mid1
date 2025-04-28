package com.example.mid1.di

import androidx.room.Room
import com.example.mid1.data.local.AppDatabase
import com.example.mid1.data.local.YourDao
import org.koin.dsl.module
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "ALTER TABLE your_entity_table ADD COLUMN description TEXT NOT NULL DEFAULT ''"
        )
    }
}

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "mid1_database"
        )
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    single<YourDao> {
        get<AppDatabase>().yourDao()
    }
}
