package ru.vssemikoz.deezerapp.features.usecase

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.base.BaseUseCase
import ru.vssemikoz.deezerapp.data.repository.DeezerRepository
import ru.vssemikoz.deezerapp.models.Track
import javax.inject.Inject

class GetTrackUseCase @Inject constructor() : BaseUseCase<Observable<List<Track>>, String> {
    @Inject
    lateinit var deezerRepository: DeezerRepository

    override fun run(params: String): Observable<List<Track>> =
        deezerRepository.getTracksFromPlayList(params)
}
