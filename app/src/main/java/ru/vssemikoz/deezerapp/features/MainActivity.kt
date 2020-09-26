package ru.vssemikoz.deezerapp.features

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.features.usecase.GetPlayListsUseCase
import ru.vssemikoz.deezerapp.features.usecase.GetTrackUsaCase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playListUC = GetPlayListsUseCase()
        val trackListUC = GetTrackUsaCase()

        playListUC.run(5)
            .doOnSubscribe { Log.d("getUserPlayLists", "1") }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { message -> Log.d("onCreate", message[0].toString()) },
                { error -> error.printStackTrace() }
            )

        trackListUC.run(273972)
            .doOnSubscribe { Log.d("getTracksFromPlayListLists", "1") }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { message -> Log.d("onCreate", message[0].toString()) },
                { error -> error.printStackTrace() }
            )

    }
}
