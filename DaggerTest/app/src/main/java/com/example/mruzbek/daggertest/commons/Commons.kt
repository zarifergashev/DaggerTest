package com.example.mruzbek.daggertest.commons

import okhttp3.HttpUrl


const val LOG_TAG = "tag"
const val MYAPPID = "ef963eb7b7c58ecd7839afb46125441e"
const val NETWORK_CONNECTION_TIME = 30L
const val NETWORK_READ_TIME = 30L
const val NETWORK_WRITE_TIME = 30L
const val NETWORK_CACHE_SIZE = 10 * 1000 * 1000L //10 MB
const val NETWORK_CACHE_NAME = "HttpCache"


fun HttpUrl.gethttpUrl(lat: Double?, lon: Double?): HttpUrl {
    return HttpUrl.Builder()
            .scheme("http")
            .host("api.openweathermap.org")
            .addPathSegment("data")
            .addPathSegment("2.5")
            .addPathSegment("weather")
            .addQueryParameter("lat", lat.toString())
            .addQueryParameter("lon", lon.toString())
            .addQueryParameter("appid", MYAPPID)
            .build()
}
