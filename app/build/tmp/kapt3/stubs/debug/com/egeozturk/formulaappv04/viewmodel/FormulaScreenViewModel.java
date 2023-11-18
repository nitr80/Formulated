package com.egeozturk.formulaappv04.viewmodel;

import android.content.Context;
import androidx.compose.runtime.*;
import androidx.lifecycle.ViewModel;
import com.egeozturk.formulaappv04.R;
import com.egeozturk.formulaappv04.model.FormulaLikedModel;
import com.egeozturk.formulaappv04.model.FormulaListModel;
import com.egeozturk.formulaappv04.repo.FormulaListRepository;
import com.egeozturk.formulaappv04.repo.FormulaRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020\nJ\u000e\u0010@\u001a\u00020;2\u0006\u0010A\u001a\u00020\nJ\u0006\u0010B\u001a\u00020;J\u0006\u0010C\u001a\u00020;J\u0010\u0010D\u001a\u00020;2\b\b\u0002\u0010E\u001a\u00020FJ\u0016\u0010G\u001a\u00020;2\u0006\u0010H\u001a\u00020\u00162\u0006\u0010I\u001a\u00020\nR\u0014\u0010\t\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0011\"\u0004\b\u0018\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\fR\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0013R\u001d\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00150\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0011R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R\u0014\u0010$\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\fR\u0014\u0010&\u001a\u00020\nX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\fR \u0010(\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0011\"\u0004\b*\u0010\u0013R+\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b-\u0010\f\"\u0004\b.\u0010/R&\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00150\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0013R(\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u000107060\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0011\"\u0004\b9\u0010\u0013\u00a8\u0006J"}, d2 = {"Lcom/egeozturk/formulaappv04/viewmodel/FormulaScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "formulaRepository", "Lcom/egeozturk/formulaappv04/repo/FormulaRepository;", "formulaListRepository", "Lcom/egeozturk/formulaappv04/repo/FormulaListRepository;", "context", "Landroid/content/Context;", "(Lcom/egeozturk/formulaappv04/repo/FormulaRepository;Lcom/egeozturk/formulaappv04/repo/FormulaListRepository;Landroid/content/Context;)V", "chem", "", "getChem", "()I", "chemIsClicked", "Landroidx/compose/runtime/MutableState;", "", "getChemIsClicked", "()Landroidx/compose/runtime/MutableState;", "setChemIsClicked", "(Landroidx/compose/runtime/MutableState;)V", "formulaLists", "", "Lcom/egeozturk/formulaappv04/model/FormulaListModel;", "getFormulaLists", "setFormulaLists", "general", "getGeneral", "initialFormulaList", "Lcom/egeozturk/formulaappv04/model/FormulaModel;", "isLiked", "setLiked", "likedFormulaIxList", "getLikedFormulaIxList", "mathIsClicked", "getMathIsClicked", "setMathIsClicked", "maths", "getMaths", "phy", "getPhy", "phyIsClicked", "getPhyIsClicked", "setPhyIsClicked", "<set-?>", "previousBranch", "getPreviousBranch", "setPreviousBranch", "(I)V", "previousBranch$delegate", "Landroidx/compose/runtime/MutableState;", "searchResultList", "getSearchResultList", "setSearchResultList", "variableArray", "", "", "getVariableArray", "setVariableArray", "changeFormulaLike", "", "formulaLikedModel", "Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;", "filterWithBranch", "branch", "getCurrentFormulaLike", "id", "getFavoriteList", "getLists", "searchInFormulaList", "query", "", "updateFormulaList", "formulaListModel", "formulaIndex", "app_debug"})
public final class FormulaScreenViewModel extends androidx.lifecycle.ViewModel {
    private final com.egeozturk.formulaappv04.repo.FormulaRepository formulaRepository = null;
    private final com.egeozturk.formulaappv04.repo.FormulaListRepository formulaListRepository = null;
    private final android.content.Context context = null;
    private final int general = com.egeozturk.formulaappv04.R.string.general;
    private final int maths = com.egeozturk.formulaappv04.R.string.maths;
    private final int chem = com.egeozturk.formulaappv04.R.string.chemistry;
    private final int phy = com.egeozturk.formulaappv04.R.string.physics;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> isLiked;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Double[]> variableArray;
    private final java.util.List<com.egeozturk.formulaappv04.model.FormulaModel> initialFormulaList = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> searchResultList;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> mathIsClicked;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> chemIsClicked;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> phyIsClicked;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState previousBranch$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaListModel>> formulaLists;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.util.List<java.lang.Integer>> likedFormulaIxList = null;
    
    @javax.inject.Inject()
    public FormulaScreenViewModel(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.repo.FormulaRepository formulaRepository, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.repo.FormulaListRepository formulaListRepository, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    public final int getGeneral() {
        return 0;
    }
    
    public final int getMaths() {
        return 0;
    }
    
    public final int getChem() {
        return 0;
    }
    
    public final int getPhy() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> isLiked() {
        return null;
    }
    
    public final void setLiked(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Double[]> getVariableArray() {
        return null;
    }
    
    public final void setVariableArray(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Double[]> p0) {
    }
    
    public final void getCurrentFormulaLike(int id) {
    }
    
    public final void changeFormulaLike(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaLikedModel formulaLikedModel) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> getSearchResultList() {
        return null;
    }
    
    public final void setSearchResultList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getMathIsClicked() {
        return null;
    }
    
    public final void setMathIsClicked(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getChemIsClicked() {
        return null;
    }
    
    public final void setChemIsClicked(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getPhyIsClicked() {
        return null;
    }
    
    public final void setPhyIsClicked(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    public final void searchInFormulaList(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final int getPreviousBranch() {
        return 0;
    }
    
    public final void setPreviousBranch(int p0) {
    }
    
    public final void filterWithBranch(int branch) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaListModel>> getFormulaLists() {
        return null;
    }
    
    public final void setFormulaLists(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaListModel>> p0) {
    }
    
    public final void getLists() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<java.lang.Integer>> getLikedFormulaIxList() {
        return null;
    }
    
    public final void getFavoriteList() {
    }
    
    public final void updateFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel formulaListModel, int formulaIndex) {
    }
}