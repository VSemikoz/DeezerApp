package ru.vssemikoz.deezerapp.utils.mappers

import ru.vssemikoz.deezerapp.base.BaseMapper
import ru.vssemikoz.deezerapp.models.DeezerApiTrackResponse
import ru.vssemikoz.deezerapp.models.Track

class TrackMapper : BaseMapper<DeezerApiTrackResponse, List<Track>> {
    override fun map(mapObject: DeezerApiTrackResponse): List<Track> {
        val result = mutableListOf<Track>()
        mapObject.apiTrackResponse.forEach {
            result.add(
                Track(
                    title = it.title,
                    artist = it.artist,
                    duration = it.duration.toInt()
                )
            )
        }
        return result
    }
}
