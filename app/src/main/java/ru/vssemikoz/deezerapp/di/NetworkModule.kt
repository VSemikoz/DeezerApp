package ru.vssemikoz.deezerapp.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vssemikoz.deezerapp.AppConfig
import ru.vssemikoz.deezerapp.data.DeezerApi

@Module
class NetworkModule {
    @Provides
    fun provideRetrofit(config: AppConfig): Retrofit {
        return Retrofit.Builder()
            .baseUrl(config.baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideDeezerApi(retrofit: Retrofit): DeezerApi {
        return retrofit.create<DeezerApi>(
            DeezerApi::class.java)
    }
}
