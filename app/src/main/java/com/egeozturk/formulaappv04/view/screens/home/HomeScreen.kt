package com.egeozturk.formulaappv04.view.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.view.ads.AdmobBanner
import com.egeozturk.formulaappv04.viewmodel.HomeScreenViewModel


@Composable
fun HomeScreen (navController: NavController, bottomNavHostController: NavHostController, viewModel: HomeScreenViewModel = hiltViewModel()) {


    val maths = stringResource(id = com.egeozturk.formulaappv04.R.string.maths)
    val chem = stringResource(id = com.egeozturk.formulaappv04.R.string.chemistry)
    val phy = stringResource(com.egeozturk.formulaappv04.R.string.physics)
    val lists = stringResource(com.egeozturk.formulaappv04.R.string.lists_page)
    val calculator = stringResource(com.egeozturk.formulaappv04.R.string.calculate_page)
    val toolList = stringResource(com.egeozturk.formulaappv04.R.string.tool_list)

    CurrentFormula.currentFormulaName.value = R.string.app_name

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().verticalScroll(state = ScrollState(0), enabled = true)
    ) {
        //SearchBar()



        val gradientFormula = Brush.horizontalGradient(
            colorStops = arrayOf(
                Pair(.15f, com.egeozturk.formulaappv04.ui.theme.PastelGreen),
                Pair(.45f, com.egeozturk.formulaappv04.ui.theme.PastelLightBlue),
                Pair(1f, com.egeozturk.formulaappv04.ui.theme.PastelPurple)
            )
        )

        val gradientFormula2 = Brush.horizontalGradient(
            colorStops = arrayOf(
                Pair(.12f, com.egeozturk.formulaappv04.ui.theme.PastelLightBlue),
                Pair(.5f, com.egeozturk.formulaappv04.ui.theme.PastelGreen),
                Pair(.88f, com.egeozturk.formulaappv04.ui.theme.PastelPurple)
            )
        )

        val gradientList = Brush.horizontalGradient(
            listOf(
                com.egeozturk.formulaappv04.ui.theme.PastelLightBlue,
                com.egeozturk.formulaappv04.ui.theme.PastelLightBlue
            )
        )

        val gradientCalculate = Brush.horizontalGradient(
            listOf(
                com.egeozturk.formulaappv04.ui.theme.PastelGreen,
                com.egeozturk.formulaappv04.ui.theme.PastelGreen
            )
        )

        val gradientSettings = Brush.horizontalGradient(
            listOf(
                com.egeozturk.formulaappv04.ui.theme.PastelPurple,
                com.egeozturk.formulaappv04.ui.theme.PastelPurple
            )
        )
    
        Spacer(modifier = Modifier.height(5.dp))
        
        Column(modifier = Modifier.fillMaxHeight().fillMaxWidth(.95f), horizontalAlignment = Alignment.CenterHorizontally) {
            HomeItemButton(
                text = stringResource(id = R.string.formula),
                brush = gradientFormula2,
                icon = R.drawable.search_button_unfocused,      //bunu uygulamanin logosu yap
                navController = bottomNavHostController,
                route = Screen.Formula.route,
            )

            HomeItemButton(
                text = lists,
                brush = gradientList,
                icon = R.drawable.list_icon_unfocused,
                navController = bottomNavHostController,
                route = Screen.List.route,
            )

            HomeItemButton(
                text = calculator,
                brush = gradientCalculate,
                icon = R.drawable.calculator_icon_unfocused,
                navController = bottomNavHostController,
                route = Screen.Calculator.route,
            )

            HomeItemButton(
                text = stringResource(id = R.string.sub_to_premium),
                brush = gradientSettings,
                icon = R.drawable.settings_icon,
                navController = navController,
                route = Screen.Subscription.route,
            )

            AdmobBanner()
            
            //Spacer(modifier = Modifier.fillMaxSize(.4f))
        }
        


    }

}

@Composable
fun HomeItemButton (
    text: String,
    brush: Brush,
    icon: Int,
    size: Float = 1f,
    navController: NavController,
    route: String,
){

    Card(
        modifier = Modifier
            //.size(175.dp, 130.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            //.height(96.dp)
            .padding(0.dp, 4.dp)
            .clickable {
                navController.navigate(route) {
                    launchSingleTop = true
                    restoreState = false
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route) {
                            saveState = true
                        }
                    }
                }
            }
            .background(
                brush = brush,
                shape = Shapes.small
            )
            .clip(Shapes.small)
            .aspectRatio(3.8f)
        ,
        border = BorderStroke(8.dp, brush),
        backgroundColor = Color.Unspecified
    //su reknleri ve borderlari hallet

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                modifier = Modifier
                    //.size(64.dp)
                    .fillMaxHeight()
                    .padding(4.dp)
                    .aspectRatio(1f)
            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = text,
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium
            )
        }


    }
}



