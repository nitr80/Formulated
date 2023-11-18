package com.egeozturk.formulaappv04.repo;

import com.egeozturk.formulaappv04.database.FormulaListDao;
import com.egeozturk.formulaappv04.model.FormulaListModel;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\b0\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/egeozturk/formulaappv04/repo/FormulaListRepository;", "", "formulaListDao", "Lcom/egeozturk/formulaappv04/database/FormulaListDao;", "(Lcom/egeozturk/formulaappv04/database/FormulaListDao;)V", "deleteFormulaList", "", "formulaList", "Lcom/egeozturk/formulaappv04/model/FormulaListModel;", "(Lcom/egeozturk/formulaappv04/model/FormulaListModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentFormulaList", "listId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFormulaList", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFormulaList", "updateFormulaList", "app_debug"})
@javax.inject.Singleton()
public final class FormulaListRepository {
    private final com.egeozturk.formulaappv04.database.FormulaListDao formulaListDao = null;
    
    @javax.inject.Inject()
    public FormulaListRepository(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.database.FormulaListDao formulaListDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFormulaList(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.egeozturk.formulaappv04.model.FormulaListModel>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel formulaList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel formulaList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel formulaList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getCurrentFormulaList(int listId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.egeozturk.formulaappv04.model.FormulaListModel> continuation) {
        return null;
    }
}