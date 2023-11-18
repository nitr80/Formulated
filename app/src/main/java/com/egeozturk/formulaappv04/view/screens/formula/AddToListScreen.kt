package com.egeozturk.formulaappv04.view.screens.formula

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel
import dagger.hilt.android.qualifiers.ApplicationContext


@Composable
fun AddToListScreen(navController: NavController, formulaId: Int, viewModel: FormulaScreenViewModel = hiltViewModel()) {

    viewModel.getLists()

    val listListFromDb by remember {
        viewModel.formulaLists
    }

    val context = LocalContext.current
    val toastText = stringResource(id = R.string.formula_already_added)

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.924f)) {

        Column() {
            Text(
                text = stringResource(id = R.string.select_list),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            LazyColumn() {
                items(listListFromDb) { list ->
                    ListButtonForAddList(listName = list.listName) {
                        //add to database
                        if (list.formulaIndexList?.contains(formulaId) == false) {
                            viewModel.updateFormulaList(list, formulaId)
                        } else {
                            Toast.makeText(context, toastText, Toast.LENGTH_LONG).show()
                        }
                        navController.popBackStack()        //onceki ekrana gidiyor

                    }
                }
            }
            

        }
    }
}

@Composable
fun ListButtonForAddList(listName: String, onClick: ()-> Unit ) {
    Button(onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 5.dp)
            .aspectRatio(4f),
        shape = Shapes.small,
        //colors = ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelBlue)
        colors = ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurple)
    ) {
        Text(text = listName, style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
    }
}