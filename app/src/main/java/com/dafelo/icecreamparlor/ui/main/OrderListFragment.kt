package com.dafelo.icecreamparlor.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.dafelo.icecreamparlor.OrderActivity
import com.dafelo.icecreamparlor.R
import com.dafelo.icecreamparlor.common.TouchDetectorListener
import com.dafelo.icecreamparlor.products.OrderProduct
import com.dafelo.icecreamparlor.splash.SplashViewModel
import kotlinx.android.synthetic.main.main_fragment.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class OrderListFragment : Fragment(), TouchDetectorListener {

    companion object {
        fun newInstance() = OrderListFragment()
    }

    private lateinit var viewModel: OrderViewModel

    private var orderListAdapter: OrderListAdapter? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        (context as? OrderActivity)?.orderComponent?.inject(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(OrderViewModel::class.java)
        super.onAttach(context)
        lifecycleScope.launch {
            viewModel.getProducts().observe(this@OrderListFragment, Observer {
                orderListAdapter?.updateDataset(it)
            })
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView_items.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            orderListAdapter = OrderListAdapter(requireContext(), mutableListOf(),this@OrderListFragment)
            adapter = orderListAdapter
        }
        button_purchase.text = String.format(getString(R.string.order_items_count), 0)
        button_purchase.setOnClickListener {
            proceedToReceipt()
        }
    }

    private fun proceedToReceipt() {

    }

    override fun onDoubleTap(v: View?) {
        v?.let {
            val totalItems = viewModel.addItemToOrder(v.tag as String)
            button_purchase.text = String.format(getString(R.string.order_items_count), totalItems)
        }
    }

    override fun onTripleTap(v: View?) {
        v?.let {
            val totalItems = viewModel.removeItemsFromOrder(v.tag as String)
            button_purchase.text = String.format(getString(R.string.order_items_count), totalItems)
        }
    }


}
