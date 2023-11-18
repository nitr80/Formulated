package com.egeozturk.formulaappv04.database;

import androidx.room.*;
import com.egeozturk.formulaappv04.model.FormulaListModel;
import com.egeozturk.formulaappv04.model.FormulaModel;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ%\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J%\u0010\u0010\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/egeozturk/formulaappv04/database/FormulaListDao;", "", "deleteFormulaList", "", "formulaList", "", "Lcom/egeozturk/formulaappv04/model/FormulaListModel;", "([Lcom/egeozturk/formulaappv04/model/FormulaListModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentFormulaList", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getFormulaLists", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFormulaList", "updateFormulaList", "app_debug"})
public abstract interface FormulaListDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM FormulaListModel")
    public abstract java.lang.Object getFormulaLists(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.egeozturk.formulaappv04.model.FormulaListModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM FormulaListModel WHERE id = :id")
    public abstract java.lang.Object getCurrentFormulaList(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.egeozturk.formulaappv04.model.FormulaListModel> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel[] formulaList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel[] formulaList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertFormulaList(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaListModel[] formulaList, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}