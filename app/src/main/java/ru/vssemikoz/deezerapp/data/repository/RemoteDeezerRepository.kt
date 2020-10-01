package ru.vssemikoz.deezerapp.data.repository

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.AppConfig
import ru.vssemikoz.deezerapp.data.api.DeezerApi
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track
import ru.vssemikoz.deezerapp.utils.mappers.PlayListMapper
import ru.vssemikoz.deezerapp.utils.mappers.TrackMapper
import javax.inject.Inject

class RemoteDeezerRepository @Inject constructor() : DeezerRepository {

    @Inject
    lateinit var api: DeezerApi

    @Inject
    lateinit var config: AppConfig

    override fun getUserPlayLists(userId: String): Observable<List<PlayList>> {
        return api.getUserPlayList(userId, config.limit).map {
            PlayListMapper.map(it)
        }
    }

    override fun getTracksFromPlayList(playListId: String): Observable<List<Track>> {
        return api.getTrackFromPlayList(playListId, config.limit).map {
            TrackMapper().map(it)
        }
    }

}
