package com.example.mruzbek.daggertest.network

import com.example.mruzbek.daggertest.network.pojos.WeatherPojoClass
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface INetworkService {
    @GET("/data/2.5/weather?")
    fun loadWeaterInfo(
            @Query("lat") lat: String,
            @Query("lon") lon: String,
            @Query("appid") appid: String): Single<WeatherPojoClass>

}
