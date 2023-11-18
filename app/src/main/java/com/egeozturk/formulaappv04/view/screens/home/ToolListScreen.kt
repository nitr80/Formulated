package com.egeozturk.formulaappv04.view.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.ui.theme.Shapes


@Composable
fun ToolList(bottomNavHostController: NavHostController) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        //ToolListButton(title = stringResource(id = R.string.search_page), icon = R.drawable.formulaicon, route = Screen.Formula.route, navController = bottomNavHostController)
        //ToolListButton(title = stringResource(id = R.string.lists_page), icon = R.drawable.listicon, route = Screen.List.route, navController = bottomNavHostController)
        //ToolListButton(title = stringResource(id = R.string.calculate_page), icon = R.drawable.calculatoricon, route = Screen.Calculator.route, navController = bottomNavHostController)

    }
}

@Composable
fun ToolListButton (title: String, icon: Int, route: String, navController: NavController) {
    Button(
        onClick = {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = false
            }
        },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Magenta),
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp, 5.dp),
        shape = Shapes.small
    ) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(id = icon), contentDescription = null, modifier = Modifier
                .size(64.dp)
                .padding(4.dp))
            Spacer(modifier = Modifier.padding(5.dp))
            Text(text = title, style = MaterialTheme.typography.h5)
        }
    }
}