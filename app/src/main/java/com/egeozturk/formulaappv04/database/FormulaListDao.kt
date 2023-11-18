package com.egeozturk.formulaappv04.database

import androidx.room.*
import com.egeozturk.formulaappv04.model.FormulaListModel
import com.egeozturk.formulaappv04.model.FormulaModel

@Dao
interface FormulaListDao {

    @Query("SELECT * FROM FormulaListModel")
    suspend fun getFormulaLists (): List<FormulaListModel>

    @Query("SELECT * FROM FormulaListModel WHERE id = :id")
    suspend fun getCurrentFormulaList(id: Int) : FormulaListModel

    @Delete
    suspend fun deleteFormulaList(vararg formulaList: FormulaListModel)

    @Update
    suspend fun updateFormulaList(vararg formulaList: FormulaListModel)

    @Insert
    suspend fun insertFormulaList(vararg formulaList: FormulaListModel)
}