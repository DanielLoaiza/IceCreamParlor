package com.dafelo.icecreamparlor.products

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(private val productsService: ProductsService) {

    var productsCache = emptyList<Product>()
        private set

    suspend fun getProducts(): List<Product> {
        return coroutineScope {
            val productsRequest = async { productsService.getProducts() }
            return@coroutineScope productsRequest.await()

        }
    }
}