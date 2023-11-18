package com.egeozturk.formulaappv04.view.screens.formula

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.model.FormulaLikedModel
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.util.Formulas.formulaListInit
import com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@Composable
fun SolutionScreen (navController: NavController, formulaId: Int, viewModel: FormulaScreenViewModel = hiltViewModel()) {

    val formula = formulaListInit[formulaId - 1]


    CurrentFormula.currentFormulaName.value = formula.name
    CurrentFormula.currentFormulaBranch.value = formula.branch



    val context = LocalContext.current
    var formulaResult by remember {
        mutableStateOf("")
    }
    val alphaValueIfNoFormula = if (formula.noFormula) 0.0f else 1.0f


    //val isFormulaLiked by remember { mutableStateOf(viewModel.getCurrentFormulaLike(formulaId))}
    //println("formulaLike: " + isFormulaLiked)           //like gosterme ise yaramiyo

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.92f)
    ) {
        Column () {
            Box(modifier = Modifier.fillMaxWidth()) {
                Row (horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                    FavoriteButton(formulaId, viewModel, formula.color)
                    SolutionOptionsButton(navController, formulaId, formula.color)
                    //InfoButton(navController = navController)
                }
                Formula(formula)
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (formula.variableList.size == 6) {
                    formula.variableList.forEachIndexed { index, variableName ->
                        VariableBox(
                            variableName = stringResource(id = variableName),
                            viewModel = viewModel,
                            id = index,
                            //formulaShadeColor = formula.color,
                            modifier = Modifier.height(57.dp)
                        )
                    }
                } else {
                    formula.variableList.forEachIndexed { index, variableName ->
                        VariableBox(
                            variableName = stringResource(id = variableName),
                            viewModel = viewModel,
                            id = index,
                            //formulaShadeColor = formula.color
                        )
                    }
                }
            }

            Row (horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){

                Text(
                    text = stringResource(id =
                    if (formula.requiresNull) R.string.keep_one_variable_empty
                    else R.string.enter_value_for_each_variable
                    ),
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(16.dp, 4.dp, 4.dp, 4.dp)
                        .weight(1f)
                        .alpha(alphaValueIfNoFormula),
                    fontSize = 12.sp,
                )


                Text(
                    text = formula.constantString,
                    modifier = Modifier
                        .padding(4.dp, 4.dp, 16.dp, 4.dp)
                        .weight(1f),
                    fontSize = 12.sp,
                    textAlign = TextAlign.End,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Serif
                )
            }


            Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
                val toastMessage1 = stringResource(id = R.string.formula_calculation_error_no_null)
                val toastMessage2 = stringResource(id = R.string.enter_value_for_each_variable)
                val notTriangleError = stringResource(id = R.string.not_a_triange_error)
                val focusManager = LocalFocusManager.current

                val loadingString = stringResource(id = R.string.loading)
                val isPrimeString = stringResource(id = R.string.is_prime)
                val isNotPrimeString = stringResource(id = R.string.is_not_prime)
                val isTriangleString = stringResource(id = R.string.is_triangle)
                val notTriangleString = stringResource(id = R.string.not_triangle)


                Button(
                    onClick = {

                        val tempVarList = viewModel.variableArray.value.copyOfRange(0,formula.variableList.size)

                        if (formula.noFormula) {
                            formulaResult = ""
                        } else if (tempVarList.filterNotNull().size + 1 != tempVarList.size && formula.requiresNull) {
                            Toast.makeText(context, toastMessage1, Toast.LENGTH_SHORT).show()
                        } else if (tempVarList.filterNotNull().size != tempVarList.size && !formula.requiresNull) {
                            Toast.makeText(context, toastMessage2, Toast.LENGTH_SHORT).show()

                        } else if (
                            formula.name == R.string.prime_factor_finder ||
                            formula.name == R.string.positive_integer_divisor_finder ||
                            formula.name == R.string.greatest_common_divisor ||
                            formula.name == R.string.product_of_the_members_of_a_geometric_sequence_formula ||
                            formula.name == R.string.fibonacci_sequence_starting_from_1_term_finder
                        ) {

                            val scope = CoroutineScope(Dispatchers.Main)
                            formulaResult = loadingString

                            scope.launch {
                                withContext(Dispatchers.IO) {
                                    val result = formula.calculate(*tempVarList)

                                    formulaResult = result
                                    focusManager.clearFocus()
                                }
                            }
                        } else if (formula.name == R.string.prime_number_checker) {

                            val scope = CoroutineScope(Dispatchers.Main)
                            formulaResult = loadingString

                            scope.launch {
                                withContext(Dispatchers.IO) {
                                    val result = formula.calculate(*tempVarList)

                                    if (result == "prime") {
                                        formulaResult = isPrimeString
                                        focusManager.clearFocus()
                                    } else {
                                        formulaResult = isNotPrimeString
                                        focusManager.clearFocus()
                                    }
                                }
                            }

                        } else if (formula.name == R.string.triangle_inequality_calculator) {

                            val result = formula.calculate(*tempVarList)


                            if (result == "notTriangle") {
                                formulaResult = notTriangleString
                                focusManager.clearFocus()
                            } else if (result == "triangle") {
                                formulaResult = isTriangleString
                                focusManager.clearFocus()
                            }

                        } else {
                            val result = formula.calculate(*tempVarList)

                            if (result == "notTriangle") {
                                Toast.makeText(context, notTriangleError, Toast.LENGTH_SHORT).show()
                            } else {
                                formulaResult = result
                                focusManager.clearFocus()
                            }
                            //println("Resutl: " + formula.calculate(*tempVarList))
                        }

                            //formul aciklamasini ve hesaplama fonksiyonunu yap
                              },
                    modifier = Modifier.padding(4.dp).alpha(alphaValueIfNoFormula),
                    shape = Shapes.small,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary)
                ) {
                    Text(text = stringResource(id = R.string.calculate), color = Color.Black)
                }
            }

            Text(
                text = stringResource(id = R.string.result),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                //color = MaterialTheme.colors.primaryVariant,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .alpha(alphaValueIfNoFormula),
                fontFamily = FontFamily.Serif
            )

            Text(
                text = formulaResult,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                ,
                fontFamily = FontFamily.Serif
            )

        }
    }
}

