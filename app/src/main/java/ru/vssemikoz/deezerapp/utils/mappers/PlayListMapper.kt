package ru.vssemikoz.deezerapp.utils.mappers

import ru.vssemikoz.deezerapp.base.BaseMapper
import ru.vssemikoz.deezerapp.models.DeezerApiPlayListsResponse
import ru.vssemikoz.deezerapp.models.PlayList

object PlayListMapper : BaseMapper<DeezerApiPlayListsResponse, List<PlayList>> {
    override fun map(mapObject: DeezerApiPlayListsResponse): List<PlayList> {
        val result = mutableListOf<PlayList>()
        mapObject.apiPlayListsResponse.forEach {
            result.add(
                PlayList(
                    id = it.id,
                    coverSmall = it.pictureMedium,
                    coverBig = it.pictureBig,
                    title = it.title,
                    author = it.creator.name,
                    duration = it.duration.toInt()
                )
            )
        }
        return result
    }
}
