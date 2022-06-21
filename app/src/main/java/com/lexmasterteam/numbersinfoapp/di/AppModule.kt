package com.lexmasterteam.numbersinfoapp.di

import com.lexmasterteam.numbersinfoapp.common.Constants
import com.lexmasterteam.numbersinfoapp.data.remote.NumberApi
import com.lexmasterteam.numbersinfoapp.data.remote.repository.NumberRepositoryImpl
import com.lexmasterteam.numbersinfoapp.domain.repository.NumberRepository
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
}