package ru.vssemikoz.deezerapp.models

import java.io.Serializable

data class PlayList(
    val id: Int,
    val coverSmall: String,
    val coverBig: String,
    val title: String,
    val author: String,
    val duration: Int
) : Serializable
