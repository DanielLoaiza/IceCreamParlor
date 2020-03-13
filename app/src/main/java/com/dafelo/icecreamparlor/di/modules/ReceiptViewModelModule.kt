package com.dafelo.icecreamparlor.di.modules

import androidx.lifecycle.ViewModel
import com.dafelo.icecreamparlor.di.qualifiers.ViewModelKey
import com.dafelo.icecreamparlor.splash.SplashViewModel
import com.dafelo.icecreamparlor.ui.main.ReceiptViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelModule::class])
abstract class ReceiptViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ReceiptViewModel::class)
    internal abstract fun receiptViewModel(viewModel: ReceiptViewModel): ViewModel
}