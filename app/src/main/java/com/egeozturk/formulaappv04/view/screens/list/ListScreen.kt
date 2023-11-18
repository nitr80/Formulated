package com.egeozturk.formulaappv04.view.screens.list

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.model.FormulaListModel
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.util.Formulas.formulaListInit
import com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel

@Composable
fun ListScreen (navController: NavController, viewModel: ListScreenViewModel = hiltViewModel()) {


    viewModel.getFavoriteList()
    viewModel.getFormulaLists()

    CurrentFormula.currentFormulaName.value = R.string.app_name

    var listsList by remember {
        viewModel.formulaListsList
    }

    if (viewModel.deleteClicked.value) {
        listsList = viewModel.formulaListsList.value
      viewModel.deleteClicked.value = false
    }

    Surface(modifier = Modifier
        .fillMaxHeight(.924f)
        .fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row (modifier = Modifier.fillMaxWidth(.95f).aspectRatio(2.5f)) {
                FavoriteList() {
                    navController.navigate("${Screen.FormulaListInListScreen.route}/${0}") {
                        launchSingleTop = true
                        restoreState = false
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                    }
                }
                AddListButton(navController)
            }
            LazyColumn(
                modifier = Modifier
                    .clip(Shapes.small)
                    .fillMaxWidth(.95f)
            ) {
                items(listsList) {
                    ListButton(name = it.listName, formulaNameList = it.formulaIndexList ?: listOf(), it.id!!) {
                        navController.navigate("${Screen.FormulaListInListScreen.route}/${it.id}") {
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

    }
}


@Composable
fun FavoriteList (onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth(0.66f)
            .fillMaxHeight()
            //.height(150.dp)
            .padding(0.dp, 10.dp, 5.dp, 5.dp),
        shape = Shapes.small,
        colors = ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelGreen)
    ) {
        Column() {
            Text(
                text = stringResource(id = R.string.liked_formulas),
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(4.dp)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            //LazyRow(userScrollEnabled = false) {
            //    items(favoriteList) {
            //        Text(text = "${it.name}, ")
            //    }
            //}
        }

    }
}


@Composable
fun AddListButton (navController: NavController) {
    Button(
        modifier = Modifier
            .fillMaxSize()
            //.height(150.dp)
            .padding(5.dp, 10.dp, 0.dp, 5.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelLightBlue),
        shape = Shapes.small,
        onClick = {
            navController.navigate(Screen.AddList.route) {
                launchSingleTop = true
                restoreState = false
            }
        }) {
        Text(
            text = stringResource(id = R.string.add_list),
            fontSize = 28.sp,
            textAlign = TextAlign.Center
        )
    }
}


@Composable
fun ListButton (name: String, formulaNameList: List<Int>, listId: Int, viewModel: ListScreenViewModel = hiltViewModel(), onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.height(150.dp)
            .padding(0.dp, 5.dp)
            .clickable(onClick = onClick)
            .aspectRatio(2.5f)
            .clip(Shapes.small),
        //shape = Shapes.small,
        backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurple,
    )
    {

        var openDialog by remember { mutableStateOf(false) }

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(15.dp, 0.dp)
            ) {
                Text(
                    text = name,
                    fontWeight = FontWeight.Normal,
                    fontSize = 28.sp,
                    modifier = Modifier.padding(end = 24.dp).horizontalScroll(state = ScrollState(0)),
                    maxLines = 1
                )

                Spacer(modifier = Modifier.padding(5.dp))
                /*LazyRow(
                    userScrollEnabled = false,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(formulaNameList) {
                        Text(
                            text = "${stringResource(id = formulaListInit[it - 1].name)}, ",
                            maxLines = 3,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }

                 */

                Box(Modifier.fillMaxWidth()) {
                    var formulaNameListString = ""
                    for (formulaNameIx in formulaNameList) {
                        formulaNameListString += "${stringResource(id = formulaListInit[formulaNameIx - 1].name)}, "
                    }
                    Text(
                        text = formulaNameListString.removeRange(formulaNameListString.length - 2, formulaNameListString.length),
                        maxLines = 3
                    )
                }

            }

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(
                    modifier = Modifier
                        .size(39.dp)
                        .padding(8.dp),
                    onClick = { openDialog = true }
                    //ikonu gorunur yap
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.trash_can_icon),
                        contentDescription = null,
                        //modifier = Modifier.size(35.dp)
                    )
                }
            }
        }



        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false },
                shape = Shapes.small,
                title = {
                    Text(text = stringResource(id = R.string.delete_list), color = MaterialTheme.colors.primaryVariant)
                },
                text = {
                    Text(
                        text = stringResource(id = R.string.delete_list_text),
                        color = MaterialTheme.colors.primary
                    )
                },
                buttons = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .weight(5f)
                                .padding(4.dp),
                            shape = Shapes.small,
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                            onClick = { openDialog = false }
                        ) {
                            Text(stringResource(id = R.string.cancel))
                        }
                        Button(
                            modifier = Modifier
                                .weight(5f)
                                .padding(4.dp),
                            shape = Shapes.small,
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                            onClick = {
                                openDialog = false
                                viewModel.deleteFormulaList(
                                    FormulaListModel(
                                        name,
                                        formulaNameList,
                                        listId
                                    )
                                )
                                viewModel.deleteClicked.value = true

                            }
                        ) {
                            Text(stringResource(id = R.string.delete))
                        }
                    }
                }
            )
        }

    }
}

