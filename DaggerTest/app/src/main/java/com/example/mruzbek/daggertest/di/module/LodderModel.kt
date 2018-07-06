package com.example.mruzbek.daggertest.di.module

import com.example.mruzbek.daggertest.commons.Logger
import com.example.mruzbek.daggertest.di.scope.AppScope
import dagger.Module
import dagger.Provides

@AppScope
@Module
class LodderModel {
    @AppScope
    @Provides
    fun logger(): Logger = Logger()
}