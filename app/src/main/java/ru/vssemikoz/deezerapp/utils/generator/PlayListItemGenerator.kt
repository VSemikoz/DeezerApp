package ru.vssemikoz.deezerapp.utils.generator

import ru.vssemikoz.deezerapp.base.BaseGenerator
import ru.vssemikoz.deezerapp.models.PlayList
import java.util.*

object PlayListItemGenerator : BaseGenerator<PlayList> {
    override fun generate(): PlayList {
        val random = Random()
        return PlayList(
            id = "${random.nextInt()}",
            coverSmall = "${random.nextInt()}",
            coverBig = "${random.nextInt()}",
            title = "${random.nextInt()}",
            author = "${random.nextInt()}",
            duration = random.nextInt()
        )
    }
}
