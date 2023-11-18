package com.egeozturk.formulaappv04.view.screens.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.view.SearchBar
import com.egeozturk.formulaappv04.viewmodel.FormulaListInListScreenViewModel


@Composable
fun FormulaListInListScreen (navController: NavController, formulaListIndex: Int, viewModel: FormulaListInListScreenViewModel = hiltViewModel()) {

    val maths = R.string.maths
    val chem = R.string.chemistry
    val phy = R.string.physics

    viewModel.getFavoriteListForButton()

    if (viewModel.initialFormulaList.value.isEmpty()) {
        if (formulaListIndex != 0) {
            viewModel.getCurrentFormulaList(formulaListIndex)
        } else {
            viewModel.getFavoriteList()
        }
    }


    var deleteMode by remember { mutableStateOf(false) }

    val searchList by remember {
        viewModel.searchResultList
    }


    Surface(modifier = Modifier.fillMaxHeight(.924f).fillMaxWidth()) {
        Box() {
            Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
                SearchBar() {
                    viewModel.searchInFormulaList(it)
                }
                //Spacer(modifier = Modifier.padding(5.dp))
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {

                    BranchButtonInListInListScreen(
                        branch = maths,
                        color = if (viewModel.mathIsClicked.value)
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelLightBlueShade)       //buranin renklerini koy
                        else
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelLightBlue)
                    )

                    BranchButtonInListInListScreen(
                        branch = chem,
                        color = if (viewModel.chemIsClicked.value)
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelGreenShade)
                        else
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelGreen)
                    )

                    BranchButtonInListInListScreen(
                        branch = phy,
                        color = if (viewModel.phyIsClicked.value)
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurpleShade)
                        else
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurple)
                    )
                }
                // FormulaListForList(formulaList = formulaList, navController = navController, deleteIsClicked,  deleteMode)
                LazyColumn(
                    modifier = Modifier
                        .clip(Shapes.small)
                        .fillMaxWidth(.95f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(searchList) {    formula ->
                        FormulaButtonForList(formula = formula, navController = navController, deleteMode = deleteMode, viewModel)
                    }

                }


            }

            if (formulaListIndex != 0) {
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
                    AddButtonForList(navController, deleteMode, formulaListIndex)
                    DeleteOptionButtonForList(deleteMode = deleteMode) {
                        if (deleteMode) {
                            viewModel.deleteList.clear()
                        }
                        deleteMode = !deleteMode
                    }
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                        DeleteButtonForList (deleteMode) {
                            viewModel.updateFormulaList()
                            deleteMode = false              //asil projede bunun testine dikkat et bazen duzgun calismiyo
                            //viewModel.initialFormulaList.value = listOf()
                            //viewModel.getCurrentFormulaList(formulaListIndex)

                            //bi sekilde veri tabanindan veriler silindikten sonra deleteIsClicked ve deleteMode'u false yap
                            //belki coroutine kullanarak olabilir
                        }
                    }

                }
            }

        }

    }

}

/*
@Composable
fun FormulaListForList(formulaList: List<FormulaModel>, navController: NavController, deleteIsClicked: Boolean, deleteMode: Boolean, onDeleteModeChanged: (Offset) -> Unit) {
    LazyColumn() {
        println(formulaList.size)
        items(formulaList) {    formula ->
            println("Liste" + deleteMode)
            FormulaButtonForList(formula = formula, navController = navController, deleteIsClicked = deleteIsClicked, deleteMode = deleteMode, viewModel = )
        }

    }
}

 */

