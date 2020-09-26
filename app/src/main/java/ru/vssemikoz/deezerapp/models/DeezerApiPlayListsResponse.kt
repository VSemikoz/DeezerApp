package ru.vssemikoz.deezerapp.models

import com.google.gson.annotations.SerializedName

class DeezerApiPlayListsResponse {
    @SerializedName("data")
    var apiPlayListsResponse: List<ResponsePlayListItem> = emptyList()
}

