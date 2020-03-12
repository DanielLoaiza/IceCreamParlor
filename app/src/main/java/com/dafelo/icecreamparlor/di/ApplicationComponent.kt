package com.dafelo.icecreamparlor.di

import android.content.Context
import com.dafelo.icecreamparlor.di.modules.NetworkModule
import com.dafelo.icecreamparlor.di.modules.SubcomponentsModule
import com.dafelo.icecreamparlor.di.qualifiers.ApplicationContext
import com.dafelo.icecreamparlor.di.qualifiers.SplashComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [SubcomponentsModule::class, NetworkModule::class])
@Singleton
interface ApplicationComponent {

    fun splashComponent(): SplashComponent.Factory

    @Component.Factory
    interface Factory {
        fun create(@ApplicationContext @BindsInstance appContext: Context): ApplicationComponent

    }
}