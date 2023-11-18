package com.egeozturk.formulaappv04.view.screens.formula;

import android.widget.Toast;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.*;
import androidx.compose.material.icons.Icons;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.LocalSoftwareKeyboardController;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.navigation.NavController;
import com.egeozturk.formulaappv04.R;
import com.egeozturk.formulaappv04.bottom_bar_and_navi.Screen;
import com.egeozturk.formulaappv04.model.FormulaLikedModel;
import com.egeozturk.formulaappv04.model.FormulaModel;
import com.egeozturk.formulaappv04.util.CurrentFormula;
import com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel;
import kotlinx.coroutines.Dispatchers;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\b\u0010\t\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0007\u001a-\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0012\u0010\u0013\u001a\"\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007\u001a*\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0007\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u001a"}, d2 = {"FavoriteButton", "", "id", "", "viewModel", "Lcom/egeozturk/formulaappv04/viewmodel/FormulaScreenViewModel;", "formulaColor", "Landroidx/compose/ui/graphics/Color;", "FavoriteButton-mxwnekA", "(ILcom/egeozturk/formulaappv04/viewmodel/FormulaScreenViewModel;J)V", "Formula", "formula", "Lcom/egeozturk/formulaappv04/model/FormulaModel;", "InfoButton", "navController", "Landroidx/navigation/NavController;", "SolutionOptionsButton", "formulaId", "SolutionOptionsButton-mxwnekA", "(Landroidx/navigation/NavController;IJ)V", "SolutionScreen", "VariableBox", "variableName", "", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class SolutionScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void SolutionScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, int formulaId, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void Formula(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaModel formula) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void InfoButton(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void VariableBox(@org.jetbrains.annotations.NotNull()
    java.lang.String variableName, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel viewModel, int id, @org.jetbrains.annotations.NotNull()
    androidx.compose.ui.Modifier modifier) {
    }
}