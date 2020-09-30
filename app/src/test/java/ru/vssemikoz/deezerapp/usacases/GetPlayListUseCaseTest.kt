package ru.vssemikoz.deezerapp.usacases

import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import ru.vssemikoz.deezerapp.data.repository.DeezerRepository
import ru.vssemikoz.deezerapp.features.usecase.GetPlayListsUseCase
import ru.vssemikoz.deezerapp.models.PlayList
import ru.vssemikoz.deezerapp.utils.generator.PlayListItemGenerator
import kotlin.properties.Delegates
import kotlin.test.assertFailsWith


@RunWith(MockitoJUnitRunner::class)
class GetPlayListUseCaseTest {
    private val examplePlayList: List<PlayList> = List(10) { PlayListItemGenerator.generate() }
    private val emptyPlayListList: List<PlayList> = emptyList()
    private var requestUserId by Delegates.notNull<Int>()

    @Mock
    lateinit var repository: DeezerRepository

    @InjectMocks
    lateinit var useCase: GetPlayListsUseCase

    @Before
    fun init() {
        requestUserId = 5
    }


    @Test
    fun verifyGetPlayListIsCalled() {
        useCase.run(requestUserId)
        verify(repository).getUserPlayLists(requestUserId)
    }

    @Test
    fun verifyGetPlayListReturnPlayListList() {
        `when`(repository.getUserPlayLists(requestUserId))
            .thenReturn(Observable.just(examplePlayList))
        useCase.run(requestUserId)
            .test()
            .assertValue(examplePlayList)
            .assertNoErrors()
    }

    @Test
    fun verifyGetPlayListReturnEmptyList() {
        `when`(repository.getUserPlayLists(requestUserId))
            .thenReturn(Observable.just(emptyPlayListList))
        useCase.run(requestUserId)
            .test()
            .assertValue(emptyPlayListList)
            .assertNoErrors()
    }

    @Test
    fun verifyGetPlayListThrowException() {
        `when`(repository.getUserPlayLists(requestUserId))
            .thenThrow((NullPointerException()))
        assertFailsWith(NullPointerException::class){
            useCase.run(requestUserId)
        }
    }
}
