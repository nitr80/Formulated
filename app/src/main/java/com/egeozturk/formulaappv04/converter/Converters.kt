package com.egeozturk.formulaappv04.converter

import androidx.room.TypeConverter
import com.egeozturk.formulaappv04.model.FormulaModel
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

class Converters {
    @TypeConverter
    fun fromList(value : List<Int>) = Json.encodeToString(value)

    @TypeConverter
    fun toList(value: String) = Json.decodeFromString<List<Int>>(value)
}