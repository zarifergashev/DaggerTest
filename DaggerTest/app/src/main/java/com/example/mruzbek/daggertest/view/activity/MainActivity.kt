package com.example.mruzbek.daggertest.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.mruzbek.daggertest.R
import com.example.mruzbek.daggertest.commons.LOG_TAG
import com.example.mruzbek.daggertest.commons.Logger
import com.example.mruzbek.daggertest.network.INetworkService
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var inetManager: INetworkService

    @Inject
    lateinit var logger: Logger

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            Log.d(LOG_TAG, "${inetManager.hashCode()}")
            logger.log("salom")
        }
    }


}
