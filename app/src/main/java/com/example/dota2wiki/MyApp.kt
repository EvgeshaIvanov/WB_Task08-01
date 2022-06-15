package com.example.dota2wiki

import android.app.Application
import android.content.Context

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }

    companion object {

        private var appInstance: MyApp? = null

        fun getApplicationContext(): Context {
            return appInstance!!.applicationContext
        }
    }


}