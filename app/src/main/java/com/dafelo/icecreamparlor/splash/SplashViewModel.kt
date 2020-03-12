package com.dafelo.icecreamparlor.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dafelo.icecreamparlor.di.qualifiers.ActivityScope
import com.dafelo.icecreamparlor.products.ProductRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@ActivityScope
class SplashViewModel @Inject constructor(private val productRepository: ProductRepository): ViewModel() {

    suspend fun getProducts() = liveData(Dispatchers.IO) {
        emit(productRepository.getProducts())
    }
}