package ru.vssemikoz.deezerapp.base.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.vssemikoz.deezerapp.DeezerApplication

@Module
class ApplicationModule(private val application: DeezerApplication) {

    @Provides
    fun provideApplication(): DeezerApplication = application

    @Provides
    fun provideContext(): Context = application.applicationContext

}
