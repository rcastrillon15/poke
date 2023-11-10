package com.poke.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "poke")
data class PokeEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "count")
    val count: Int,
    @ColumnInfo(name = "next")
    val next: String,
    @ColumnInfo(name = "results")
    val results: List<Result>
) {
    data class Result(
        val name: String,
        val url: String
    )
}
