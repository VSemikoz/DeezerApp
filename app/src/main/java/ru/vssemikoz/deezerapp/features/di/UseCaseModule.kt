package ru.vssemikoz.deezerapp.features.di

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.base.BaseUseCase
import ru.vssemikoz.deezerapp.features.usecase.GetPlayListsUseCase
import ru.vssemikoz.deezerapp.features.usecase.GetTrackUseCase
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track

@Module
class UseCaseModule {
    @Provides
    fun provideGetPlayListUseCase(getPlayListsUseCase: GetPlayListsUseCase): BaseUseCase<Observable<List<PlayList>>, Int> =
        getPlayListsUseCase

    @Provides
    fun provideGetTrackUseCase(getTrackUseCase: GetTrackUseCase): BaseUseCase<Observable<List<Track>>, Int> =
        getTrackUseCase
}
