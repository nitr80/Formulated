package com.egeozturk.formulaappv04.view

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.util.CurrentFormula

@Composable
fun TopBar () {
    //var mDisplayMenu by remember { mutableStateOf(false) }


    //println("TopBar" + CurrentFormula.currentlyInSolution.value)
    val scrollState = rememberScrollState()

    TopAppBar(
        title = {
            Row(modifier = Modifier.horizontalScroll(scrollState).fillMaxWidth().padding(end = 6.dp)) {
                Text(
                    text = stringResource(id = CurrentFormula.currentFormulaName.value),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 4.dp,end = 6.dp),
                    color = MaterialTheme.colors.primary,
                    maxLines = 1,
                )
            }

        },
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.wrapContentHeight()
        /*actions = {
            IconButton(onClick = { mDisplayMenu = !mDisplayMenu }) {
                Icon(Icons.Default.MoreVert,null)
            }
            
            DropdownMenu(expanded = mDisplayMenu, onDismissRequest = { mDisplayMenu = false }) {
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.language))
                }

                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.dark_mode))
                }

                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Text(text = stringResource(id = R.string.premium))
                }
            }


        }*/
    )
}