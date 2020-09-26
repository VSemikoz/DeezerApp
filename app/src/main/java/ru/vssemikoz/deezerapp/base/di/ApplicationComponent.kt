package ru.vssemikoz.deezerapp.base.di

import dagger.Component
import ru.vssemikoz.deezerapp.DeezerApplication
import ru.vssemikoz.deezerapp.data.api.NetworkModule

@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        AppConfigModule::class
    ]
)
interface ApplicationComponent {
    fun inject(mainApplication: DeezerApplication)

//    fun fragmentComponent(): FragmentComponent
}
