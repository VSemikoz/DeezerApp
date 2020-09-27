package ru.vssemikoz.deezerapp.features.playlistselection


import androidx.lifecycle.MutableLiveData
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vssemikoz.deezerapp.base.BaseUseCase
import ru.vssemikoz.deezerapp.base.BaseViewModel
import ru.vssemikoz.deezerapp.models.PlayList
import javax.inject.Inject

class PlayListSelectionViewModel @Inject constructor() : BaseViewModel<PlayListSelectionNavigator>() {

    @Inject
    lateinit var  getPlayListsUseCase: BaseUseCase<Observable<List<PlayList>>, Int>
    var items: MutableLiveData<List<PlayList>> = MutableLiveData()


    fun setNavigator(layListSelectionNavigator: PlayListSelectionNavigator) {
        navigator = layListSelectionNavigator
    }

    override fun start() {
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
        navigator?.onPlayListSelected(playList)
    }

}
