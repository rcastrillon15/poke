package com.poke.data.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
class ConverterDB {
    @TypeConverter
    fun fromResultToJSON(results: List<PokeEntity.Result>): String {
        return Gson().toJson(results)
    }
    @TypeConverter
    fun fromJSONToResult(results: String?): List<PokeEntity.Result> {
        val type: Type = object : TypeToken<List<PokeEntity.Result?>?>() {}.type
        return Gson().fromJson(results, type)
    }
}
