package com.egeozturk.formulaappv04.view.screens.calculator

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.util.CurrentFormula
import com.egeozturk.formulaappv04.viewmodel.CalculatorScreenViewModel


@Composable
fun CalculatorScreen (navController: NavController, viewModel: CalculatorScreenViewModel = hiltViewModel()) {

    CurrentFormula.currentFormulaName.value = R.string.app_name

    Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.End, modifier = Modifier.fillMaxHeight()) {
        //Divider(color = Color.DarkGray, thickness = 1.dp, startIndent = 20.dp)
        ResultScreen(viewModel)

        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.End) {
            MiddleBar(navController)
            CalculatorButtons()
        }
        //Spacer(modifier = Modifier.padding(2.dp))
    }      //radyan acil olunca goster
}

@Composable
fun ResultScreen(viewModel: CalculatorScreenViewModel) {

    Column(modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth()
        .fillMaxHeight(0.3f)
        , horizontalAlignment = Alignment.End) {
        val calculations by remember { viewModel.calculationSeq }
        var fontSize = 35.sp
        if (calculations.length < 14) {
            fontSize = 35.sp
        } else if(calculations.length < 19) {
            fontSize = 29.sp
        } else {
            fontSize = 25.sp
        }       //uzun islem yazilinca kaydirilabilir olsun ekran

        Text(modifier = Modifier            //islem kisimi
            .verticalScroll(ScrollState(1), reverseScrolling = true)
            //.fillMaxHeight()
            .weight(7f),     //burada maxHeight calismiyo bunu duzelt
            textAlign = TextAlign.End,                                    //scrollable ve istenilen yere yazilabilir olsun
            text = viewModel.calculationSeq.value,
            fontSize = fontSize)

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = viewModel.result.value.toString(), fontSize = 17.sp, modifier = Modifier.weight(1f))            //sonuc kismi
    }
}


@Composable
fun CalculatorButtons() {
    Row(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(), verticalAlignment = Alignment.Bottom) {
        Column(modifier = Modifier.fillMaxWidth(0.85f), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            val rowModifier = Modifier//.weight(1f)
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = rowModifier) {
                StandardCalculatorButton(label = "C", com.egeozturk.formulaappv04.ui.theme.PastelGreen, Modifier.weight(1f))
                StandardCalculatorButton(label = "(", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = ")", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "÷", modifier = Modifier.weight(1f))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = rowModifier) {
                StandardCalculatorButton(label = "7", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "8", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "9", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "×", modifier = Modifier.weight(1f))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = rowModifier) {
                StandardCalculatorButton(label = "4", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "5", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "6", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "-", modifier = Modifier.weight(1f))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = rowModifier) {
                StandardCalculatorButton(label = "1", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "2", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "3", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "+", modifier = Modifier.weight(1f))
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), modifier = rowModifier) {
                StandardCalculatorButton(label = "+/-", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "0", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = ",", modifier = Modifier.weight(1f))
                StandardCalculatorButton(label = "=", com.egeozturk.formulaappv04.ui.theme.PastelLightBlue, Modifier.weight(1f))
            }
        }
        val functionList = listOf("%", "xⁿ", "√", "!", "|x|", "e", "log", "ln", "π", "sin", "cos", "tan", "cot", "sec", "csc")     //power ekle
        SideBar(functionList)
    }
}
/*
@Composable
fun StandardCalculatorButton (label: String) {
    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .size(73.dp,73.dp)
            .aspectRatio(1f)
            .padding(5.dp),     //dugmelerin konumunu duzelt
        colors = ButtonDefaults.buttonColors(Color.White),
        elevation = ButtonDefaults.elevation(5.dp),
        shape = CircleShape
    ) {
        Text(text = label, style = MaterialTheme.typography.h5)
    }
}

 */

@Composable
fun StandardCalculatorButton (
    label: String,
    color: Color = com.egeozturk.formulaappv04.ui.theme.LightBlue,
    modifier: Modifier,
    viewModel: CalculatorScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    Button(
        //button buyuklugu bazen tam olmuyor ona bak
        modifier = Modifier
            .aspectRatio(1f)
            //.size(73.dp,73.dp)
            //.aspectRatio(1f)
            //.padding(5.dp)
            .then(modifier),
        colors = ButtonDefaults.buttonColors(color),
        elevation = ButtonDefaults.elevation(2.dp),
        shape = RoundedCornerShape(150.dp),
        onClick = {
            viewModel.checkByLabel(label)

        }) {
        Text(text = label, style = MaterialTheme.typography.h5, color = Color.Black)
    }
}

@Composable
fun SideBar (functionList: List<String>) {      //side bar fena degil ama buyuk ekranlarda biraz yukari uzuyo
    LazyColumn(modifier = Modifier
        .padding(9.dp, 0.dp, 0.dp, 0.dp)
        .border(0.dp, MaterialTheme.colors.primary, Shapes.small)
        .clip(Shapes.small)
        .fillMaxWidth()
        .fillMaxHeight(1f)
    ) {
        //Spacer(modifier =Modifier.padding(2.dp))
        items(functionList) {   function ->
            SideBarButton(label = function)
        }
    }
}

@Composable
fun SideBarButton(label: String, viewModel: CalculatorScreenViewModel = hiltViewModel()) {       //if necessary you can set icons
    Button(
        contentPadding = PaddingValues(1.dp),
        modifier = Modifier
            .size(50.dp)
            .padding(3.dp, 2.dp),
        elevation = ButtonDefaults.elevation(3.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = com.egeozturk.formulaappv04.ui.theme.PastelPurple),           //eskiden PastelLightLila
        shape = Shapes.small,
        onClick = {
            viewModel.checkSideByLabel(label)
        }) {

        Text(text = label, fontSize = 12.sp, color = Color.Black)
    }

}

@Composable
fun MiddleBar(navController: NavController, viewModel: CalculatorScreenViewModel = hiltViewModel()) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        //MiddleBarButton(icon = com.egeozturk.formulaappv04.R.drawable.formulaicon, {})  //extra functions
        /*MiddleBarButton(icon = com.egeozturk.formulaappv04.R.drawable.formulaicon) {
            navController.navigate(Screen.UnitConversion.route) {
                launchSingleTop = true
                navController.graph.startDestinationRoute?.let { route ->
                    popUpTo(route) {
                        saveState = true
                    }
                }
            }

        }  //unit converter*/

        val context = LocalContext.current
        val radianMode = stringResource(id = R.string.radian_mode)
        val degreeMode = stringResource(id = R.string.degree_mode)
        val label = if (viewModel.isRadianOn.value) "Deg"
        else "Rad"

        MiddleBarButton(label = label) {     //radian & degree mode
            viewModel.isRadianOn.value = !viewModel.isRadianOn.value

            if (viewModel.isRadianOn.value) {
                Toast.makeText(context, radianMode, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, degreeMode, Toast.LENGTH_SHORT).show()
            }

        }
        
        MiddleBarButton(icon = R.drawable.backspace_icon) {
            viewModel.deleteCalculation()
            println("Calculation" + viewModel.calculationSeq.value)
        }  //delete

        Spacer(modifier = Modifier.padding(2.dp))
    }

}

@Composable
fun MiddleBarButton (icon: Int? = null, label: String? = null, onClick: () -> Unit) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .size(40.dp)
            .padding(5.dp),

    ) {
        if (icon != null) {
            Icon(painter = painterResource(id = icon), contentDescription = null, tint = MaterialTheme.colors.primaryVariant)
        } else if (label != null) {
            Text(text = label, fontWeight = FontWeight.Bold, color = MaterialTheme.colors.primaryVariant)
        }
    }
}
