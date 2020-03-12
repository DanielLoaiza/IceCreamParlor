package com.dafelo.icecreamparlor

import com.dafelo.icecreamparlor.di.ApplicationComponent
import android.app.Application
import com.dafelo.icecreamparlor.di.DaggerApplicationComponent

class Application : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        applicationComponent = DaggerApplicationComponent
            .factory()
            .create(this)

        super.onCreate()
    }
}