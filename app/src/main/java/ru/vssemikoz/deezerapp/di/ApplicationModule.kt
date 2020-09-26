package ru.vssemikoz.deezerapp.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vssemikoz.deezerapp.DeezerApplication

@Module
class ApplicationModule(private val application: DeezerApplication) {

    @Provides
    fun provideApplication(): DeezerApplication {
        return application
    }

    @Provides
    fun provideContext(): Context {
        return application.applicationContext
    }

}
