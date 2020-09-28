package ru.vssemikoz.deezerapp.features.playlistselection

import android.widget.ImageView
import ru.vssemikoz.deezerapp.models.PlayList

interface PlayListSelectionNavigator {

    fun onPlayListSelected(playList: PlayList, imageView: ImageView)
}
