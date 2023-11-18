package com.egeozturk.formulaappv04.view.screens.list

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen


@Composable
fun AddListNameScreen(navController: NavController) {
    val context = LocalContext.current
    var listName by remember { mutableStateOf("") }
    Surface(modifier = Modifier.fillMaxHeight(.85f).fillMaxWidth()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(id = R.string.enter_name_for_list),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                //style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(10.dp),
                fontFamily = FontFamily.SansSerif,
                color = MaterialTheme.colors.primary
            )
            val toastMessage = stringResource(id = R.string.enter_name_toast)

            TextField(
                value = listName,
                maxLines = 1,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = MaterialTheme.colors.primaryVariant,
                    unfocusedIndicatorColor = MaterialTheme.colors.primaryVariant
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    if (listName.isNotEmpty()) {
                        navController.navigate("${Screen.AddFormulaForNewList.route}/${listName}/${true}") {
                            launchSingleTop = true
                            restoreState = false
                        }
                    } else {
                        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
                    }
                }),
                onValueChange = {listName = it}
            )

            Row {
                Text(
                    text = stringResource(id = R.string.cancel),
                    Modifier
                        .clickable {
                            navController.navigate(Screen.List.route) {

                                launchSingleTop = true
                                restoreState = false
                                navController.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }

                            }
                        }
                        .padding(10.dp),
                    //color = com.egeozturk.formulaappv04.ui.theme.PastelPink
                    color = MaterialTheme.colors.secondary
                )

                Text(
                    text = stringResource(id = R.string.next),
                    //color = com.egeozturk.formulaappv04.ui.theme.PastelPurple,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier
                        .padding(10.dp)
                        .clickable {
                            if (listName.isNotEmpty()) {
                                navController.navigate("${Screen.AddFormulaForNewList.route}/${listName}/${true}") {
                                    launchSingleTop = true
                                    restoreState = false
                                }
                            } else {
                                Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show()
                            }
                        }
                )
            }
        }
    }
}
