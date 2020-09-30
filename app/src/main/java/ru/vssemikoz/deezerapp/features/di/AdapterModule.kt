package ru.vssemikoz.deezerapp.features.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.deezerapp.base.adapter.BaseAdapter
import ru.vssemikoz.deezerapp.features.adapters.PlayListAdapter
import ru.vssemikoz.deezerapp.features.adapters.TrackAdapter
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track

@Module
class AdapterModule {
    @Provides
    fun providePlayListAdapter(adapter: PlayListAdapter): BaseAdapter<PlayList> {
        return adapter
    }

    @Provides
    fun provideTrackAdapter(adapter: TrackAdapter): BaseAdapter<Track> {
        return adapter
    }
}
