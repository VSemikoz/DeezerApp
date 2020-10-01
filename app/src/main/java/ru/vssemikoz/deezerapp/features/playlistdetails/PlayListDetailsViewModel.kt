package ru.vssemikoz.deezerapp.features.playlistdetails

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vssemikoz.deezerapp.base.BaseUseCase
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.models.Track
import ru.vssemikoz.deezerapp.utils.mappers.PlayListDateConverter
import javax.inject.Inject

class PlayListDetailsViewModel @Inject constructor() : BaseObservable() {
    @Bindable
    var loading = true
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    @Inject
    lateinit var getTrackUseCase: BaseUseCase<Observable<List<Track>>, String>

    var trackList: MutableLiveData<List<Track>> = MutableLiveData()
    lateinit var playList: PlayList
    lateinit var title: String


    fun start() {
        title = "${playList.author} - ${PlayListDateConverter.map(playList.duration)}"
        getTrackUseCase.run(playList.id)
            .doOnSubscribe { loading = true }
            .doOnTerminate { loading = false }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { message -> trackList.value = message },
                { error -> error.printStackTrace() },
                { loading = false }
            )
    }
}
