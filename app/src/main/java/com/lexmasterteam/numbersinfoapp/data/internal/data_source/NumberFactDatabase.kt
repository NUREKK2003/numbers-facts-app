package com.lexmasterteam.numbersinfoapp.data.internal.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.lexmasterteam.numbersinfoapp.domain.model.SavedNumberFact

@Database(
    entities = [SavedNumberFact::class],
    version = 1
)
abstract class NumberFactDatabase: RoomDatabase() {

    abstract val numberFactDao: NumberFactDao

    companion object{
        const val DATABASE_NAME = "numberfact_db"
    }
}