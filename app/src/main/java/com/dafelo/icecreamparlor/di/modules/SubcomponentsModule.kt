package com.dafelo.icecreamparlor.di.modules

import com.dafelo.icecreamparlor.di.OrderComponent
import com.dafelo.icecreamparlor.di.SplashComponent
import dagger.Module

@Module(subcomponents = [SplashComponent::class, OrderComponent::class])
class SubcomponentsModule