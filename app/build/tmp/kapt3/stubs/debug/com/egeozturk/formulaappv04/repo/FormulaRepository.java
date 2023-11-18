package com.egeozturk.formulaappv04.repo;

import com.egeozturk.formulaappv04.database.FormulaLikeDao;
import com.egeozturk.formulaappv04.model.FormulaLikedModel;
import javax.inject.Inject;
import javax.inject.Singleton;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J%\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ%\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/egeozturk/formulaappv04/repo/FormulaRepository;", "", "formulaLikeDao", "Lcom/egeozturk/formulaappv04/database/FormulaLikeDao;", "(Lcom/egeozturk/formulaappv04/database/FormulaLikeDao;)V", "deleteFormulaLike", "", "formulaLike", "", "Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;", "([Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllFormulaLikes", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLikedFormulaIndex", "", "getOneFormulaLike", "", "id", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertFormulaLike", "updateFormulaLike", "app_debug"})
@javax.inject.Singleton()
public final class FormulaRepository {
    private final com.egeozturk.formulaappv04.database.FormulaLikeDao formulaLikeDao = null;
    
    @javax.inject.Inject()
    public FormulaRepository(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.database.FormulaLikeDao formulaLikeDao) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllFormulaLikes(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.egeozturk.formulaappv04.model.FormulaLikedModel>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getOneFormulaLike(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertFormulaLike(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaLikedModel[] formulaLike, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteFormulaLike(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaLikedModel[] formulaLike, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateFormulaLike(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaLikedModel[] formulaLike, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getLikedFormulaIndex(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.Integer>> continuation) {
        return null;
    }
}