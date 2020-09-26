package ru.vssemikoz.deezerapp.models

import com.google.gson.annotations.SerializedName

data class ResponseTrackItem(
    val id: String,
    val readable: String,
    val title: String,
    @SerializedName("title_short")
    val titleShort: String,
    @SerializedName("title_version")
    val titleVersion: String,
    val link: String,
    val duration: String,
    val rank: String,
    @SerializedName("explicit_lyrics")
    val explicitLyrics: String,
    @SerializedName("explicit_content_lyrics")
    val explicitContentLyrics: String,
    @SerializedName("explicit_content_cover")
    val explicitContentCover: String,
    val preview: String,
    @SerializedName("md5_image")
    val md5Image: String,
    @SerializedName("time_add")
    val timeAdd: String,
    val artist: Artist
)
