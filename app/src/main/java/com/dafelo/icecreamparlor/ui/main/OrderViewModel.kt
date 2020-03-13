package com.dafelo.icecreamparlor.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.dafelo.icecreamparlor.di.qualifiers.ActivityScope
import com.dafelo.icecreamparlor.order.OrderController
import com.dafelo.icecreamparlor.products.Product
import com.dafelo.icecreamparlor.products.ProductRepository
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@ActivityScope
class OrderViewModel @Inject constructor(
    private val productRepository: ProductRepository,
    private val orderController: OrderController
) :
    ViewModel() {
    private var productsCache = mapOf<String, Product>()

    suspend fun getProducts() =
        liveData(Dispatchers.IO) {
            val products = productRepository.getProducts()
            productsCache = products.map { it.name to it }.toMap()
            emit(products)
        }

    fun removeItemsFromOrder(productId: String): Int {

        return orderController.removeItemsFromOrder(productId)
    }

    fun addItemToOrder(productId: String): Int {
        var currentCount = 0
        if (productId in productsCache) {
           currentCount = orderController.addItemToOrder(productsCache[productId]!!)
        }
        return currentCount
    }
}
