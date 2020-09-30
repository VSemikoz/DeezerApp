package ru.vssemikoz.deezerapp.features.playlistselection

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import ru.vssemikoz.deezerapp.R
import ru.vssemikoz.deezerapp.features.playlistdetails.PlayListDetailsActivity
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.utils.ActivityUtils


class PlayListSelectionActivity : AppCompatActivity(), PlayListSelectionNavigator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.play_list_selection_act)

        var playListSelectionFragment: PlayListSelectionFragment? = supportFragmentManager
            .findFragmentById(R.id.contentFrame) as PlayListSelectionFragment?
        if (playListSelectionFragment == null) {
            playListSelectionFragment = PlayListSelectionFragment()
            ActivityUtils.addFragmentToActivity(
                supportFragmentManager,
                playListSelectionFragment, R.id.contentFrame
            )
        }
    }


    override fun onPlayListSelected(playList: PlayList, imageView: ImageView) {
        Intent(this, PlayListDetailsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val bundle = Bundle()
            bundle.putSerializable("playListItem", playList)
            putExtras(bundle)
            val transitionName: String = getString(R.string.playlist_image)
            val transitionActivityOptions =
                ActivityOptions.makeSceneTransitionAnimation(
                    this@PlayListSelectionActivity,
                    imageView,
                    transitionName
                )
            startActivity(this, transitionActivityOptions.toBundle())
        }
    }
}
