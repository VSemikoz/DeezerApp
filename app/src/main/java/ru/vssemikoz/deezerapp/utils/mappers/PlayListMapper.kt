package ru.vssemikoz.deezerapp.utils.mappers

import ru.vssemikoz.deezerapp.base.BaseMapper
import ru.vssemikoz.deezerapp.models.DeezerApiPlayListsResponse
import ru.vssemikoz.deezerapp.models.PlayList

class PlayListMapper : BaseMapper<DeezerApiPlayListsResponse, List<PlayList>> {
    override fun map(mapObject: DeezerApiPlayListsResponse): List<PlayList> {
        val result = mutableListOf<PlayList>()
        mapObject.apiPlayListsResponse.forEach {
            result.add(
                PlayList(
                    cover = it.pictureMedium,
                    title = it.title.reduceString(15),
                    author = it.creator.name,
                    duration = it.duration
                )
            )
        }
        return result
    }

    private fun String.reduceString(reduceLength: Int): String = if (reduceLength > length) this
    else "${substring(0, reduceLength)}..."
}
