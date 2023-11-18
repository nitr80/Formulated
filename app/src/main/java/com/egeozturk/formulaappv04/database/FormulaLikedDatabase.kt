package com.egeozturk.formulaappv04.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.egeozturk.formulaappv04.model.FormulaLikedModel

@Database(entities = [FormulaLikedModel::class], version = 1)
abstract class FormulaLikedDatabase: RoomDatabase() {
    abstract fun formulaLikedDao(): FormulaLikeDao
}