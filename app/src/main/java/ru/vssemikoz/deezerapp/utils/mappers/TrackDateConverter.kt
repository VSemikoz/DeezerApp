package ru.vssemikoz.deezerapp.utils.mappers

import ru.vssemikoz.deezerapp.base.BaseMapper
import java.text.SimpleDateFormat
import java.util.*

object TrackDateConverter : BaseMapper<Int, String> {
    override fun map(mapObject: Int): String {
        val date = Date(mapObject * 1000L)
        val sdf = SimpleDateFormat("mm:ss", Locale.ENGLISH)
        sdf.timeZone = TimeZone.getTimeZone("UTC")
        return sdf.format(date)
    }
}
