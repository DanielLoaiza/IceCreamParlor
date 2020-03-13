package com.dafelo.icecreamparlor.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dafelo.icecreamparlor.products.ProductRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class OrderViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    suspend fun getProducts() =
        liveData(Dispatchers.IO) {
            emit(productRepository.getProducts())
        }
}
