package ru.vssemikoz.deezerapp.base.di

import dagger.Component
import ru.vssemikoz.deezerapp.DeezerApplication
import ru.vssemikoz.deezerapp.data.api.NetworkModule
import ru.vssemikoz.deezerapp.data.repository.RepositoryModule
import ru.vssemikoz.deezerapp.features.di.FragmentComponent

@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        AppConfigModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent {
    fun inject(mainApplication: DeezerApplication)

    fun fragmentComponent(): FragmentComponent
}
