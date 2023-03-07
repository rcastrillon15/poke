package com.poke.data.di

import android.content.Context
import androidx.room.Room
import com.poke.common.Constants.DATABASE_NAME
import com.poke.data.db.PokeDataBase
import com.poke.data.source.local.PokeLocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun provideChannelDao(database: PokeDataBase): PokeLocalDataSource {
        return database.pokeLocal()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): PokeDataBase {
        return Room.databaseBuilder(
            appContext,
            PokeDataBase::class.java,
            DATABASE_NAME
        ).build()
    }
}
