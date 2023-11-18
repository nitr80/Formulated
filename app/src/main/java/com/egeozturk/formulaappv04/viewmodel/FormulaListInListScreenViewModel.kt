package com.egeozturk.formulaappv04.viewmodel

import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egeozturk.formulaappv04.model.FormulaListModel
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.repo.FormulaListRepository
import com.egeozturk.formulaappv04.repo.FormulaRepository
import com.egeozturk.formulaappv04.util.Formulas.formulaListInit
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.egeozturk.formulaappv04.R
import dagger.hilt.android.qualifiers.ApplicationContext

@HiltViewModel
class FormulaListInListScreenViewModel @Inject constructor(
    private val formulaListRepository: FormulaListRepository,
    private val formulaRepository: FormulaRepository,
    @ApplicationContext private val context: Context
): ViewModel() {

    private val general = R.string.general
    private val maths = R.string.maths
    private val chem = R.string.chemistry
    private val phy = R.string.physics

    val formulaListInListDB = mutableStateOf(FormulaListModel("", listOf(), -1))
    var initialFormulaList = mutableStateOf<List<FormulaModel>>(listOf())
    var searchResultList = mutableStateOf(initialFormulaList.value)
    var deleteList = mutableStateListOf<Int>()


    var mathIsClicked = mutableStateOf(false)
    var chemIsClicked = mutableStateOf(false)
    var phyIsClicked = mutableStateOf(false)

    var previousBranch by mutableStateOf(general)

    fun getCurrentFormulaList(listId: Int){

        viewModelScope.launch {
            formulaListInListDB.value = formulaListRepository.getCurrentFormulaList(listId)
            createInitList()
            //buraya bir bak, kodu uste aldim

            searchInFormulaList()
        }

    }

    private fun createInitList() {
        formulaListInListDB.value.formulaIndexList?.forEach {
            if (initialFormulaList.value.size < formulaListInListDB.value.formulaIndexList!!.size)
                initialFormulaList.value += formulaListInit[it - 1]
        }
        println("CreateListInit1: " + formulaListInListDB.value.formulaIndexList)
    }

    fun updateFormulaList() {
        viewModelScope.launch {
            var updateList = formulaListInListDB.value.formulaIndexList?.toMutableList()
            deleteList.forEach {
                updateList?.remove(it)
            }
            formulaListInListDB.value.formulaIndexList = updateList
            formulaListRepository.updateFormulaList(formulaListInListDB.value)
            //initialFormulaList.value
            val tempList = mutableListOf<FormulaModel>()
            updateList?.forEach {
                if (initialFormulaList.value.size < updateList.size)
                    tempList += formulaListInit[it - 1]
            }
            initialFormulaList.value = tempList
        }
    }

    fun getFavoriteList() {
        viewModelScope.launch {
            val indexList = mutableStateOf(formulaRepository.getLikedFormulaIndex())
            indexList.value.forEach {
                initialFormulaList.value += formulaListInit[it - 1]
            }
            searchInFormulaList()
        }
    }

    val likedFormulaIxList = mutableStateOf(listOf<Int>())
    fun getFavoriteListForButton() {
        viewModelScope.launch {
            likedFormulaIxList.value = formulaRepository.getLikedFormulaIndex()

            //searchInFormulaList()
        }
    }

    fun searchInFormulaList(query: String = "") {

        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                searchResultList.value = initialFormulaList.value
            } else {
                searchResultList.value = initialFormulaList.value.filter {

                    context.getString(it.name).contains(query.trim(), ignoreCase = true)
                }

            }
        }
    }

    fun filterWithBranch(branch: Int) {

        if (previousBranch != branch) {       //istedigin gibi degil tam
            viewModelScope.launch(Dispatchers.Default) {
                searchResultList.value = initialFormulaList.value.filter {
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
            searchResultList.value = initialFormulaList.value
            previousBranch = general
            mathIsClicked.value = false
            chemIsClicked.value = false
            phyIsClicked.value = false
        }
    }
}