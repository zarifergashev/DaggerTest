package com.example.mruzbek.daggertest

import android.app.Activity
import android.app.Application
import android.util.Log
import com.example.mruzbek.daggertest.commons.LOG_TAG
import com.example.mruzbek.daggertest.di.DaggerAppComponent
import com.example.mruzbek.daggertest.di.module.AppModule
import com.example.mruzbek.daggertest.di.module.context.ApplicationContextModule
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {


    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .applicationContextModule(ApplicationContextModule(this))
                .build()
                .inject(this)
        Log.d(LOG_TAG, "Application On Created")
    }

    override fun activityInjector() = injector
}
