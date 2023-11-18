package com.egeozturk.formulaappv04.util;

import androidx.annotation.StringRes;
import androidx.compose.runtime.MutableState;
import com.egeozturk.formulaappv04.R;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\t\u00a8\u0006\u0011"}, d2 = {"Lcom/egeozturk/formulaappv04/util/CurrentFormula;", "", "()V", "currentFormulaBranch", "Landroidx/compose/runtime/MutableState;", "", "getCurrentFormulaBranch", "()Landroidx/compose/runtime/MutableState;", "setCurrentFormulaBranch", "(Landroidx/compose/runtime/MutableState;)V", "currentFormulaName", "getCurrentFormulaName", "setCurrentFormulaName", "currentlyInSolution", "", "getCurrentlyInSolution", "setCurrentlyInSolution", "app_debug"})
public final class CurrentFormula {
    @org.jetbrains.annotations.NotNull()
    public static final com.egeozturk.formulaappv04.util.CurrentFormula INSTANCE = null;
    @org.jetbrains.annotations.NotNull()
    private static androidx.compose.runtime.MutableState<java.lang.Integer> currentFormulaName;
    @org.jetbrains.annotations.NotNull()
    private static androidx.compose.runtime.MutableState<java.lang.Integer> currentFormulaBranch;
    @org.jetbrains.annotations.NotNull()
    private static androidx.compose.runtime.MutableState<java.lang.Boolean> currentlyInSolution;
    
    private CurrentFormula() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Integer> getCurrentFormulaName() {
        return null;
    }
    
    public final void setCurrentFormulaName(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Integer> getCurrentFormulaBranch() {
        return null;
    }
    
    public final void setCurrentFormulaBranch(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getCurrentlyInSolution() {
        return null;
    }
    
    public final void setCurrentlyInSolution(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
}