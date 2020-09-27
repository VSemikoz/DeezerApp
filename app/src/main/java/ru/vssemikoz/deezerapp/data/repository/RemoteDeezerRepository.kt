package ru.vssemikoz.deezerapp.data.repository

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.data.api.DeezerApi
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track
import ru.vssemikoz.deezerapp.utils.mappers.PlayListMapper
import ru.vssemikoz.deezerapp.utils.mappers.TrackMapper
import javax.inject.Inject

class RemoteDeezerRepository @Inject constructor() : DeezerRepository {
    
    @Inject
    lateinit var api: DeezerApi

    override fun getUserPlayLists(userId: Int): Observable<List<PlayList>> {
        return api.getUserPlayList(5).map {
            PlayListMapper().map(it)
        }
    }

    override fun getTracksFromPlayListLists(playListId: Int): Observable<List<Track>> {
        return api.getTrackFromPlayList(playListId).map {
            TrackMapper().map(it)
        }
    }

}
