package com.egeozturk.formulaappv04.view.screens.list;

import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.runtime.*;
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.navigation.NavController;
import com.egeozturk.formulaappv04.R;
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen;
import com.egeozturk.formulaappv04.model.FormulaListModel;
import com.egeozturk.formulaappv04.model.FormulaModel;
import com.egeozturk.formulaappv04.util.CurrentFormula;
import com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0016\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a>\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0007\u001a\u001a\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006\u0011"}, d2 = {"AddListButton", "", "navController", "Landroidx/navigation/NavController;", "FavoriteList", "onClick", "Lkotlin/Function0;", "ListButton", "name", "", "formulaNameList", "", "", "listId", "viewModel", "Lcom/egeozturk/formulaappv04/viewmodel/ListScreenViewModel;", "ListScreen", "app_debug"})
public final class ListScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void ListScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FavoriteList(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AddListButton(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ListButton(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> formulaNameList, int listId, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}