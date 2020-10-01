package ru.vssemikoz.deezerapp.features.di

import dagger.Subcomponent
import ru.vssemikoz.deezerapp.features.playlistdetails.PlayListDetailsFragment
import ru.vssemikoz.deezerapp.features.playlistselection.PlayListSelectionFragment

@Subcomponent(
    modules = [
        UseCaseModule::class,
        AdapterModule::class
    ]
)
interface FragmentComponent {
    fun inject(fragment: PlayListSelectionFragment?)

    fun inject(fragment: PlayListDetailsFragment?)
}
