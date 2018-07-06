package com.example.mruzbek.daggertest.di.module

import com.example.mruzbek.daggertest.App
import com.example.mruzbek.daggertest.di.scope.AppScope
import dagger.Module
import dagger.Provides

@AppScope
@Module
class AppModule(private val app: App) {
    @AppScope
    @Provides
    fun instanse() = app
}
