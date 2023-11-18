package com.egeozturk.formulaappv04.view

import android.graphics.Rect
import android.view.View
import android.view.ViewTreeObserver
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.egeozturk.formulaappv04.R
import com.egeozturk.formulaappv04.model.FormulaModel
import com.egeozturk.formulaappv04.ui.theme.Shapes
import com.egeozturk.formulaappv04.util.clearFocusOnKeyboardDismiss
import com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel


@Composable
fun SearchBar (onSearch: (String) -> Unit = {}) {
    var searchText by remember { mutableStateOf("")}
    val focusManager = LocalFocusManager.current

    OutlinedTextField(                    //enter a basilinca aratsin yoksa satir atliyo
        value = searchText,
        maxLines = 1,
        onValueChange = {
            searchText = it
            onSearch(it)
                        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search,
        ),
        keyboardActions = KeyboardActions(onSearch = {
            focusManager.clearFocus()
        }),
        placeholder = { Text(text = stringResource(id = R.string.search_formula))},
        modifier = Modifier
            .padding(top = 8.dp)
            .fillMaxWidth(.95f)
            .height(50.dp)
            .clearFocusOnKeyboardDismiss()
        ,
        shape = Shapes.small,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colors.primary,
            unfocusedBorderColor = MaterialTheme.colors.primary,
            placeholderColor = MaterialTheme.colors.primary
        )
    )
}


@Composable
fun BranchButton (branch: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            //.fillMaxWidth(0.3f)
            //.height(60.dp)
            .padding(5.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.LightGray),
        shape = Shapes.small,
        onClick = onClick) {
        Text(text = branch, style = MaterialTheme.typography.body2)
    }
}

@Composable
fun FormulaButton (formula: FormulaModel, viewModel: FormulaScreenViewModel = hiltViewModel(), onClick: () -> Unit) {
    Card(
        backgroundColor = formula.color,
        shape = Shapes.small,
        modifier = Modifier
            .fillMaxWidth()
            //.height(96.dp)
            .padding(0.dp, 5.dp)
            .clickable(onClick = onClick)
            .aspectRatio(4f)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp,5.dp,8.dp,8.dp)
                    .fillMaxSize()
            ) {
                Icon(painter = painterResource(id = formula.icon), contentDescription = null,
                    Modifier
                        .padding(4.dp)
                        .fillMaxHeight(),
                    //tint = Color.White
                )
                Column (
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(.9f)
                        .padding(start = 8.dp, end = 4.dp)
                ){
                    Text(
                        text = stringResource(id = formula.name),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        maxLines = 3,
                        //color = Color.White
                        //modifier = Modifier.fillMaxHeight(),
                    )

                }

            }

            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
            ) {
                if (viewModel.likedFormulaIxList.value.contains(formula.id)) {
                    Icon(
                        modifier = Modifier.size(26.dp),
                        painter = painterResource(id = R.drawable.filled_hearth_icon),
                        contentDescription = null)
                }
            }

        }
    }
}

