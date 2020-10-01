package ru.vssemikoz.deezerapp.data.repository

import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRemoteRepository(remoteDeezerRepository: RemoteDeezerRepository): DeezerRepository =
        remoteDeezerRepository
}
