package com.example.mruzbek.daggertest.di.module.network

import android.content.Context
import android.util.Log
import com.example.mruzbek.daggertest.commons.*
import com.example.mruzbek.daggertest.di.module.context.ApplicationContext
import com.example.mruzbek.daggertest.di.module.context.ApplicationContextModule
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.concurrent.TimeUnit

@Module(includes = [(ApplicationContextModule::class)])
class OkhttpClientModel {
    @Provides
    fun okHttpClient(cache: Cache,
                     loggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(NETWORK_CONNECTION_TIME, TimeUnit.SECONDS)
            .readTimeout(NETWORK_READ_TIME, TimeUnit.SECONDS)
            .writeTimeout(NETWORK_WRITE_TIME, TimeUnit.SECONDS)
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptors = HttpLoggingInterceptor {
            Log.d(LOG_TAG, it)
        }
        loggingInterceptors.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptors
    }

    @Provides
    fun cache(file: File): Cache = Cache(file, NETWORK_CACHE_SIZE)//cache 10 MB

    @Provides
    fun file(@ApplicationContext context: Context): File {
        val file = File(context.cacheDir, NETWORK_CACHE_NAME)
        file.mkdirs()
        return file
    }

}