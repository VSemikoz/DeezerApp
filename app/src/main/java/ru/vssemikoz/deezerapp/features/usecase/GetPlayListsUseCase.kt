package ru.vssemikoz.deezerapp.features.usecase

import io.reactivex.rxjava3.core.Observable
import ru.vssemikoz.deezerapp.base.BaseUseCase
import ru.vssemikoz.deezerapp.data.repository.DeezerRepository
import ru.vssemikoz.deezerapp.models.PlayList
import javax.inject.Inject

class GetPlayListsUseCase @Inject constructor() : BaseUseCase<Observable<List<PlayList>>, Int> {
    @Inject
    lateinit var deezerRepository: DeezerRepository

    override fun run(params: Int): Observable<List<PlayList>> =
        deezerRepository.getUserPlayLists(params)
}
