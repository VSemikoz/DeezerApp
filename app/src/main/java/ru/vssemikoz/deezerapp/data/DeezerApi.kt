package ru.vssemikoz.deezerapp.data

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import ru.vssemikoz.deezerapp.models.DeezerApiPlayListsResponse
import ru.vssemikoz.deezerapp.models.DeezerApiTrackResponse

interface DeezerApi {
    @GET("user/{user_id}/playlists")
    fun getUserPlayList(@Path("user_id") id: Int): Observable<DeezerApiPlayListsResponse>

    @GET("playlist/{playlist_id}/tracks")
    fun getTrackFromPlayList(@Path("playlist_id") id: Int): Observable<DeezerApiTrackResponse>
}
