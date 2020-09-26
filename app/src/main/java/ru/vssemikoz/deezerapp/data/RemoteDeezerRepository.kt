package ru.vssemikoz.deezerapp.data

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import io.reactivex.rxjava3.core.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track
import ru.vssemikoz.deezerapp.utils.PlayListMapper
import ru.vssemikoz.deezerapp.utils.TrackMapper

class RemoteDeezerRepository : DeezerRepository {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.deezer.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
    val api: DeezerApi = retrofit.create<DeezerApi>(DeezerApi::class.java)

    override fun getUserPlayLists(userId: Int): Observable<List<PlayList>> {
        return api.getUserPlayList(5).map{
            PlayListMapper().map(it)
        }
    }

    override fun getTracksFromPlayListLists(playListId: Int): Observable<List<Track>> {
        return api.getTrackFromPlayList(playListId).map{
            TrackMapper().map(it)
        }
    }

}
