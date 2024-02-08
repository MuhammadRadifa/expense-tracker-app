package com.example.expensetrackerapp

import android.app.Application
import com.example.expensetrackerapp.data.Graph
import com.example.expensetrackerapp.data.OnBoardingRepository

class MainApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        OnBoardingRepository.initialize(this)
        Graph.provide(this)
    }
}