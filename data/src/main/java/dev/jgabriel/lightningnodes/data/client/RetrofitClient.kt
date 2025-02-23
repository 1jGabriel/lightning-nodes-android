package dev.jgabriel.lightningnodes.data.client

import android.util.Log
import dev.jgabriel.lightningnodes.data.api.BASE_URL
import dev.jgabriel.lightningnodes.data.api.LightningNodeApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(provideLoggingInterceptor()).build()
}

fun provideLoggingInterceptor(): HttpLoggingInterceptor {
    val loggingInterceptor = HttpLoggingInterceptor { message -> Log.d("OkHttp", message) }
        .apply {
            HttpLoggingInterceptor.Level.BODY
        }

    return loggingInterceptor
}

fun provideLightningApi(retrofit: Retrofit): LightningNodeApi =
    retrofit.create(LightningNodeApi::class.java)
