package com.egeozturk.formulaappv04.viewmodel

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.model.FormulaListModel
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.repo.FormulaListRepository
import com.egeozturk.formulaappv04.repo.FormulaRepository
import com.egeozturk.formulaappv04.util.Formulas
import com.egeozturk.formulaappv04.util.Formulas.formulaListInit
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.ref.WeakReference
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel
@Inject constructor(
    private val formulaRepository: FormulaRepository,
    private val formulaListRepository: FormulaListRepository,
    @ApplicationContext private val context: Context)
: ViewModel() {

    private val general = R.string.general
    private val maths = R.string.maths
    private val chem = R.string.chemistry
    private val phy = R.string.physics

    //ListScreen

    var formulaListsList = mutableStateOf(listOf<FormulaListModel>())
    var favoriteList = mutableStateOf(listOf<FormulaModel>())
    var deleteClicked = mutableStateOf(false)

    fun getFormulaLists () {
        viewModelScope.launch {
            formulaListsList.value = formulaListRepository.getFormulaList()
        }
    }



    fun getFavoriteList() {
        viewModelScope.launch {
            val indexList = mutableStateOf(formulaRepository.getLikedFormulaIndex())
            indexList.value.forEach {
                favoriteList.value += formulaListInit[it -1]
            }
        }
    }

    //AddFormulaForNewListScreen

    private val initialFormulaList = mutableStateOf(formulaListInit)
    var searchResultList = mutableStateOf(initialFormulaList.value)

    var checkedFormulaIndexList = mutableStateListOf<Int>()

    var mathIsClicked = mutableStateOf(false)
    var chemIsClicked = mutableStateOf(false)
    var phyIsClicked = mutableStateOf(false)
    var previousBranch = mutableStateOf(general)

    var currentListModel = mutableStateOf(FormulaListModel(""))
    var currentList = mutableStateOf(listOf<FormulaModel>())

    fun getCurrentFormulaIndexList(listId: Int) {
        viewModelScope.launch {
            currentListModel.value = formulaListRepository.getCurrentFormulaList(listId)
            currentListModel.value.formulaIndexList?.forEach {
                currentList.value += formulaListInit[it - 1]
            }
        }
    }

    fun searchInFormulaList(query: String) {

        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                searchResultList.value = initialFormulaList.value
            } else {
                searchResultList.value = initialFormulaList.value.filter {
                    val string: String = context.getString(it.name)
                    string.contains(query.trim(), ignoreCase = true)
                }
            }
        }
    }


    fun filterWithBranch(branch: Int) {

        if (previousBranch.value != branch) {       //istedigin gibi degil tam
            viewModelScope.launch(Dispatchers.Default) {
                searchResultList.value = initialFormulaList.value.filter {
                    it.branch == branch
                }
                previousBranch.value = branch
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
            previousBranch.value = general
            mathIsClicked.value = false
            chemIsClicked.value = false
            phyIsClicked.value = false
        }
    }

    fun insertFormulaList(formulaListModel: FormulaListModel) {
        viewModelScope.launch {
            formulaListRepository.insertFormulaList(formulaListModel)
        }
    }

    fun updateFormulaList() {
        viewModelScope.launch {
            checkedFormulaIndexList.forEach {
                currentListModel.value.formulaIndexList = currentListModel.value.formulaIndexList?.plus(it)
            }
            formulaListRepository.updateFormulaList(currentListModel.value)
        }
    }

    fun deleteFormulaList(formulaList : FormulaListModel) {
        viewModelScope.launch {
            formulaListRepository.deleteFormulaList(formulaList)
        }
    }


}