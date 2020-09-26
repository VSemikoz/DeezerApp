package ru.vssemikoz.deezerapp.data.repository

import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideRepository(remoteDeezerRepository: RemoteDeezerRepository): DeezerRepository =
        remoteDeezerRepository
}
