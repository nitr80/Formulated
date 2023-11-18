package com.egeozturk.formulaappv04.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FormulaListModel(
    val listName: String,
    var formulaIndexList: List<Int>? = null,   //converter ekle ve search bari dene
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)