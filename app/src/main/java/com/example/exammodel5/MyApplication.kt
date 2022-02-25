package com.example.exammodel5

import android.app.Application
import android.util.Log

class MyApplication : Application() {

    companion object {
        private const val TAG: String = "MyApplication"
    }

    override fun onCreate() {
        super.onCreate()

        Log.d(TAG, "onCreate: ")
    }

}