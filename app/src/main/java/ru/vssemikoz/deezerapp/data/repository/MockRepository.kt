package ru.vssemikoz.deezerapp.data.repository

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track
import ru.vssemikoz.deezerapp.utils.generator.PlayListItemGenerator
import ru.vssemikoz.deezerapp.utils.generator.TrackItemGenerator

class MockRepository : DeezerRepository {
    override fun getUserPlayLists(userId: Int): Observable<List<PlayList>> =
        Observable.just(List(10) { PlayListItemGenerator.generate() })

    override fun getTracksFromPlayListLists(playListId: Int): Observable<List<Track>> =
        Observable.just(List(10) { TrackItemGenerator.generate() })

}
