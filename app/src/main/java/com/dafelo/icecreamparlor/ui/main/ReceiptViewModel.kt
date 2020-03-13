package com.dafelo.icecreamparlor.ui.main

import androidx.lifecycle.ViewModel
import com.dafelo.icecreamparlor.di.qualifiers.ActivityScope
import com.dafelo.icecreamparlor.order.OrderController
import javax.inject.Inject

@ActivityScope
class ReceiptViewModel @Inject constructor(private val orderController: OrderController) : ViewModel() {

    fun getCurrentOrder() = orderController.currentOrder

    fun getCurrentOrderTotal() = orderController.getCurrentOrderTotal()
}