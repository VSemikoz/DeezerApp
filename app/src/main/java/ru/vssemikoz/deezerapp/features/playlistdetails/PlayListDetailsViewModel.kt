package ru.vssemikoz.deezerapp.features.playlistdetails

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vssemikoz.deezerapp.base.BaseUseCase
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track
import ru.vssemikoz.deezerapp.utils.mappers.DateConverter
import javax.inject.Inject

class PlayListDetailsViewModel @Inject constructor() : BaseObservable() {
    @Bindable
    var loading = true
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    var navigator: PlayListDetailsNavigator? = null

    @Inject
    lateinit var getTrackUseCase: BaseUseCase<Observable<List<Track>>, Int>

    var shownTrackList: String = ""
    lateinit var playList: PlayList


    fun start() {
        getTracks()
    }

    fun getString(): String {
        return "${playList.author} - ${DateConverter.map(playList.duration)}"
    }

    fun getTracks() {
        getTrackUseCase.run(playList.id)
            .doOnSubscribe { loading = true }
            .doOnTerminate { loading = false }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { message ->
                    shownTrackList = getTracksName(message)
                },
                { error -> error.printStackTrace() },
                { loading = false }
            )
    }

    fun getTracksName(trackList: List<Track>): String =
        trackList.joinToString(separator = "\n") { "${it.title} -  ${DateConverter.map(it.duration)}" }

    fun getEmptyName(): String = "Loading data"
}
