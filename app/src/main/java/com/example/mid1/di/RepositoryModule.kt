package com.example.mid1.di

import com.example.mid1.data.repository.YourRepositoryImpl
import com.example.mid1.domain.repository.YourRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<YourRepository> { YourRepositoryImpl(get()) }
}
