package ru.vssemikoz.deezerapp.data.repository

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track


interface DeezerRepository {
    fun getUserPlayLists(userId: String): Observable<List<PlayList>>

    fun getTracksFromPlayList(playListId: String): Observable<List<Track>>
}
