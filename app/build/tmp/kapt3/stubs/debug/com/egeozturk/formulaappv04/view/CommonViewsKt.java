package com.egeozturk.formulaappv04.view;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.compose.foundation.layout.*;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.*;
import androidx.compose.runtime.*;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import com.egeozturk.formulaappv04.R;
import com.egeozturk.formulaappv04.model.FormulaModel;
import com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a(\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007\u001a\u001e\u0010\u000b\u001a\u00020\u00012\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\rH\u0007\u00a8\u0006\u000e"}, d2 = {"BranchButton", "", "branch", "", "onClick", "Lkotlin/Function0;", "FormulaButton", "formula", "Lcom/egeozturk/formulaappv04/model/FormulaModel;", "viewModel", "Lcom/egeozturk/formulaappv04/viewmodel/FormulaScreenViewModel;", "SearchBar", "onSearch", "Lkotlin/Function1;", "app_debug"})
public final class CommonViewsKt {
    
    @androidx.compose.runtime.Composable()
    public static final void SearchBar(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onSearch) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void BranchButton(@org.jetbrains.annotations.NotNull()
    java.lang.String branch, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void FormulaButton(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaModel formula, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.viewmodel.FormulaScreenViewModel viewModel, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
}