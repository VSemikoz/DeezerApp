package ru.vssemikoz.deezerapp.di

import dagger.Component
import ru.vssemikoz.deezerapp.DeezerApplication

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