@Composable
fun FormulaButtonForList (formula: FormulaModel, navController: NavController, deleteMode: Boolean, viewModel: FormulaListInListScreenViewModel) {
    var checkedState by remember { mutableStateOf(false) }
    var selectedButtonColor by remember { mutableStateOf(formula.color) }

    selectedButtonColor = if (viewModel.deleteList.contains(formula.id) && deleteMode) {
        MaterialTheme.colors.primary
    } else {
        formula.color
    }

    Card(
        backgroundColor =  selectedButtonColor,
        shape = Shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            //.height(96.dp)
            .padding(0.dp, 5.dp)
            .aspectRatio(4f)
            .clickable {
                if (!deleteMode) {
                    navController.navigate("${Screen.Solution.route}/${formula.id}") {
                        launchSingleTop = true
                        restoreState = false
                    }
                } else {
                    checkedState = !checkedState
                    if (checkedState) {
                        viewModel.deleteList.add(formula.id)
                    } else {
                        viewModel.deleteList.remove(formula.id)
                    }
                }
            }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp,5.dp,8.dp,8.dp)
                    .fillMaxSize()
            ) {
                Icon(painter = painterResource(id = formula.icon), contentDescription = null,
                    Modifier
                        .padding(4.dp)
                        .fillMaxHeight())
                Column (
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(.9f)
                        .padding(start = 8.dp, end = 4.dp)
                ){
                    Text(
                        text = stringResource(id = formula.name),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 3,
                        //modifier = Modifier.fillMaxHeight(),
                    )

                }

            }

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            ) {
                if (viewModel.likedFormulaIxList.value.contains(formula.id)) {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.filled_hearth_icon),
                        contentDescription = null)
                }
            }

        }

    }
}


@Composable
fun AddButtonForList(navController: NavController, deleteMode: Boolean, formulaListId: Int) {
    if (!deleteMode) {
        FloatingActionButton(
            onClick = {
                navController.navigate("${Screen.AddFormulaForNewList.route}/${formulaListId}/${false}") {         //listenin ismini gonder ve diger sayfada dbye yukle
                    launchSingleTop = true
                    restoreState = false
                }
            },        //animation ogrenip yap ya da sadece ekle butonu olsun ve formullere uzun basidiginda silme modu acilsin
            modifier = Modifier                             //belki button yerine kart kullanabilirsin boylece onClick sikinti yaratmaz
                .size(75.dp)
                .padding(10.dp),
            backgroundColor = MaterialTheme.colors.primary

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.add_icon),
                    contentDescription = null,
                    modifier = Modifier.size(25.dp)
                )
        }
    }

}


@Composable
fun DeleteOptionButtonForList (deleteMode: Boolean, onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,        //animation ogrenip yap ya da sadece ekle butonu olsun ve formullere uzun basidiginda silme modu acilsin
        modifier = Modifier                             //belki button yerine kart kullanabilirsin boylece onClick sikinti yaratmaz
            .size(75.dp)
            .padding(10.dp),
        backgroundColor = MaterialTheme.colors.secondary
    ) {
        if (!deleteMode) {
            Icon(painter = painterResource(id = R.drawable.trash_can_icon), contentDescription = null, modifier = Modifier.size(32.dp))
        } else {
            Icon(painter = painterResource(id = R.drawable.cancel_icon), contentDescription = null, modifier = Modifier.size(20.dp))
        }

        //silerken verilen hemen guncellenmiyor
    }
}

@Composable
fun DeleteButtonForList (deleteMode: Boolean, onClick: () -> Unit) {
    if (deleteMode) {
        Button(
            onClick = onClick,
            shape = Shapes.small,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp)
                .padding(5.dp)) {
            Text(text = stringResource(id = R.string.delete))
        }
    }

}

@Composable
fun BranchButtonInListInListScreen (branch: Int, viewModel: FormulaListInListScreenViewModel = hiltViewModel(), color: ButtonColors) {
    Button(
        modifier = Modifier
            //.fillMaxWidth(0.3f)
            //.height(60.dp)
            .padding(5.dp),
        colors = color,     //emulatoru calistir test et
        shape = Shapes.small,
        onClick = {
            viewModel.filterWithBranch(branch)
        }) {
        Text(text = stringResource(id = branch), style = MaterialTheme.typography.body2)
    }
}