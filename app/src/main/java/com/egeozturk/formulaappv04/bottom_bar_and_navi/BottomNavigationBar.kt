package com.egeozturk.formulaappv04.bottom_bar_and_navi

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.view.screens.calculator.CalculatorScreenNavHost
import com.egeozturk.formulaappv04.view.screens.formula.FormulaScreenNavHost
import com.egeozturk.formulaappv04.view.screens.home.HomeScreenNavHost
import com.egeozturk.formulaappv04.view.screens.list.ListScreenNavHost
import com.egeozturk.formulaappv04.view.screens.profile.ProfileScreen

@Composable
fun BottomBar(navController: NavController){
    val items = setOf(
        Screen.Home,
        Screen.Formula,
        Screen.List,
        Screen.Calculator,
        //dScreen.Profile
    )

    Column(Modifier.fillMaxWidth()) {
        //Divider(
        //    modifier = Modifier.fillMaxWidth(),
        //    thickness = 1.dp,
        //    color = Color.LightGray
        //)
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.background,
            elevation = 8.dp,
            modifier = Modifier
                .fillMaxHeight(0.07f)
                .clip(RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp))
        ){
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            items.map {
                BottomNavigationItem(
                    icon = {
                        if (currentRoute == it.route) {
                            Icon(
                                // ikonu 2 tane iste biri daha kalin olsun
                                painter = painterResource(id = it.icon2!!),     //focused
                                contentDescription = stringResource(id = it.title),
                                modifier = Modifier.size(28.dp))
                        } else {
                            Icon(
                                painter = painterResource(id = it.icon2!!),     //unfocused
                                contentDescription = stringResource(id = it.title),
                                modifier = Modifier.size(25.dp))
                        }
                    },
                    /*label = {
                        Text(
                            text = stringResource(id = it.title),
                            fontSize = 12.sp,
                            maxLines = 1,
                            fontWeight = FontWeight.Bold)

                    }
                    ,
                     */
                    selected = currentRoute == it.route,
                    selectedContentColor = MaterialTheme.colors.secondary,     //rengi ayarla    normalde unspecified
                    unselectedContentColor = MaterialTheme.colors.primary,
                    onClick = {
                        navController.navigate(it.route){
                            launchSingleTop = true
                            restoreState = false
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                        }
                    }
                )
            }
        }
    }

}

@Composable
fun BottomBarMain(navController: NavHostController) {

    NavHost(navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreenNavHost(navController)
        }
        composable(Screen.Formula.route) {

            FormulaScreenNavHost()
        }
        composable(Screen.List.route) {
            ListScreenNavHost()
        }
        composable(Screen.Calculator.route) {
            CalculatorScreenNavHost()
        }
        /*composable(Screen.Profile.route) {
            ProfileScreen()
        }

         */
    }
}

