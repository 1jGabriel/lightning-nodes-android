package dev.jgabriel.di

import dev.jgabriel.domain.LightningNodesRepository
import dev.jgabriel.lightningnodes.data.client.provideLightningApi
import dev.jgabriel.lightningnodes.data.client.provideLoggingInterceptor
import dev.jgabriel.lightningnodes.data.client.provideOkHttpClient
import dev.jgabriel.lightningnodes.data.client.provideRetrofit
import dev.jgabriel.lightningnodes.data.repository.LightningNodesRepositoryImpl
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectModules() {
    loadKoinModules(listOf(networkModule, dataModule, domainModule))
}

private val networkModule = module {
    factory { provideOkHttpClient(loggingInterceptor = get()) }
    factory { provideLoggingInterceptor() }
    single { provideRetrofit(okHttpClient = get()) }
}

private val dataModule = module {
    factory { provideLightningApi(retrofit = get()) }
}

private val domainModule = module {
    single<LightningNodesRepository> { LightningNodesRepositoryImpl(get()) }
}