package ru.vssemikoz.deezerapp.features.playlistselection

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vssemikoz.deezerapp.BR
import ru.vssemikoz.deezerapp.base.BaseUseCase
import ru.vssemikoz.deezerapp.models.PlayList
import javax.inject.Inject

class PlayListSelectionViewModel @Inject constructor() : BaseObservable() {

    private var playListSelectionNavigator: PlayListSelectionNavigator? = null

    @Bindable
    var loading = true
        set(value) {
            field = value
            notifyPropertyChanged(BR.loading)
        }

    @Inject
    lateinit var  getPlayListsUseCase: BaseUseCase<Observable<List<PlayList>>, Int>
    var items: MutableLiveData<List<PlayList>> = MutableLiveData()


    fun setNavigator(navigator: PlayListSelectionNavigator) {
        playListSelectionNavigator = navigator
    }

    fun start() {
        getPlayListsUseCase.run(5)
            .doOnSubscribe { loading = true }
            .doOnTerminate { loading = false }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { message -> items.value = message },
                { error -> error.printStackTrace() },
                { loading = false }
            )
    }

    fun onPlayListClick(playList: PlayList){
        playListSelectionNavigator?.onPlayListSelected(playList)
    }

}
