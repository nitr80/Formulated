package com.egeozturk.formulaappv04.dependencyinjection;

import android.content.Context;
import androidx.room.Room;
import com.egeozturk.formulaappv04.database.FormulaLikedDatabase;
import com.egeozturk.formulaappv04.database.FormulaListDatabase;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\tH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0012\u0010\u000e\u001a\u00020\r2\b\b\u0001\u0010\b\u001a\u00020\tH\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/egeozturk/formulaappv04/dependencyinjection/AppModule;", "", "()V", "injectFormulaDao", "Lcom/egeozturk/formulaappv04/database/FormulaLikeDao;", "formulaDatabase", "Lcom/egeozturk/formulaappv04/database/FormulaLikedDatabase;", "injectFormulaDatabase", "context", "Landroid/content/Context;", "injectFormulaListDao", "Lcom/egeozturk/formulaappv04/database/FormulaListDao;", "formulaListDatabase", "Lcom/egeozturk/formulaappv04/database/FormulaListDatabase;", "injectFormulaListDatabase", "app_debug"})
@dagger.Module()
public final class AppModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.egeozturk.formulaappv04.dependencyinjection.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.egeozturk.formulaappv04.database.FormulaLikedDatabase injectFormulaDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.egeozturk.formulaappv04.database.FormulaLikeDao injectFormulaDao(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.database.FormulaLikedDatabase formulaDatabase) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.egeozturk.formulaappv04.database.FormulaListDatabase injectFormulaListDatabase(@org.jetbrains.annotations.NotNull()
    @dagger.hilt.android.qualifiers.ApplicationContext()
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final com.egeozturk.formulaappv04.database.FormulaListDao injectFormulaListDao(@org.jetbrains.annotations.NotNull()
    com.egeozturk.formulaappv04.database.FormulaListDatabase formulaListDatabase) {
        return null;
    }
}