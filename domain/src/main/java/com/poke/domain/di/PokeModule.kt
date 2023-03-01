package com.poke.domain.di

import com.poke.data.source.remote.PokeRemoteDataSource
import com.poke.domain.repository.PokeRepository
import com.poke.domain.repository.PokeRepositoryImpl
import com.poke.domain.usecase.PokeUseCase
import com.poke.domain.usecase.PokeUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PokeModule {
    @Provides
    fun providerRepository(remoteDataSource: PokeRemoteDataSource): PokeRepository = PokeRepositoryImpl(
        remoteDataSource = remoteDataSource
    )

    @Provides
    fun providerUseCase(repository: PokeRepository): PokeUseCase =
        PokeUseCaseImpl(repository = repository)
}
