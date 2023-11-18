package com.egeozturk.formulaappv04.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.egeozturk.formulaappv04.model.FormulaLikedModel;

@androidx.room.Database(entities = {com.egeozturk.formulaappv04.model.FormulaLikedModel.class}, version = 1)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/egeozturk/formulaappv04/database/FormulaLikedDatabase;", "Landroidx/room/RoomDatabase;", "()V", "formulaLikedDao", "Lcom/egeozturk/formulaappv04/database/FormulaLikeDao;", "app_debug"})
public abstract class FormulaLikedDatabase extends androidx.room.RoomDatabase {
    
    public FormulaLikedDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.egeozturk.formulaappv04.database.FormulaLikeDao formulaLikedDao();
}