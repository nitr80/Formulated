package com.egeozturk.formulaappv04.view.screens.formula

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.util.CurrentFormula

@Composable
fun FormulaScreenNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Formula.route) {
        composable(Screen.Formula.route) {

            FormulaScreen(navController)
        }

        composable("${Screen.Solution.route}/{formulaId}", arguments = listOf(
            navArgument("formulaId") {
                type = NavType.IntType
            }
        )) {
            val formulaId = remember {
                it.arguments?.getInt("formulaId") ?: -1
            }
            SolutionScreen(navController, formulaId)
        }

        composable(Screen.Info.route) {
            InfoScreen()       //sonraki update
        }

        composable("${Screen.AddToList.route}/{formulaId}", arguments = listOf(
            navArgument("formulaId") {
                type = NavType.IntType
            }
        )) {
            val formulaId = remember {
                it.arguments?.getInt("formulaId") ?: -1
            }
            AddToListScreen(navController = navController, formulaId)      //buraya formulu gonder
        }
    }

}


@Composable
fun InfoScreen () {
    Text(text = "Info Screen")          //sonra ki guncellemelere ekle
}

@Preview(showBackground = true)
@Composable
fun FormulaScreenPreview() {
    MaterialTheme {
        
    }
}