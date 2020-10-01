package ru.vssemikoz.deezerapp.data.repository

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track


interface DeezerRepository {
    fun getUserPlayLists(userId: Int): Observable<List<PlayList>>

    fun getTracksFromPlayList(playListId: Int): Observable<List<Track>>
}
