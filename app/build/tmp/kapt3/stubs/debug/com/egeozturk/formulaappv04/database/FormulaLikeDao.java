package com.egeozturk.formulaappv04.database;

import androidx.room.*;
import com.egeozturk.formulaappv04.model.FormulaLikedModel;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J%\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J%\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J%\u0010\u0012\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005\"\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/egeozturk/formulaappv04/database/FormulaLikeDao;", "", "deleteFormulaLike", "", "formulaLike", "", "Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;", "([Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFormulaLikes", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLikedFormulaIndex", "", "getOneFormulaLike", "", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFormulaLike", "updateFormulaLike", "app_debug"})
public abstract interface FormulaLikeDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM FormulaLikedModel")
    public abstract java.lang.Object getAllFormulaLikes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.egeozturk.formulaappv04.model.FormulaLikedModel>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT isLiked FROM FormulaLikedModel WHERE id = :id")
    public abstract java.lang.Object getOneFormulaLike(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT id FROM FormulaLikedModel WHERE isLiked = 1")
    public abstract java.lang.Object getLikedFormulaIndex(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert()
    public abstract java.lang.Object insertFormulaLike(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaLikedModel[] formulaLike, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateFormulaLike(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaLikedModel[] formulaLike, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteFormulaLike(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaLikedModel[] formulaLike, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}