package ru.vssemikoz.deezerapp.features.playlistdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.utils.ActivityUtils

class PlayListDetailsActivity : AppCompatActivity(), PlayListDetailsNavigator {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.playlist_details_act)

        var playListDetailsFragment: PlayListDetailsFragment? = supportFragmentManager
            .findFragmentById(R.id.cf_details) as PlayListDetailsFragment?
        if (playListDetailsFragment == null) {
            playListDetailsFragment = PlayListDetailsFragment()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager,
                playListDetailsFragment, R.id.cf_details
            )
        }

    }

    override fun onScreenSwipe() {
        TODO("Not yet implemented")
    }
}

