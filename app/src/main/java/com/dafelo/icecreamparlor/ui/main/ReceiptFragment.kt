package com.dafelo.icecreamparlor.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.dafelo.icecreamparlor.OrderActivity
import com.dafelo.icecreamparlor.R
import kotlinx.android.synthetic.main.main_fragment.recyclerView_items
import kotlinx.android.synthetic.main.receipt_fragment.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class ReceiptFragment : Fragment() {

    companion object {
        fun newInstance() = ReceiptFragment()
    }

    private lateinit var viewModel: ReceiptViewModel

    private var orderListAdapter: OrderListAdapter? = null

    private var orderChangeListener: OrderChangeListener? = null

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.receipt_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        (context as? OrderActivity)?.orderComponent?.inject(this)
        orderChangeListener = context as? OrderChangeListener
        viewModel = ViewModelProvider(this, viewModelFactory).get(ReceiptViewModel::class.java)
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        orderChangeListener = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button_finish.setOnClickListener {
            viewModel.startNewOrder()
            orderChangeListener?.startNewOrder()
        }
        textView_total_price.text = String.format(getString(R.string.price_format), viewModel.getCurrentOrderTotal().toString())
    }


}
