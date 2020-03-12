package com.dafelo.icecreamparlor.di.qualifiers

import com.dafelo.icecreamparlor.SplashActivity
import com.dafelo.icecreamparlor.di.modules.SplashViewModelModule
import dagger.Subcomponent

@Subcomponent(modules = [SplashViewModelModule::class])
@ActivityScope
interface SplashComponent {

    // Factory that is used to create instances of this component
    @Subcomponent.Factory
    interface Factory {
        fun create(): SplashComponent
    }

    fun inject(splashActivity: SplashActivity)
}