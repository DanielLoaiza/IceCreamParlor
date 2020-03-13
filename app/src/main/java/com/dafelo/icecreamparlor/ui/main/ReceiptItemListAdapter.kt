package com.dafelo.icecreamparlor.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dafelo.icecreamparlor.R
import com.dafelo.icecreamparlor.products.OrderProduct

class ReceiptItemListAdapter(private val orderProducts: List<OrderProduct>) :
    RecyclerView.Adapter<ReceiptItemListAdapter.ReceiptItemListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceiptItemListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ReceiptItemListViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = orderProducts.size

    override fun onBindViewHolder(holder: ReceiptItemListViewHolder, position: Int) {
        val orderProduct: OrderProduct = orderProducts[position]
        holder.bind(orderProduct)
    }

    inner class ReceiptItemListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_receipt_display, parent, false)) {
        private var title: TextView? = null
        private var price: TextView? = null
        private var quantity: TextView? = null


        init {
            title = itemView.findViewById(R.id.textView_name)
            price = itemView.findViewById(R.id.textView_price)
            quantity = itemView.findViewById(R.id.textView_quantity)
        }

        fun bind(orderProducts: OrderProduct) {
            title?.text = orderProducts.product.name
            quantity?.text = orderProducts.quantity.toString()
            price?.text = orderProducts.product.price
        }

    }
}