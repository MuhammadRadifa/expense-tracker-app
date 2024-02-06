package com.example.expensetrackerapp

import android.app.Application
import com.example.expensetrackerapp.data.Graph

class MainApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}