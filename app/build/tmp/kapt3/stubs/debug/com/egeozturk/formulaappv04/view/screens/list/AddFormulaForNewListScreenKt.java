package com.egeozturk.formulaappv04.view.screens.list;

import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.navigation.NavController;
import com.egeozturk.formulaappv04.R;
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen;
import com.egeozturk.formulaappv04.model.FormulaListModel;
import com.egeozturk.formulaappv04.model.FormulaModel;
import com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007\u001a\"\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0007\u001a(\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\u0018\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u0013"}, d2 = {"AddFormulaForNewListScreen", "", "listName", "", "navController", "Landroidx/navigation/NavController;", "isNew", "", "viewModel", "Lcom/egeozturk/formulaappv04/viewmodel/ListScreenViewModel;", "BranchButtonInAddListScreen", "branch", "", "color", "Landroidx/compose/material/ButtonColors;", "ForwardButton", "SelectableFormulaButton", "formula", "Lcom/egeozturk/formulaappv04/model/FormulaModel;", "app_debug"})
public final class AddFormulaForNewListScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void AddFormulaForNewListScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String listName, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, boolean isNew, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SelectableFormulaButton(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaModel formula, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ForwardButton(@org.jetbrains.annotations.NotNull()
    java.lang.String listName, boolean isNew, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BranchButtonInAddListScreen(int branch, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.ListScreenViewModel viewModel, @org.jetbrains.annotations.NotNull()
    androidx.compose.material.ButtonColors color) {
    }
}