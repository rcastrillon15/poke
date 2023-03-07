package com.poke.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.poke.data.source.local.PokeLocalDataSource

@Database(entities = [PokeEntity::class], version = 1)
abstract class PokeDataBase : RoomDatabase() {
    abstract fun pokeLocal(): PokeLocalDataSource
}