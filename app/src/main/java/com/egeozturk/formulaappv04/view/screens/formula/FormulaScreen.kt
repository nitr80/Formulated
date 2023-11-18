package com.egeozturk.formulaappv04.view.screens.formula

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.view.FormulaButton
import com.egeozturk.formulaappv04.view.SearchBar
import com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel


@Composable
fun FormulaScreen (navController: NavController, viewModel: FormulaScreenViewModel = hiltViewModel()) {
    val general = R.string.general
    val maths = R.string.maths
    val chem = R.string.chemistry
    val phy = R.string.physics

    //prebranch i al ve filtrele

    CurrentFormula.currentFormulaName.value = R.string.app_name
    viewModel.getFavoriteList()

    val focusManager = LocalFocusManager.current

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.924f)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ){
            SearchBar() {
                viewModel.searchInFormulaList(it)
            }

            //Spacer(modifier = Modifier.padding(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {

                BranchButtonInFormulaScreen(branch = maths, color = if(viewModel.mathIsClicked.value) ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelLightBlueShade)
                else ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelLightBlue))

                BranchButtonInFormulaScreen(branch = chem, color = if(viewModel.chemIsClicked.value) ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelGreenShade)
                else ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelGreen))

                BranchButtonInFormulaScreen(branch = phy, color = if(viewModel.phyIsClicked.value) ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurpleShade)
                else ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurple))
            }
            FormulaListForSearch(formulaList = viewModel.searchResultList.value, navController)
        }
    }
}

@Composable
fun FormulaListForSearch(formulaList: List<FormulaModel>, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .clip(Shapes.small)
            .fillMaxWidth(.95f),        //burayi digerlerine de ekle
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(formulaList) {    formula ->
            FormulaButton(formula) {
                val formulaId = formula.id
                navController.navigate("${Screen.Solution.route}/${formulaId}") {
                    launchSingleTop = true
                    restoreState = false
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                }
            }
        }

    }
}

@Composable
fun BranchButtonInFormulaScreen (branch: Int, viewModel: FormulaScreenViewModel = hiltViewModel(), color: ButtonColors) {
    Button(
        modifier = Modifier
            //.fillMaxWidth(0.3f)
            //.height(60.dp)
            .padding(4.dp, 4.dp),
        colors = color,     //emulatoru calistir test et
        shape = Shapes.small,
        onClick = {
            viewModel.filterWithBranch(branch)
        }) {
        Text(text = stringResource(id = branch), style = MaterialTheme.typography.body2)
    }
}