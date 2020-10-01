package ru.vssemikoz.deezerapp.data.api

import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vssemikoz.deezerapp.AppConfig

@Module
class NetworkModule {
    @Provides
    fun provideRetrofit(config: AppConfig): Retrofit = Retrofit.Builder()
        .baseUrl(config.baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    @Provides
    fun provideDeezerApi(retrofit: Retrofit): DeezerApi = retrofit.create<DeezerApi>(
        DeezerApi::class.java
    )
}
