package com.egeozturk.formulaappv04.view.screens.calculator;

import android.widget.Toast;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.*;
import androidx.compose.material.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavController;
import com.egeozturk.formulaappv04.R;
import com.egeozturk.formulaappv04.util.CurrentFormula;
import com.egeozturk.formulaappv04.viewmodel.CalculatorScreenViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u001a\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u001a\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a3\u0010\b\u001a\u00020\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0007\u00a2\u0006\u0002\u0010\u000f\u001a\u0010\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a\u0016\u0010\u0011\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0013H\u0007\u001a\u001a\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u001a9\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001a\u0010\u001b\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"CalculatorButtons", "", "CalculatorScreen", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lcom/egeozturk/formulaappv04/viewmodel/CalculatorScreenViewModel;", "MiddleBar", "MiddleBarButton", "icon", "", "label", "", "onClick", "Lkotlin/Function0;", "(Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)V", "ResultScreen", "SideBar", "functionList", "", "SideBarButton", "StandardCalculatorButton", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "StandardCalculatorButton-RPmYEkk", "(Ljava/lang/String;JLandroidx/compose/ui/Modifier;Lcom/egeozturk/formulaappv04/viewmodel/CalculatorScreenViewModel;)V", "app_debug"})
public final class CalculatorScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void CalculatorScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.CalculatorScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void ResultScreen(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.CalculatorScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CalculatorButtons() {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SideBar(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> functionList) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void SideBarButton(@org.jetbrains.annotations.NotNull()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.CalculatorScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MiddleBar(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.CalculatorScreenViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void MiddleBarButton(@org.jetbrains.annotations.Nullable()
    java.lang.Integer icon, @org.jetbrains.annotations.Nullable()
    java.lang.String label, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}