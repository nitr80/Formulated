package com.egeozturk.formulaappv04.view.screens.list

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.view.screens.formula.AddToListScreen
import com.egeozturk.formulaappv04.view.screens.formula.SolutionScreen

@Composable
fun ListScreenNavHost() {


    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.List.route) {
        composable(Screen.List.route) {
            ListScreen(navController = navController)
        }

        composable("${Screen.FormulaListInListScreen.route}/{formulaListIndex}", arguments = listOf(
            navArgument("formulaListIndex") {
                type = NavType.IntType
                //listDao da index ile list al ve burada index yolla(su an zaten oyle)
            }
        )) {
            val formulaListIndex = remember {
                it.arguments?.getInt("formulaListIndex") ?: -1
            }
            FormulaListInListScreen(navController = navController, formulaListIndex)            //sadece ismi yolla db den listeyi isimle cek
        }

        composable(Screen.AddList.route) {
            AddListNameScreen(navController)
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

        composable("${Screen.AddFormulaForNewList.route}/{listName}/{isNew}", arguments = listOf(
            navArgument("listName") {
                type = NavType.StringType
            },
            navArgument("isNew") {
                type = NavType.BoolType
            }
        )) {
            val listName = remember {
                it.arguments?.getString("listName") ?: ""
            }
            val isNew = remember {
                it.arguments?.getBoolean("isNew") ?: false
            }
            AddFormulaForNewListScreen( listName, navController, isNew)
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