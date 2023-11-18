package com.egeozturk.formulaappv04.viewmodel

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.model.FormulaLikedModel
import com.egeozturk.formulaappv04.model.FormulaListModel
import com.egeozturk.formulaappv04.repo.FormulaListRepository
import com.egeozturk.formulaappv04.repo.FormulaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.egeozturk.formulaappv04.util.Formulas.formulaListInit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class FormulaScreenViewModel
@Inject constructor(
    private val formulaRepository: FormulaRepository,
    private val formulaListRepository: FormulaListRepository,
    @ApplicationContext private val context: Context
    ): ViewModel() {

    val general = R.string.general
    val maths = R.string.maths
    val chem = R.string.chemistry
    val phy = R.string.physics

    //SolutionScreen
    var isLiked = mutableStateOf(false)
    var variableArray = mutableStateOf(arrayOfNulls<Double?>(7))        //bununla yap

    fun getCurrentFormulaLike(id: Int) {
        viewModelScope.launch {
            isLiked.value = formulaRepository.getOneFormulaLike(id)
        }

    }


    fun changeFormulaLike (formulaLikedModel: FormulaLikedModel) {
        viewModelScope.launch {
            formulaRepository.updateFormulaLike(formulaLikedModel)
        }
    }

    //repository ye calculate fonksiyonu yaz ve burada cagir

    //FormulaScreen

    private val initialFormulaList = formulaListInit
    var searchResultList = mutableStateOf(initialFormulaList)

    var mathIsClicked = mutableStateOf(false)
    var chemIsClicked = mutableStateOf(false)
    var phyIsClicked = mutableStateOf(false)


    fun searchInFormulaList(query: String = "") {
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                searchResultList.value = initialFormulaList
            } else {
                searchResultList.value = initialFormulaList.filter {
                    context.getString(it.name).contains(query.trim(), ignoreCase = true)
                }
            }
        }
    }

    var previousBranch by mutableStateOf(general)

    fun filterWithBranch(branch: Int) {

        if (previousBranch != branch) {       //istedigin gibi degil tam
            viewModelScope.launch(Dispatchers.Default) {
                searchResultList.value = initialFormulaList.filter {
                    it.branch == branch
                }
                previousBranch = branch
            }
            when (branch) {
                maths -> {
                    mathIsClicked.value = true
                    chemIsClicked.value = false
                    phyIsClicked.value = false
                }
                chem -> {
                    mathIsClicked.value = false
                    chemIsClicked.value = true
                    phyIsClicked.value = false
                }
                phy -> {
                    mathIsClicked.value = false
                    chemIsClicked.value = false
                    phyIsClicked.value = true
                }
            }
        } else {
            searchResultList.value = initialFormulaList
            previousBranch = general
            mathIsClicked.value = false
            chemIsClicked.value = false
            phyIsClicked.value = false
        }
    }

    //listeye ekleme kismi hallet
    //AddToListScreen

    var formulaLists = mutableStateOf(listOf<FormulaListModel>())

    fun getLists() {
        viewModelScope.launch {
            formulaLists.value = formulaListRepository.getFormulaList()
        }
    }

    val likedFormulaIxList = mutableStateOf(listOf<Int>())
    fun getFavoriteList() {
        viewModelScope.launch {
            likedFormulaIxList.value = formulaRepository.getLikedFormulaIndex()

            //searchInFormulaList()
        }
    }

    fun updateFormulaList(formulaListModel: FormulaListModel, formulaIndex: Int) {
        viewModelScope.launch {
            var updateListModel = mutableStateOf<FormulaListModel>(formulaListModel)
            updateListModel.value.formulaIndexList = updateListModel.value.formulaIndexList?.plus(
                formulaIndex
            )

            formulaListRepository.updateFormulaList(updateListModel.value)
        }
    }

}