@Composable
fun FavoriteButton(id: Int, viewModel: FormulaScreenViewModel, formulaColor: Color) {
    viewModel.getCurrentFormulaLike(id)
    var isLiked by remember {
        viewModel.isLiked
    }
    IconButton(
        onClick = {
            isLiked = !isLiked
            viewModel.changeFormulaLike(FormulaLikedModel(isLiked, id))
        },
        modifier = Modifier
            .size(45.dp)
            .padding(7.dp)
    ) {
        if (isLiked) {
            Icon(
                painter = painterResource(id = R.drawable.filled_hearth_icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                tint = MaterialTheme.colors.primary
            )
        } else {
            Icon(
                painter = painterResource(id = R.drawable.empty_heart_icon),
                contentDescription = null,
                modifier = Modifier.size(25.dp),
                tint = MaterialTheme.colors.primary
            )         //animasyon ekle
        }
    }
}

@Composable
fun Formula (formula: FormulaModel) {
    Text(
        text = formula.formulaRule,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        fontSize = 26.sp,        //make it adaptive font size
        fontFamily = FontFamily.Serif

    )
}

@Composable
fun InfoButton (navController: NavController) {
    IconButton(
        onClick = {
            navController.navigate(Screen.Info.route) {
                launchSingleTop = true
                restoreState = false
            }
        },
        modifier = Modifier
            .size(45.dp)
            .padding(7.dp)
    ) {
        Icon(painter = painterResource(id = R.drawable.infoicon), contentDescription = null)
    }
}

@Composable
fun SolutionOptionsButton (navController: NavController, formulaId: Int, formulaColor: Color) {
    var mDisplayMenu by remember { mutableStateOf(false) }

    Column() {
        IconButton(onClick = { mDisplayMenu = !mDisplayMenu }) {
            Icon(
                imageVector = Icons.Default.MoreVert,
                contentDescription = null,
                tint = MaterialTheme.colors.primary
                )
        }

        DropdownMenu(
            expanded = mDisplayMenu,
            onDismissRequest = { mDisplayMenu = false }
        ) {
            DropdownMenuItem(
                onClick = {
                    navController.navigate("${Screen.AddToList.route}/${formulaId}") {
                        CurrentFormula.currentFormulaName.value = R.string.app_name
                        launchSingleTop = true
                        restoreState = false      //bekli bunu true yapip ayni yere geri donebilirim
                    }
                },
                modifier = Modifier.size(120.dp,25.dp)) {
                Text(text = stringResource(id = R.string.add_to_list))
            }
        }
    }

}


@Composable
fun VariableBox (
    variableName: String,
    //onCalculateClicked: (String) -> Unit = {},
    viewModel: FormulaScreenViewModel,
    id: Int,
    //formulaShadeColor: Color = MaterialTheme.colors.primary,
    modifier: Modifier = Modifier.height(70.dp)
) {
    var variable by remember {
        mutableStateOf("")
    }
    val focusManager = LocalFocusManager.current

    OutlinedTextField(
        modifier = Modifier
            .padding(0.dp, 4.dp)
            .fillMaxWidth(.965f)
            .then(modifier),
        value = variable,
        onValueChange = {
            variable = it
            viewModel.variableArray.value[id] = variable.toDoubleOrNull()
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
        label = { Text(text = variableName, fontFamily = FontFamily.Serif) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            /*unfocusedLabelColor = MaterialTheme.colors.primary,
            focusedLabelColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.primaryVariant,
            focusedBorderColor = MaterialTheme.colors.primary

             */

            unfocusedLabelColor = MaterialTheme.colors.primaryVariant,
            focusedLabelColor = MaterialTheme.colors.primaryVariant,
            unfocusedBorderColor = MaterialTheme.colors.primary,
            focusedBorderColor = MaterialTheme.colors.primary

        )
    )
    //sayi girdisi al

}