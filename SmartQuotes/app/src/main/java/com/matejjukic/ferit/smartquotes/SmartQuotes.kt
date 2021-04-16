package com.matejjukic.ferit.smartquotes

import android.app.Application

class SmartQuotes : Application() {
    companion object {
        private lateinit var context: Application
        fun getContext () = context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
    }
}