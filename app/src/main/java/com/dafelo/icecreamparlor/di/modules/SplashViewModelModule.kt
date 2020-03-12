package com.dafelo.icecreamparlor.di.modules

import androidx.lifecycle.ViewModel
import com.dafelo.icecreamparlor.di.qualifiers.ViewModelKey
import com.dafelo.icecreamparlor.splash.SplashViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class SplashViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel
}