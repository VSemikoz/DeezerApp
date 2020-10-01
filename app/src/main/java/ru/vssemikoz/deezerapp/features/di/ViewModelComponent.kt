package ru.vssemikoz.deezerapp.features.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.deezerapp.features.playlistselection.PlayListSelectionViewModel

@Module
class ViewModelComponent {
    @Provides
    fun providePlayListSelectionViewModel() = PlayListSelectionViewModel()
}
