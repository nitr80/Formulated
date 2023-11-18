package com.egeozturk.formulaappv04.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.egeozturk.formulaappv04.converter.Converters
import com.egeozturk.formulaappv04.model.FormulaListModel

@Database(entities = [FormulaListModel::class], version = 1)
@TypeConverters(Converters::class)
abstract class FormulaListDatabase: RoomDatabase() {
    abstract fun formulaListDao() : FormulaListDao
}