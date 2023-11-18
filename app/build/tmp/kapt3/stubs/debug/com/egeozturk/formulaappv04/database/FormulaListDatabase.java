package com.egeozturk.formulaappv04.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.egeozturk.formulaappv04.converter.Converters;
import com.egeozturk.formulaappv04.model.FormulaListModel;

@androidx.room.TypeConverters(value = {com.egeozturk.formulaappv04.converter.Converters.class})
@androidx.room.Database(entities = {com.egeozturk.formulaappv04.model.FormulaListModel.class}, version = 1)
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/egeozturk/formulaappv04/database/FormulaListDatabase;", "Landroidx/room/RoomDatabase;", "()V", "formulaListDao", "Lcom/egeozturk/formulaappv04/database/FormulaListDao;", "app_debug"})
public abstract class FormulaListDatabase extends androidx.room.RoomDatabase {
    
    public FormulaListDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.egeozturk.formulaappv04.database.FormulaListDao formulaListDao();
}