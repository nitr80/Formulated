package com.egeozturk.formulaappv04.view.screens.calculator

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.util.CurrentFormula

@Composable
fun CalculatorScreenNavHost() {

    val navController = rememberNavController()
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(0.924f)) {
        NavHost(navController = navController, startDestination = Screen.Calculator.route) {
            composable(Screen.Calculator.route) {
                CalculatorScreen(navController)
            }

            composable(Screen.UnitConversion.route) {
                UnitConversionScreen(navController)
            }
        }
    }
}
