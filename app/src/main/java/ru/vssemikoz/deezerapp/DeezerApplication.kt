package ru.vssemikoz.deezerapp

import android.app.Application
import ru.vssemikoz.deezerapp.base.di.ApplicationComponent
import ru.vssemikoz.deezerapp.base.di.ApplicationModule
import ru.vssemikoz.deezerapp.base.di.DaggerApplicationComponent

class DeezerApplication : Application() {
    companion object {

        private lateinit var applicationComponent: ApplicationComponent
        private lateinit var instance: DeezerApplication

        fun getInstance(): DeezerApplication? {
            return instance
        }

        fun getApplicationComponent(): ApplicationComponent {
            return applicationComponent
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(instance))
            .build()
    }
}
