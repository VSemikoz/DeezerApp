package ru.vssemikoz.deezerapp.features.di

import dagger.Module
import dagger.Provides
import ru.vssemikoz.deezerapp.base.adapter.BaseAdapter
import ru.vssemikoz.deezerapp.features.PlayListAdapter
import ru.vssemikoz.deezerapp.models.PlayList

@Module
class AdapterModule {
    @Provides
    fun provideAdapter(adapter: PlayListAdapter): BaseAdapter<PlayList> {
        return adapter
    }
}
