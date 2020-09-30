package ru.vssemikoz.deezerapp.utils.generator

import ru.vssemikoz.deezerapp.base.BaseGenerator
import ru.vssemikoz.deezerapp.models.Artist
import ru.vssemikoz.deezerapp.models.Track
import java.util.*

object TrackItemGenerator : BaseGenerator<Track> {
    override fun generate(): Track {
        val random = Random()
        return Track(
            title = "${random.nextInt()}",
            artist = Artist(
                id = "${random.nextInt()}",
                name = "${random.nextInt()}",
                link = "${random.nextInt()}",
                picture = "${random.nextInt()}",
                picture_small = "${random.nextInt()}",
                picture_medium = "${random.nextInt()}",
                picture_big = "${random.nextInt()}",
                picture_xl = "${random.nextInt()}",
                tracklist = "${random.nextInt()}",
                type = "${random.nextInt()}"
            ),
            duration = random.nextInt()
        )
    }
}
