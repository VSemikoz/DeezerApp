package ru.vssemikoz.deezerapp.features.playlistselection

import ru.vssemikoz.deezerapp.models.PlayList

interface PlayListSelectionNavigator {

    fun onPlayListSelected(playList: PlayList)
}
