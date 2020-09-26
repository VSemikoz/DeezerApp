package ru.vssemikoz.deezerapp.data

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track


interface DeezerRepository {
    fun getUserPlayLists(userId: Int) : Observable<List<PlayList>>

    fun getTracksFromPlayListLists(playListId: Int) : Observable<List<Track>>
}
