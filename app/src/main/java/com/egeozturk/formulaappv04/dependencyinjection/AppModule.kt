package com.egeozturk.formulaappv04.dependencyinjection

import android.content.Context
import androidx.room.Room
import com.egeozturk.formulaappv04.database.FormulaLikedDatabase
import com.egeozturk.formulaappv04.database.FormulaListDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun injectFormulaDatabase (
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        FormulaLikedDatabase::class.java,
        "FormulaDatabase"
    ).build()

    @Singleton
    @Provides
    fun injectFormulaDao (formulaDatabase: FormulaLikedDatabase) = formulaDatabase.formulaLikedDao()

    @Singleton
    @Provides
    fun injectFormulaListDatabase (
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        FormulaListDatabase::class.java,
        "FormulaListDatabase"
    ).build()

    @Singleton
    @Provides
    fun injectFormulaListDao (formulaListDatabase: FormulaListDatabase) = formulaListDatabase.formulaListDao()


}