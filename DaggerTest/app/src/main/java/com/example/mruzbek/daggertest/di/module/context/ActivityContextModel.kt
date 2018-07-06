package com.example.mruzbek.daggertest.di.module.context

import android.content.Context
import com.example.mruzbek.daggertest.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
class ActivityContextModel(private var context: Context) {
    @ActivityContext
    @AppScope
    @Provides
    fun getContext(): Context = context
}