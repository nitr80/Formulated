package com.egeozturk.formulaappv04.repo

import com.egeozturk.formulaappv04.database.FormulaLikeDao
import com.egeozturk.formulaappv04.model.FormulaLikedModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FormulaRepository @Inject constructor(private val formulaLikeDao: FormulaLikeDao) {
    suspend fun getAllFormulaLikes() : List<FormulaLikedModel> {
       return formulaLikeDao.getAllFormulaLikes()
    }

    suspend fun getOneFormulaLike(id: Int): Boolean {
        return formulaLikeDao.getOneFormulaLike(id)
    }

    suspend fun insertFormulaLike(vararg formulaLike: FormulaLikedModel) {
        formulaLikeDao.insertFormulaLike(*formulaLike)
    }

    suspend fun deleteFormulaLike(vararg formulaLike: FormulaLikedModel) {
        formulaLikeDao.deleteFormulaLike(*formulaLike)
    }

    suspend fun updateFormulaLike(vararg formulaLike: FormulaLikedModel) {
        formulaLikeDao.updateFormulaLike(*formulaLike)
    }

    suspend fun getLikedFormulaIndex(): List<Int> {
        return formulaLikeDao.getLikedFormulaIndex()
    }


}