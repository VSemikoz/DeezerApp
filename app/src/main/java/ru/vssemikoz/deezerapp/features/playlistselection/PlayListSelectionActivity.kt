package ru.vssemikoz.deezerapp.features.playlistselection

import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
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
        val detailsIntent = Intent(this, PlayListDetailsActivity::class.java)

        val pendingIntent: PendingIntent =
            TaskStackBuilder.create(this)
                .addNextIntentWithParentStack(detailsIntent)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(this, "")
        builder.setContentIntent(pendingIntent)


        Intent(this, PlayListDetailsActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            val bundle = Bundle()
            bundle.putSerializable("playListItem", playList)
            putExtras(bundle)

//            val transitionName: String = context.getString(R.string.character_image)
//            val transitionActivityOptions =
//                ActivityOptions.makeSceneTransitionAnimation(
//                    fromActivity,
//                    imageView,
//                    transitionName
//                )
//            startActivity(this, transitionActivityOptions.toBundle())
            startActivity(this)
        }
    }
}
