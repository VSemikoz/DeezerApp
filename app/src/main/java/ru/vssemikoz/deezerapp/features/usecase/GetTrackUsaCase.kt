package ru.vssemikoz.deezerapp.features.usecase

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.base.BaseUseCase
import ru.vssemikoz.deezerapp.data.DeezerRepository
import ru.vssemikoz.deezerapp.models.Track
import javax.inject.Inject

class GetTrackUsaCase @Inject constructor() : BaseUseCase<Observable<List<Track>>, Int> {
    @Inject
    lateinit var deezerRepository: DeezerRepository

    override fun run(params: Int): Observable<List<Track>> =
        deezerRepository.getTracksFromPlayListLists(params)
}
