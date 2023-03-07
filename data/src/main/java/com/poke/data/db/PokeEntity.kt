package com.poke.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poke")
data class PokeEntity(
    @PrimaryKey(autoGenerate = true)
    val _id: Int = 0,
    @ColumnInfo(name = "id")
    val id: String
)
