package com.lexmasterteam.numbersinfoapp.di

import android.app.Application
import androidx.room.Room
import com.lexmasterteam.numbersinfoapp.common.Constants
import com.lexmasterteam.numbersinfoapp.data.internal.data_source.NumberFactDatabase
import com.lexmasterteam.numbersinfoapp.data.internal.repository.NumberFactSavedRepositoryImpl
import com.lexmasterteam.numbersinfoapp.data.remote.NumberApi
import com.lexmasterteam.numbersinfoapp.data.remote.repository.NumberRepositoryImpl
import com.lexmasterteam.numbersinfoapp.domain.repository.NumberFactSavedRepository
import com.lexmasterteam.numbersinfoapp.domain.repository.NumberRepository
import com.lexmasterteam.numbersinfoapp.domain.use_case.internal.AddNumberFact
import com.lexmasterteam.numbersinfoapp.domain.use_case.internal.GetNumberFacts
import com.lexmasterteam.numbersinfoapp.domain.use_case.internal.NumbersFactUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNumberApi():NumberApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NumberApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNumberFactRepository(api: NumberApi): NumberRepository {
        return NumberRepositoryImpl(api)
    }


    //ROOM DB

    @Provides
    @Singleton
    fun provideNumberFactDatabase(app:Application): NumberFactDatabase{
        return Room.databaseBuilder(
            app,
            NumberFactDatabase::class.java,
            NumberFactDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNumberSavedFactRepository(db: NumberFactDatabase): NumberFactSavedRepository{
        return NumberFactSavedRepositoryImpl(db.numberFactDao)
    }

    @Provides
    @Singleton
    fun provideNumberFactUseCases(repository: NumberFactSavedRepository):NumbersFactUseCases{
        return NumbersFactUseCases(
            getNumberFacts = GetNumberFacts(repository),
            addNumberFact = AddNumberFact(repository)
        )
    }


}