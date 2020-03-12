package com.dafelo.icecreamparlor.di.modules

import androidx.lifecycle.ViewModelProvider
import com.dafelo.icecreamparlor.common.ViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}