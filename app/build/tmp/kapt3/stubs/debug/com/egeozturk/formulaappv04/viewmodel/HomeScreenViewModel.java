package com.egeozturk.formulaappv04.viewmodel;

import androidx.lifecycle.ViewModel;
import com.egeozturk.formulaappv04.model.FormulaLikedModel;
import com.egeozturk.formulaappv04.repo.FormulaRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0013\u001a\u00020\u0014R\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/egeozturk/formulaappv04/viewmodel/HomeScreenViewModel;", "Landroidx/lifecycle/ViewModel;", "formulaRepository", "Lcom/egeozturk/formulaappv04/repo/FormulaRepository;", "(Lcom/egeozturk/formulaappv04/repo/FormulaRepository;)V", "formulaLikeArrayForInit", "", "Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;", "getFormulaLikeArrayForInit", "()[Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;", "setFormulaLikeArrayForInit", "([Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;)V", "[Lcom/egeozturk/formulaappv04/model/FormulaLikedModel;", "formulaLikeList", "", "getFormulaLikeList", "()Ljava/util/List;", "setFormulaLikeList", "(Ljava/util/List;)V", "checkLikes", "Lkotlinx/coroutines/Job;", "app_debug"})
public final class HomeScreenViewModel extends androidx.lifecycle.ViewModel {
    private final com.egeozturk.formulaappv04.repo.FormulaRepository formulaRepository = null;
    public java.util.List<com.egeozturk.formulaappv04.model.FormulaLikedModel> formulaLikeList;
    @org.jetbrains.annotations.NotNull()
    private com.egeozturk.formulaappv04.model.FormulaLikedModel[] formulaLikeArrayForInit;
    
    @javax.inject.Inject()
    public HomeScreenViewModel(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.repo.FormulaRepository formulaRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.egeozturk.formulaappv04.model.FormulaLikedModel> getFormulaLikeList() {
        return null;
    }
    
    public final void setFormulaLikeList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.egeozturk.formulaappv04.model.FormulaLikedModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.egeozturk.formulaappv04.model.FormulaLikedModel[] getFormulaLikeArrayForInit() {
        return null;
    }
    
    public final void setFormulaLikeArrayForInit(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.model.FormulaLikedModel[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job checkLikes() {
        return null;
    }
}