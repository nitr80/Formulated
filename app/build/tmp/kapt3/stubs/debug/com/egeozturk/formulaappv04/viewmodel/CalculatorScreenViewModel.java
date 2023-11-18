package com.egeozturk.formulaappv04.viewmodel;

import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlin.math.*;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\u000e\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0005J\u000e\u0010!\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0005J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0006\u0010#\u001a\u00020\u001eJ\u0010\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0018H\u0002J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010\'\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010-\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\t\u00a8\u00060"}, d2 = {"Lcom/egeozturk/formulaappv04/viewmodel/CalculatorScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "calculationSeq", "Landroidx/compose/runtime/MutableState;", "", "getCalculationSeq", "()Landroidx/compose/runtime/MutableState;", "setCalculationSeq", "(Landroidx/compose/runtime/MutableState;)V", "isNegative", "", "()Z", "setNegative", "(Z)V", "isRadianOn", "setRadianOn", "numberOfParenthesis", "", "getNumberOfParenthesis", "()I", "setNumberOfParenthesis", "(I)V", "result", "", "getResult", "setResult", "absoluteCheck", "calculation", "calculate", "", "checkByLabel", "label", "checkSideByLabel", "constantCheck", "deleteCalculation", "factorial", "number", "factorialCheck", "lnCheck", "logCheck", "operate", "operateInPara", "percentCheck", "powerCheck", "squareRootCheck", "toggleNegative", "trigonometryCheck", "app_debug"})
public final class CalculatorScreenViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.String> calculationSeq;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Double> result;
    private int numberOfParenthesis = 0;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isRadianOn;
    private boolean isNegative = false;
    
    @javax.inject.Inject()
    public CalculatorScreenViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.String> getCalculationSeq() {
        return null;
    }
    
    public final void setCalculationSeq(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Double> getResult() {
        return null;
    }
    
    public final void setResult(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Double> p0) {
    }
    
    public final int getNumberOfParenthesis() {
        return 0;
    }
    
    public final void setNumberOfParenthesis(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isRadianOn() {
        return null;
    }
    
    public final void setRadianOn(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    public final boolean isNegative() {
        return false;
    }
    
    public final void setNegative(boolean p0) {
    }
    
    public final void checkByLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String label) {
    }
    
    public final void checkSideByLabel(@org.jetbrains.annotations.NotNull()
    java.lang.String label) {
    }
    
    private final void calculate() {
    }
    
    public final void deleteCalculation() {
    }
    
    private final java.lang.String toggleNegative(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String constantCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String factorialCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String percentCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String squareRootCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String powerCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String trigonometryCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String absoluteCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String logCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String lnCheck(java.lang.String calculation) {
        return null;
    }
    
    private final java.lang.String factorial(double number) {
        return null;
    }
    
    private final double operate(java.lang.String calculation) {
        return 0.0;
    }
    
    private final java.lang.String operateInPara(java.lang.String calculation) {
        return null;
    }
}