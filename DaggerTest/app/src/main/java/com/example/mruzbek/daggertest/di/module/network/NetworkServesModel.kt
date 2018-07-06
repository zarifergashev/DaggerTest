package com.example.mruzbek.daggertest.di.module.network

import com.example.mruzbek.daggertest.di.scope.AppScope
import com.example.mruzbek.daggertest.network.INetworkService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [(OkhttpClientModel::class)])
class NetworkServesModel {

    @AppScope
    @Provides
    fun networkServes(retrofit: Retrofit): INetworkService = retrofit.create(INetworkService::class.java)

    @AppScope
    @Provides
    fun retrofit(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory, callAdapterFactory: RxJava2CallAdapterFactory):
            Retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .baseUrl("http://api.openweathermap.org")
            .build()


    @Provides
    fun gson(): Gson = GsonBuilder().create()

    @Provides
    fun gsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    fun callAdapterFactory(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()
}
