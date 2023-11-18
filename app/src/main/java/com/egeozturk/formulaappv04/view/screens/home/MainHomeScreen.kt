package com.egeozturk.formulaappv04.view.screens.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.view.screens.profile.SubscriptionScreen

@Composable
fun HomeScreenNavHost(bottomNavHostController: NavHostController) {


    val navController = rememberNavController()
    Surface(modifier = Modifier.fillMaxSize()) {
        NavHost(navController = navController, startDestination = Screen.Home.route) {
            composable(Screen.Home.route) {
                HomeScreen(navController, bottomNavHostController)
            }

            composable(Screen.Subscription.route) {
                SubscriptionScreen()
            }

            composable(Screen.ToolList.route) {
                ToolList(bottomNavHostController)
            }
        }

    }
}



@Composable
fun ConstantScreen() {
    //daha sonra ekle ilk surume koymana gerek yok
}