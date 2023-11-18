package com.egeozturk.formulaappv04.viewmodel;

import android.content.Context;
import androidx.compose.runtime.*;
import androidx.lifecycle.ViewModel;
import com.egeozturk.formulaappv04.model.FormulaListModel;
import com.egeozturk.formulaappv04.model.FormulaModel;
import com.egeozturk.formulaappv04.repo.FormulaListRepository;
import com.egeozturk.formulaappv04.repo.FormulaRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;
import com.egeozturk.formulaappv04.R;
import dagger.hilt.android.qualifiers.ApplicationContext;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u00106\u001a\u000207H\u0002J\u000e\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\nJ\u000e\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020\nJ\u0006\u0010<\u001a\u000207J\u0006\u0010=\u001a\u000207J\u0010\u0010>\u001a\u0002072\b\b\u0002\u0010?\u001a\u00020@J\u0006\u0010A\u001a\u000207R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\n0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R&\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u001d0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u000fR \u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000f\"\u0004\b%\u0010\u0011R\u000e\u0010&\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R \u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u000f\"\u0004\b*\u0010\u0011R+\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011\u00a8\u0006B"}, d2 = {"Lcom/egeozturk/formulaappv04/viewmodel/FormulaListInListScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "formulaListRepository", "Lcom/egeozturk/formulaappv04/repo/FormulaListRepository;", "formulaRepository", "Lcom/egeozturk/formulaappv04/repo/FormulaRepository;", "context", "Landroid/content/Context;", "(Lcom/egeozturk/formulaappv04/repo/FormulaListRepository;Lcom/egeozturk/formulaappv04/repo/FormulaRepository;Landroid/content/Context;)V", "chem", "", "chemIsClicked", "Landroidx/compose/runtime/MutableState;", "", "getChemIsClicked", "()Landroidx/compose/runtime/MutableState;", "setChemIsClicked", "(Landroidx/compose/runtime/MutableState;)V", "deleteList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getDeleteList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "setDeleteList", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "formulaListInListDB", "Lcom/egeozturk/formulaappv04/model/FormulaListModel;", "getFormulaListInListDB", "general", "initialFormulaList", "", "Lcom/egeozturk/formulaappv04/model/FormulaModel;", "getInitialFormulaList", "setInitialFormulaList", "likedFormulaIxList", "getLikedFormulaIxList", "mathIsClicked", "getMathIsClicked", "setMathIsClicked", "maths", "phy", "phyIsClicked", "getPhyIsClicked", "setPhyIsClicked", "<set-?>", "previousBranch", "getPreviousBranch", "()I", "setPreviousBranch", "(I)V", "previousBranch$delegate", "Landroidx/compose/runtime/MutableState;", "searchResultList", "getSearchResultList", "setSearchResultList", "createInitList", "", "filterWithBranch", "branch", "getCurrentFormulaList", "listId", "getFavoriteList", "getFavoriteListForButton", "searchInFormulaList", "query", "", "updateFormulaList", "app_debug"})
public final class FormulaListInListScreenViewModel extends androidx.lifecycle.ViewModel {
    private final com.egeozturk.formulaappv04.repo.FormulaListRepository formulaListRepository = null;
    private final com.egeozturk.formulaappv04.repo.FormulaRepository formulaRepository = null;
    private final android.content.Context context = null;
    private final int general = com.egeozturk.formulaappv04.R.string.general;
    private final int maths = com.egeozturk.formulaappv04.R.string.maths;
    private final int chem = com.egeozturk.formulaappv04.R.string.chemistry;
    private final int phy = com.egeozturk.formulaappv04.R.string.physics;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<com.egeozturk.formulaappv04.model.FormulaListModel> formulaListInListDB = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> initialFormulaList;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> searchResultList;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.Integer> deleteList;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> mathIsClicked;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> chemIsClicked;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> phyIsClicked;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState previousBranch$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<java.util.List<java.lang.Integer>> likedFormulaIxList = null;
    
    @javax.inject.Inject()
    public FormulaListInListScreenViewModel(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.repo.FormulaListRepository formulaListRepository, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.repo.FormulaRepository formulaRepository, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<com.egeozturk.formulaappv04.model.FormulaListModel> getFormulaListInListDB() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> getInitialFormulaList() {
        return null;
    }
    
    public final void setInitialFormulaList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> getSearchResultList() {
        return null;
    }
    
    public final void setSearchResultList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.Integer> getDeleteList() {
        return null;
    }
    
    public final void setDeleteList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.Integer> p0) {
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
    
    public final int getPreviousBranch() {
        return 0;
    }
    
    public final void setPreviousBranch(int p0) {
    }
    
    public final void getCurrentFormulaList(int listId) {
    }
    
    private final void createInitList() {
    }
    
    public final void updateFormulaList() {
    }
    
    public final void getFavoriteList() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<java.lang.Integer>> getLikedFormulaIxList() {
        return null;
    }
    
    public final void getFavoriteListForButton() {
    }
    
    public final void searchInFormulaList(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void filterWithBranch(int branch) {
    }
}