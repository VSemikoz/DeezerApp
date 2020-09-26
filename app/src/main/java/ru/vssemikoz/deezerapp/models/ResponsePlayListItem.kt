package ru.vssemikoz.deezerapp.models

import com.google.gson.annotations.SerializedName

class ResponsePlayListItem(
    val id: String,
    val title: String,
    val duration: String,
    val public: String,
    @SerializedName("is_loved_track")
    val isLovedTrack: String,
    val collaborative: String,
    @SerializedName("nb_tracks")
    val nbTracks: String,
    val fans: String,
    val link: String,
    val picture: String,
    @SerializedName("picture_small")
    val pictureSmall: String,
    @SerializedName("picture_medium")
    val pictureMedium: String,
    @SerializedName("picture_big")
    val pictureBig: String,
    @SerializedName("picture_xl")
    val pictureXl: String,
    val checksum: String,
    val tracklist: String,
    @SerializedName("creation_date")
    val creationDate: String,
    @SerializedName("md5_image")
    val md5Image: String,
    @SerializedName("time_add")
    val timeAdd: String,
    @SerializedName("time_mod")
    val timeMod: String,
    val creator: Creator,
    val type: String
)
