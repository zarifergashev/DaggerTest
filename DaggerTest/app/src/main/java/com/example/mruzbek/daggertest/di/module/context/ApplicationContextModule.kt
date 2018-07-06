package com.example.mruzbek.daggertest.di.module.context

import android.content.Context
import com.example.mruzbek.daggertest.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module

class ApplicationContextModule(private var context: Context) {
    @ApplicationContext
    @AppScope
    @Provides
    fun getcontext(): Context = context.applicationContext
}


