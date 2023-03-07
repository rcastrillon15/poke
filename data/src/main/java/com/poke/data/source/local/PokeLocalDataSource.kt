package com.poke.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.poke.data.db.PokeEntity

@Dao
interface PokeLocalDataSource {
    @Transaction
    suspend fun transaction(entity: List<PokeEntity>) {
        delete()
        insert(entity)
    }

    @Query("SELECT * FROM poke")
    fun select(): List<PokeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(entity: List<PokeEntity>)

    @Query("DELETE FROM poke")
    fun delete()
}
