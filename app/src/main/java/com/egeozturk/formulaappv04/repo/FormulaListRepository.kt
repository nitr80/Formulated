package com.egeozturk.formulaappv04.repo

import com.egeozturk.formulaappv04.database.FormulaListDao
import com.egeozturk.formulaappv04.model.FormulaListModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FormulaListRepository @Inject constructor(private val formulaListDao: FormulaListDao) {
    suspend fun getFormulaList() : List<FormulaListModel> {
        return formulaListDao.getFormulaLists()
    }

    suspend fun updateFormulaList(formulaList: FormulaListModel) {
        formulaListDao.updateFormulaList(formulaList)
    }

    suspend fun deleteFormulaList(formulaList: FormulaListModel) {
        formulaListDao.deleteFormulaList(formulaList)
    }

    suspend fun insertFormulaList(formulaList: FormulaListModel) {
        formulaListDao.insertFormulaList(formulaList)
    }

    suspend fun getCurrentFormulaList (listId: Int): FormulaListModel  {
        return formulaListDao.getCurrentFormulaList(listId)
    }


}