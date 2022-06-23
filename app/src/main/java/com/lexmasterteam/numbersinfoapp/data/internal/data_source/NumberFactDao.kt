package com.lexmasterteam.numbersinfoapp.data.internal.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberFactDao {

    @Query("SELECT * FROM savednumberfact")
    fun getNumberFacts(): Flow<List<SavedNumberFact>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNumberFact(fact: SavedNumberFact)
}