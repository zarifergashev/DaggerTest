package com.example.mruzbek.daggertest.di

import com.example.mruzbek.daggertest.App
import com.example.mruzbek.daggertest.di.module.ActivityModule
import com.example.mruzbek.daggertest.di.module.AppModule
import com.example.mruzbek.daggertest.di.module.LodderModel
import com.example.mruzbek.daggertest.di.module.network.NetworkServesModel
import com.example.mruzbek.daggertest.di.scope.AppScope
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule

@AppScope
@Component(modules = [
    (NetworkServesModel::class),
    (AppModule::class),
    (LodderModel::class),
    (ActivityModule::class),
    (AndroidInjectionModule::class),
    (AndroidSupportInjectionModule::class)])
interface AppComponent {
    fun inject(app: App)
}