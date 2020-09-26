package ru.vssemikoz.deezerapp.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.deezerapp.AppConfig
import ru.vssemikoz.deezerapp.BuildConfig

@Module
class AppConfigModule {
    @Provides
    fun provideAppConfig(): AppConfig {
        return AppConfig(
            BuildConfig.MAIN_URL,
            BuildConfig.BASE_USER_ID
        )
    }
}
