package com.egeozturk.formulaappv04.database

import androidx.room.*
import com.egeozturk.formulaappv04.model.FormulaLikedModel

@Dao
interface FormulaLikeDao {
    @Query("SELECT * FROM FormulaLikedModel")
    suspend fun getAllFormulaLikes() : List<FormulaLikedModel>

    @Query("SELECT isLiked FROM FormulaLikedModel WHERE id = :id")
    suspend fun getOneFormulaLike(id: Int): Boolean

    @Query("SELECT id FROM FormulaLikedModel WHERE isLiked = 1")
    suspend fun getLikedFormulaIndex(): List<Int>

    @Insert
    suspend fun insertFormulaLike(vararg formulaLike: FormulaLikedModel)

    @Update
    suspend fun updateFormulaLike(vararg formulaLike: FormulaLikedModel)

    @Delete
    suspend fun deleteFormulaLike(vararg formulaLike: FormulaLikedModel)


}