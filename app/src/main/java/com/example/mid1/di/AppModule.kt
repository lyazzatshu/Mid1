package com.example.mid1.di

import androidx.room.Room
import com.example.mid1.data.local.AppDatabase
import com.example.mid1.data.local.YourDao
import com.example.mid1.data.repository.YourRepositoryImpl
import com.example.mid1.domain.repository.YourRepository
import com.example.mid1.domain.usecase.GetAllItemsUseCase
import com.example.mid1.domain.usecase.InsertItemUseCase
import com.example.mid1.presentation.screens.YourViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "your_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single<YourDao> { get<AppDatabase>().yourDao() }

    single<YourRepository> { YourRepositoryImpl(get()) }

    single { GetAllItemsUseCase(get()) }
    single { InsertItemUseCase(get()) }

    viewModel { YourViewModel(get(), get()) }
}
