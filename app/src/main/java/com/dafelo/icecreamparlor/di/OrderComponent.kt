package com.dafelo.icecreamparlor.di

import com.dafelo.icecreamparlor.OrderActivity
import com.dafelo.icecreamparlor.di.modules.OrderViewModelModule
import com.dafelo.icecreamparlor.di.modules.ReceiptViewModelModule
import com.dafelo.icecreamparlor.di.qualifiers.ActivityScope
import com.dafelo.icecreamparlor.ui.main.OrderListFragment
import com.dafelo.icecreamparlor.ui.main.ReceiptFragment
import dagger.Subcomponent

@Subcomponent(modules = [OrderViewModelModule::class, ReceiptViewModelModule::class])
@ActivityScope
interface OrderComponent {

    // Factory that is used to create instances of this component
    @Subcomponent.Factory
    interface Factory {
        fun create(): OrderComponent
    }

    fun inject(mainActivity: OrderActivity)
    fun inject(orderListFragment: OrderListFragment)
    fun inject(orderListFragment: ReceiptFragment)
}