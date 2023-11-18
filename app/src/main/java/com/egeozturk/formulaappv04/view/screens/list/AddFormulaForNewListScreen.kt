package com.egeozturk.formulaappv04.view.screens.list

import androidx.compose.foundation.background
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
import com.egeozturk.formulaappv04.model.FormulaListModel
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.view.SearchBar
import com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel


@Composable
fun AddFormulaForNewListScreen (
    listName: String,
    navController: NavController,
    isNew: Boolean,
    viewModel: ListScreenViewModel = hiltViewModel()) {

    val maths = R.string.maths
    val chem = R.string.chemistry
    val phy = R.string.physics

    //isNew i kontrol et ona gore islemleri yap
    //yeni ise ayni kalsin
    //eski ise listId yi listName den al ve inte cevir. Bu islemi olustur dugmesinde yap
        // O idli listi al ve zaten ekli olan formullerin rengini degisir
        // olustur buttonu yerine ekle yaz ve listeyi guncelle

    //liste su an guncelleniyor fakat ayni formul cok kez eklenebiliyor bunu engelle


    if (!isNew) {
        viewModel.getCurrentFormulaIndexList(listName.toInt())
    }

    Surface(modifier = Modifier
        .fillMaxHeight(0.924f)
        .fillMaxWidth()) {
        Box() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()
            ) {
                SearchBar() {
                    viewModel.searchInFormulaList(it)
                }
                Row(horizontalArrangement = Arrangement.Center) {
                    BranchButtonInAddListScreen(
                        branch = maths,
                        color = if (viewModel.mathIsClicked.value)
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelLightBlueShade)       //buranin renklerini koy
                        else
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelLightBlue)
                    )

                    BranchButtonInAddListScreen(
                        branch = chem,
                        color = if (viewModel.chemIsClicked.value)
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelGreenShade)
                        else
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelGreen)
                    )

                    BranchButtonInAddListScreen(
                        branch = phy,
                        color = if (viewModel.phyIsClicked.value)
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurpleShade)
                        else
                            ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurple)
                    )
                }
                Text(text = stringResource(id = R.string.choose_formulas))

                LazyColumn(
                    modifier = Modifier
                        .clip(Shapes.small)
                        .fillMaxWidth(.95f),        //burayi digerlerine de ekle
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(viewModel.searchResultList.value) {
                        SelectableFormulaButton(it, viewModel)
                    }
                }



            }
            Column(modifier = Modifier
                .fillMaxHeight(0.99f)
                .fillMaxWidth(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
                ForwardButton(listName, isNew, navController = navController, viewModel)
            }

        }

    }
}

@Composable
fun SelectableFormulaButton (formula: FormulaModel, viewModel: ListScreenViewModel) {
    var checkedState by remember { mutableStateOf(false) }
    var onClickButtonColor by remember { mutableStateOf(Color.White) }

    onClickButtonColor = if (viewModel.checkedFormulaIndexList.contains(formula.id)) {
        MaterialTheme.colors.primaryVariant         //bu renge bak
    } else if (viewModel.currentList.value.contains(formula)) {
        //com.egeozturk.formulaappv04.ui.theme.PastelPink       //zaten listeye ekli olanlari tiklamanaz yapip rengini degistiriyor
        Color.White
    } else {
        formula.color
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            //.height(96.dp)
            .padding(0.dp, 5.dp)
            .aspectRatio(4f)
            .clickable {
                if (!viewModel.currentList.value.contains(formula)) {
                    checkedState = !checkedState
                    if (checkedState) {
                        viewModel.checkedFormulaIndexList.add(formula.id)
                    } else {
                        viewModel.checkedFormulaIndexList.remove(formula.id)
                    }
                }
            },
        backgroundColor = onClickButtonColor,
        //colors = ButtonDefaults.buttonColors(backgroundColor = onClickButtonColor),
        shape = Shapes.small
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp,5.dp,8.dp,8.dp)
        ) {
            Icon(
                painter = painterResource(id = formula.icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxHeight()
            )
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
    }
}

@Composable
fun ForwardButton (listName: String, isNew: Boolean, navController: NavController, viewModel: ListScreenViewModel) {        //buradan database e yukle
    Button(onClick = {
        if (isNew) {
            viewModel.insertFormulaList(FormulaListModel(listName, viewModel.checkedFormulaIndexList))
            navController.navigate(Screen.List.route) {
                launchSingleTop = true
                restoreState = false
                navController.graph.startDestinationRoute?.let { route ->   //silme kismi oldu ama burasi eski listeye formul eklediginde ana ekrana degil listeye donsun
                    popUpTo(route) {
                        saveState = true
                    }
                }
            }
        } else {
            viewModel.updateFormulaList()
            navController.navigate("${Screen.FormulaListInListScreen.route}/${listName.toInt()}") {
                launchSingleTop = true
                restoreState = false
                navController.graph.startDestinationRoute?.let { route ->   //silme kismi oldu ama burasi eski listeye formul eklediginde ana ekrana degil listeye donsun
                    popUpTo(route) {
                        saveState = true
                    }
                }
            }
        }

    }, modifier = Modifier.fillMaxWidth(0.8f),
        shape = Shapes.small,
        //colors = ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelGreen)
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)

    ) {
        if (isNew) {
            Text(text = stringResource(id = R.string.create))
        } else {
            Text(text = stringResource(id = R.string.add_to_list))
        }
    }
}

@Composable
fun BranchButtonInAddListScreen (branch: Int, viewModel: ListScreenViewModel = hiltViewModel(), color: ButtonColors) {
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

