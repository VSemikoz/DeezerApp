package ru.vssemikoz.deezerapp.base.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.deezerapp.AppConfig
import ru.vssemikoz.deezerapp.BuildConfig

@Module
class AppConfigModule {
    @Provides
    fun provideAppConfig(): AppConfig = AppConfig(
        baseUrl = BuildConfig.MAIN_URL,
        fixedUserId = BuildConfig.BASE_USER_ID,
        limit = BuildConfig.UNLIMITED
    )
}
