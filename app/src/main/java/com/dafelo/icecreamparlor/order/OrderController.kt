package com.dafelo.icecreamparlor.order

import com.dafelo.icecreamparlor.products.OrderProduct
import com.dafelo.icecreamparlor.products.Product
import java.math.BigDecimal
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrderController @Inject constructor() {
    private val _currentOrder = mutableMapOf<String, OrderProduct>()
    private var currentCount = 0
    val currentOrder: Map<String, OrderProduct>
        get() = _currentOrder

    fun removeItemsFromOrder(productId: String): Int {
        if (productId in _currentOrder) {
            val orderProduct = _currentOrder[productId]!!
            currentCount -= (orderProduct.quantity)
            _currentOrder.remove(productId)
        }
        return currentCount
    }

    fun addItemToOrder(product: Product): Int {
        currentCount += 1
        if (product.name in _currentOrder) {
            val orderProduct = _currentOrder[product.name]!!
            _currentOrder[product.name] = orderProduct.copy(quantity = orderProduct.quantity + 1)
        } else {
            _currentOrder[product.name] = OrderProduct(product, 1)
        }
        return currentCount
    }

    fun getCurrentOrderTotal(): BigDecimal {
        return _currentOrder.map { it.value }
            .fold(BigDecimal.ZERO) { acc, orderProduct ->
                val productPrice = orderProduct.product.price
                val price = BigDecimal(productPrice.substring(1, productPrice.length))
                val quantity = BigDecimal(orderProduct.quantity)
                acc.add(price.multiply(quantity))
            }
    }

    fun startNewOrder() {
        currentCount = 0
        _currentOrder.clear()
    }
}