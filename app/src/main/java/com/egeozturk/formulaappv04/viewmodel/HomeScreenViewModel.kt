package com.egeozturk.formulaappv04.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egeozturk.formulaappv04.model.FormulaLikedModel
import com.egeozturk.formulaappv04.repo.FormulaRepository
import com.egeozturk.formulaappv04.util.Formulas.formulaListInit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel
@Inject constructor(private val formulaRepository: FormulaRepository) : ViewModel() {

    lateinit var formulaLikeList: List<FormulaLikedModel>
    var formulaLikeArrayForInit = Array(formulaListInit.size) {FormulaLikedModel()}

    fun checkLikes() = viewModelScope.launch {
        formulaLikeList = formulaRepository.getAllFormulaLikes()
        var elementDifference = formulaListInit.size - formulaLikeList.size
        if (formulaLikeList.isEmpty()) {
            formulaRepository.insertFormulaLike(*formulaLikeArrayForInit)
            formulaLikeList = formulaLikeArrayForInit.toList()
        } else if (elementDifference != 0) {
            while (elementDifference > 0) {
                formulaRepository.insertFormulaLike(FormulaLikedModel())
                elementDifference--
            }
        }
    }

    init {
        checkLikes()
        println("TEKRAR")
    }

}