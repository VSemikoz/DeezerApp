package ru.vssemikoz.deezerapp.utils

import ru.vssemikoz.deezerapp.base.BaseMapper
import ru.vssemikoz.deezerapp.models.DeezerApiPlayListsResponse
import ru.vssemikoz.deezerapp.models.PlayList

class PlayListMapper : BaseMapper<DeezerApiPlayListsResponse, List<PlayList>> {
    override fun map(mapObject: DeezerApiPlayListsResponse): List<PlayList> {
        val result = mutableListOf<PlayList>()
        mapObject.apiPlayListsResponse.forEach {
            result.add(
                PlayList(
                    cover = it.picture,
                    title = it.title,
                    author = it.creator.name,
                    duration = it.duration
                )
            )
        }
        return result
    }
}
