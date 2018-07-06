package com.example.mruzbek.daggertest.di.module

import android.app.Activity
import com.example.mruzbek.daggertest.di.subcomponent.MainActivtySubComponent
import com.example.mruzbek.daggertest.view.activity.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivtySubComponent::class])
abstract class ActivityModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindMainActivty(builder: MainActivtySubComponent.Builder): AndroidInjector.Factory<out Activity>
}