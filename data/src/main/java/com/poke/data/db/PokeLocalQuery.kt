package com.poke.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface PokeLocalQuery {
    @Transaction
    suspend fun transaction(entity: PokeEntity) {
        delete()
        insert(entity)
    }

    @Query("SELECT * FROM poke")
    fun select(): PokeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: PokeEntity)

    @Query("DELETE FROM poke")
    fun delete()
}
