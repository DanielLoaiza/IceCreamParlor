package com.dafelo.icecreamparlor.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dafelo.icecreamparlor.OrderActivity
import com.dafelo.icecreamparlor.R
import com.dafelo.icecreamparlor.splash.SplashViewModel
import javax.inject.Inject

class OrderListFragment : Fragment() {

    companion object {
        fun newInstance() = OrderListFragment()
    }

    private lateinit var viewModel: OrderViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.item_product_display, container, false)
    }

    override fun onAttach(context: Context) {
        (context as? OrderActivity)?.orderComponent?.inject(this)
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory).get(OrderViewModel::class.java)
    }

}
