package com.dafelo.icecreamparlor.order

import com.dafelo.icecreamparlor.products.OrderProduct
import com.dafelo.icecreamparlor.products.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderController @Inject constructor() {
    val currentOrder = mutableMapOf<String, OrderProduct>()
    private var currentCount = 0

    fun removeItemsFromOrder(productId: String): Int {
        if (productId in currentOrder) {
            val orderProduct = currentOrder[productId]!!
            currentCount -= (orderProduct.quantity)
            currentOrder.remove(productId)
        }
        return currentCount
    }

    fun addItemToOrder(product: Product): Int {
        currentCount += 1
        if (product.name in currentOrder) {
            val orderProduct = currentOrder[product.name]!!
            currentOrder[product.name] = orderProduct.copy(quantity = orderProduct.quantity + 1)
        } else {
            currentOrder[product.name] = OrderProduct(product, 1)
        }
        return currentCount
    }
}