package com.example.helderrocha.dataapplication.view.api

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module()
class NetworkModule {
    @Provides
    @Singleton
    fun providesGitApi(): ApiClient {

        val gson = GsonBuilder()
                .setLenient()
                .create()

        val gitApi = Retrofit.Builder()
                .baseUrl(GitApi.URL)
                .client(OkHttpClient.Builder().build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(GitApi::class.java)
        return ApiClient(gitApi)
    }
}