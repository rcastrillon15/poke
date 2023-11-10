package com.poke.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [PokeEntity::class], version = 1)
@TypeConverters(ConverterDB::class)
abstract class PokeDataBase : RoomDatabase() {
    abstract fun pokeLocal(): PokeLocalQuery
}
