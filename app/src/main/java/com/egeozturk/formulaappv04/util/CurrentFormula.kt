package com.egeozturk.formulaappv04.util

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.egeozturk.formulaappv04.R

object CurrentFormula {
    var currentFormulaName = mutableStateOf(R.string.app_name)
    var currentFormulaBranch: MutableState<Int?> = mutableStateOf(null)
    var currentlyInSolution = mutableStateOf(false)

}