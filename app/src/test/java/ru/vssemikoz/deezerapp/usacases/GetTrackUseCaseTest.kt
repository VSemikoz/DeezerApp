package ru.vssemikoz.deezerapp.usacases

import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import ru.vssemikoz.deezerapp.data.repository.DeezerRepository
import ru.vssemikoz.deezerapp.features.usecase.GetTrackUseCase
import ru.vssemikoz.deezerapp.models.Track
import ru.vssemikoz.deezerapp.utils.generator.TrackItemGenerator
import kotlin.properties.Delegates
import kotlin.test.assertFailsWith


@RunWith(MockitoJUnitRunner::class)
class GetTrackUseCaseTest {
    private val exampleTrackList: List<Track> = List(10) { TrackItemGenerator.generate() }
    private val emptyTrackListList: List<Track> = emptyList()
    private var requestPlayListId by Delegates.notNull<Int>()

    @Mock
    lateinit var repository: DeezerRepository

    @InjectMocks
    lateinit var useCase: GetTrackUseCase

    @Before
    fun init() {
        requestPlayListId = 5
    }


    @Test
    fun verifyGetTrackListIsCalled() {
        useCase.run(requestPlayListId)
        Mockito.verify(repository).getTracksFromPlayList(requestPlayListId)
    }

    @Test
    fun verifyGetTrackReturnTrackListList() {
        Mockito.`when`(repository.getTracksFromPlayList(requestPlayListId))
            .thenReturn(Observable.just(exampleTrackList))
        useCase.run(requestPlayListId)
            .test()
            .assertValue(exampleTrackList)
            .assertNoErrors()
    }

    @Test
    fun verifyGetTrackReturnEmptyList() {
        Mockito.`when`(repository.getTracksFromPlayList(requestPlayListId))
            .thenReturn(Observable.just(emptyTrackListList))
        useCase.run(requestPlayListId)
            .test()
            .assertValue(emptyTrackListList)
            .assertNoErrors()
    }

    @Test
    fun verifyGetTrackListThrowException() {
        Mockito.`when`(repository.getTracksFromPlayList(requestPlayListId))
            .thenThrow((NullPointerException()))
        assertFailsWith(NullPointerException::class){
            useCase.run(requestPlayListId)
        }
    }
}
