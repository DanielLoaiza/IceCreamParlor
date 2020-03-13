package com.dafelo.icecreamparlor.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.HORIZONTAL
import android.widget.LinearLayout.VERTICAL
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.dafelo.icecreamparlor.OrderActivity
import com.dafelo.icecreamparlor.R
import kotlinx.android.synthetic.main.main_fragment.recyclerView_items
import kotlinx.android.synthetic.main.receipt_fragment.*
import javax.inject.Inject


class ReceiptFragment : Fragment() {

    companion object {
        fun newInstance() = ReceiptFragment()
    }

    private lateinit var viewModel: ReceiptViewModel

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
        recyclerView_items.apply {
            layoutManager = LinearLayoutManager(requireContext())
            val dividerItemDecoration = DividerItemDecoration(
                requireContext(), HORIZONTAL
            )
            addItemDecoration(dividerItemDecoration)
            adapter = ReceiptItemListAdapter(viewModel.getCurrentOrder().map { it.value })
        }
        textView_total_price.text = String.format(
            getString(R.string.price_format),
            viewModel.getCurrentOrderTotal().toString()
        )
    }


}
