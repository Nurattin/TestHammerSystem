package com.example.testhammersystem.data.di

import android.app.Application
import androidx.room.Room
import com.example.testhammersystem.BuildConfig
import com.example.testhammersystem.data.local.FoodDao
import com.example.testhammersystem.data.local.FoodDatabase
import com.example.testhammersystem.data.network.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {

        val okHttpClient = OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideFoodDatabase(app: Application): FoodDatabase {
        return Room.databaseBuilder(
            app, FoodDatabase::class.java, "food_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFoodDao(database: FoodDatabase): FoodDao{
        return database.dao
    }

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): Api {
        return retrofit.create(Api::class.java)
    }
}