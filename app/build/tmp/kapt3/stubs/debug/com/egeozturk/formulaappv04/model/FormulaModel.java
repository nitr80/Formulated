package com.egeozturk.formulaappv04.model;

import androidx.annotation.StringRes;
import com.egeozturk.formulaappv04.R;
import com.egeozturk.formulaappv04.util.FormulaFunctions;
import kotlin.math.*;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001BU\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000fJ#\u0010*\u001a\u00020\u00062\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000b0,\"\u0004\u0018\u00010\u000b\u00a2\u0006\u0002\u0010-J\u0010\u0010.\u001a\u00020\u000b2\u0006\u0010/\u001a\u00020\u000bH\u0002J \u00100\u001a\u0012\u0012\u0004\u0012\u00020\u000301j\b\u0012\u0004\u0012\u00020\u0003`22\u0006\u00103\u001a\u00020\u000bH\u0002J \u00104\u001a\u0012\u0012\u0004\u0012\u00020501j\b\u0012\u0004\u0012\u000205`22\u0006\u00106\u001a\u000205H\u0002J\u0018\u00107\u001a\u0002052\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0002J\u0010\u0010:\u001a\u00020\r2\u0006\u00103\u001a\u00020\u000bH\u0002J\u0018\u0010;\u001a\u0002052\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0002J \u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010?\u001a\u00020\u000bH\u0002R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R%\u0010\u0012\u001a\u00020\u0013X\u0086\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\u001f\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\"R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0011R\u0011\u0010\u000e\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010&R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\t\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006@"}, d2 = {"Lcom/egeozturk/formulaappv04/model/FormulaModel;", "", "name", "", "branch", "formulaRule", "", "id", "variableList", "", "constant", "", "requiresNull", "", "noFormula", "(IILjava/lang/String;ILjava/util/List;DZZ)V", "getBranch", "()I", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "J", "constantString", "getConstantString", "()Ljava/lang/String;", "setConstantString", "(Ljava/lang/String;)V", "getFormulaRule", "icon", "getIcon", "setIcon", "(I)V", "getId", "getName", "getNoFormula", "()Z", "getRequiresNull", "getVariableList", "()Ljava/util/List;", "calculate", "v", "", "([Ljava/lang/Double;)Ljava/lang/String;", "factorial", "n", "findPositiveIntegerDivisor", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "number", "findPrimeNumberUntil", "", "limit", "gcd", "num1", "num2", "isPrime", "lcm", "triangleCheck", "a", "b", "c", "app_debug"})
public final class FormulaModel {
    private final int name = 0;
    private final int branch = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String formulaRule = null;
    private final int id = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.Integer> variableList = null;
    private final double constant = 0.0;
    private final boolean requiresNull = false;
    private final boolean noFormula = false;
    private int icon = 0;
    private long color;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String constantString = "";
    
    public FormulaModel(@androidx.annotation.StringRes()
    int name, @androidx.annotation.StringRes()
    int branch, @org.jetbrains.annotations.NotNull()
    java.lang.String formulaRule, int id, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> variableList, double constant, boolean requiresNull, boolean noFormula) {
        super();
    }
    
    public final int getName() {
        return 0;
    }
    
    public final int getBranch() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormulaRule() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getVariableList() {
        return null;
    }
    
    public final boolean getRequiresNull() {
        return false;
    }
    
    public final boolean getNoFormula() {
        return false;
    }
    
    public final int getIcon() {
        return 0;
    }
    
    public final void setIcon(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getConstantString() {
        return null;
    }
    
    public final void setConstantString(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final boolean triangleCheck(double a, double b, double c) {
        return false;
    }
    
    private final double factorial(double n) {
        return 0.0;
    }
    
    private final java.util.ArrayList<java.lang.Long> findPrimeNumberUntil(long limit) {
        return null;
    }
    
    private final boolean isPrime(double number) {
        return false;
    }
    
    private final java.util.ArrayList<java.lang.Integer> findPositiveIntegerDivisor(double number) {
        return null;
    }
    
    private final long gcd(double num1, double num2) {
        return 0L;
    }
    
    private final long lcm(double num1, double num2) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String calculate(@org.jetbrains.annotations.NotNull()
    java.lang.Double... v) {
        return null;
    }
}