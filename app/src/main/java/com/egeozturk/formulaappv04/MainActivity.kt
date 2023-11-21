package com.egeozturk.formulaappv04

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.egeozturk.formulaappv04.view.TopBar
import com.egeozturk.formulaappv04.bottom_bar_and_navi.BottomBar
import com.egeozturk.formulaappv04.bottom_bar_and_navi.BottomBarMain
import com.egeozturk.formulaappv04.ui.theme.FormulaAppv04Theme
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this) {}
        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder().setTestDeviceIds(listOf("ABCDEF012345")).build()
        )

        val isFirstTime = this.getPreferences(Context.MODE_PRIVATE)

        setContent {
            MaterialTheme {
                FormulaAppv04Theme {
                    MainView()
                }
            }
        }
    }
}



@Composable
fun MainView(){
    val bottomNavController = rememberNavController()
    val systemUiController = rememberSystemUiController()


    systemUiController.setStatusBarColor(MaterialTheme.colors.background)
    Scaffold (
        topBar = { TopBar() },
        bottomBar = {
            BottomBar(navController = bottomNavController)
        }) { padding ->
        Column(modifier = Modifier.padding(padding)) {

        }
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
            Box(modifier = Modifier
                .fillMaxSize()
                .clip(Shapes.small)) {
                BottomBarMain(navController = bottomNavController)
            }

        }

    }



}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MaterialTheme {
        MainView()
    }
}