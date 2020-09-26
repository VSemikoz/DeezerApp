package ru.vssemikoz.deezerapp.models

import com.google.gson.annotations.SerializedName

class DeezerApiTrackResponse {
    @SerializedName("data")
    var apiTrackResponse: List<ResponseTrackItem> = emptyList()
}
