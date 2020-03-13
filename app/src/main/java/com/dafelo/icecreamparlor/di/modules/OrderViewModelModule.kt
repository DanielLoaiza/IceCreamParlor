package com.dafelo.icecreamparlor.di.modules

import androidx.lifecycle.ViewModel
import com.dafelo.icecreamparlor.di.qualifiers.ViewModelKey
import com.dafelo.icecreamparlor.splash.SplashViewModel
import com.dafelo.icecreamparlor.ui.main.OrderViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class OrderViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(OrderViewModel::class)
    internal abstract fun splashViewModel(viewModel: OrderViewModel): ViewModel
}