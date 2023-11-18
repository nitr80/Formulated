package com.egeozturk.formulaappv04.viewmodel;

import android.content.Context;
import androidx.compose.runtime.Composable;
import androidx.lifecycle.ViewModel;
import com.egeozturk.formulaappv04.R;
import com.egeozturk.formulaappv04.model.FormulaListModel;
import com.egeozturk.formulaappv04.model.FormulaModel;
import com.egeozturk.formulaappv04.repo.FormulaListRepository;
import com.egeozturk.formulaappv04.repo.FormulaRepository;
import com.egeozturk.formulaappv04.util.Formulas;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001eJ\u000e\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020\u000bJ\u000e\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020\u000bJ\u0006\u0010%\u001a\u00020;J\u0006\u0010A\u001a\u00020;J\u000e\u0010B\u001a\u00020;2\u0006\u0010C\u001a\u00020\u001eJ\u000e\u0010D\u001a\u00020;2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020;R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0015\"\u0004\b#\u0010\u0017R&\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0015\"\u0004\b&\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00190\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0015\"\u0004\b)\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u001a\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0015\"\u0004\b.\u0010\u0017R\u000e\u0010/\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0082D\u00a2\u0006\u0002\n\u0000R \u00101\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0015\"\u0004\b3\u0010\u0017R \u00104\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0015\"\u0004\b6\u0010\u0017R&\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0015\"\u0004\b9\u0010\u0017\u00a8\u0006H"}, d2 = {"Lcom/egeozturk/formulaappv04/viewmodel/ListScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "formulaRepository", "Lcom/egeozturk/formulaappv04/repo/FormulaRepository;", "formulaListRepository", "Lcom/egeozturk/formulaappv04/repo/FormulaListRepository;", "context", "Landroid/content/Context;", "(Lcom/egeozturk/formulaappv04/repo/FormulaRepository;Lcom/egeozturk/formulaappv04/repo/FormulaListRepository;Landroid/content/Context;)V", "checkedFormulaIndexList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "", "getCheckedFormulaIndexList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "setCheckedFormulaIndexList", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;)V", "chem", "chemIsClicked", "Landroidx/compose/runtime/MutableState;", "", "getChemIsClicked", "()Landroidx/compose/runtime/MutableState;", "setChemIsClicked", "(Landroidx/compose/runtime/MutableState;)V", "currentList", "", "Lcom/egeozturk/formulaappv04/model/FormulaModel;", "getCurrentList", "setCurrentList", "currentListModel", "Lcom/egeozturk/formulaappv04/model/FormulaListModel;", "getCurrentListModel", "setCurrentListModel", "deleteClicked", "getDeleteClicked", "setDeleteClicked", "favoriteList", "getFavoriteList", "setFavoriteList", "formulaListsList", "getFormulaListsList", "setFormulaListsList", "general", "initialFormulaList", "mathIsClicked", "getMathIsClicked", "setMathIsClicked", "maths", "phy", "phyIsClicked", "getPhyIsClicked", "setPhyIsClicked", "previousBranch", "getPreviousBranch", "setPreviousBranch", "searchResultList", "getSearchResultList", "setSearchResultList", "deleteFormulaList", "", "formulaList", "filterWithBranch", "branch", "getCurrentFormulaIndexList", "listId", "getFormulaLists", "insertFormulaList", "formulaListModel", "searchInFormulaList", "query", "", "updateFormulaList", "app_debug"})
public final class ListScreenViewModel extends androidx.lifecycle.ViewModel {
    private final com.egeozturk.formulaappv04.repo.FormulaRepository formulaRepository = null;
    private final com.egeozturk.formulaappv04.repo.FormulaListRepository formulaListRepository = null;
    private final android.content.Context context = null;
    private final int general = com.egeozturk.formulaappv04.R.string.general;
    private final int maths = com.egeozturk.formulaappv04.R.string.maths;
    private final int chem = com.egeozturk.formulaappv04.R.string.chemistry;
    private final int phy = com.egeozturk.formulaappv04.R.string.physics;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaListModel>> formulaListsList;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> favoriteList;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> deleteClicked;
    private final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> initialFormulaList = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> searchResultList;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.Integer> checkedFormulaIndexList;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> mathIsClicked;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> chemIsClicked;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Boolean> phyIsClicked;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.lang.Integer> previousBranch;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<com.egeozturk.formulaappv04.model.FormulaListModel> currentListModel;
    @org.jetbrains.annotations.NotNull()
    private androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> currentList;
    
    @javax.inject.Inject()
    public ListScreenViewModel(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.repo.FormulaRepository formulaRepository, @org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.repo.FormulaListRepository formulaListRepository, @org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaListModel>> getFormulaListsList() {
        return null;
    }
    
    public final void setFormulaListsList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaListModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> getFavoriteList() {
        return null;
    }
    
    public final void setFavoriteList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Boolean> getDeleteClicked() {
        return null;
    }
    
    public final void setDeleteClicked(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Boolean> p0) {
    }
    
    public final void getFormulaLists() {
    }
    
    public final void getFavoriteList() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> getSearchResultList() {
        return null;
    }
    
    public final void setSearchResultList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.snapshots.SnapshotStateList<java.lang.Integer> getCheckedFormulaIndexList() {
        return null;
    }
    
    public final void setCheckedFormulaIndexList(@org.jetbrains.annotations.NotNull()
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.lang.Integer> getPreviousBranch() {
        return null;
    }
    
    public final void setPreviousBranch(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<com.egeozturk.formulaappv04.model.FormulaListModel> getCurrentListModel() {
        return null;
    }
    
    public final void setCurrentListModel(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<com.egeozturk.formulaappv04.model.FormulaListModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> getCurrentList() {
        return null;
    }
    
    public final void setCurrentList(@org.jetbrains.annotations.NotNull()
    androidx.compose.runtime.MutableState<java.util.List<com.egeozturk.formulaappv04.model.FormulaModel>> p0) {
    }
    
    public final void getCurrentFormulaIndexList(int listId) {
    }
    
    public final void searchInFormulaList(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void filterWithBranch(int branch) {
    }
    
    public final void insertFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel formulaListModel) {
    }
    
    public final void updateFormulaList() {
    }
    
    public final void deleteFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel formulaList) {
    }
}