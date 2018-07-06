package com.example.mruzbek.daggertest.di.subcomponent

import com.example.mruzbek.daggertest.di.scope.MainActivityScope
import com.example.mruzbek.daggertest.view.activity.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@MainActivityScope
@Subcomponent
interface MainActivtySubComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>() {

    }
}