package com.egeozturk.formulaappv04.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FormulaLikedModel(
    val isLiked: Boolean = false,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
) {
}