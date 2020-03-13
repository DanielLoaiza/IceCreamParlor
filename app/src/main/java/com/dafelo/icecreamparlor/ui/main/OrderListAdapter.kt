package com.dafelo.icecreamparlor.ui.main

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.dafelo.icecreamparlor.R
import com.dafelo.icecreamparlor.products.Product


class OrderListAdapter(context: Context, private val orderProducts: MutableList<Product>) :
    RecyclerView.Adapter<OrderListAdapter.OrderListViewHolder>() {

    val images = mapOf(
        "cone" to context.getDrawable(R.drawable.cone),
        "froyo" to context.getDrawable(R.drawable.froyo),
        "ice_cream" to context.getDrawable(R.drawable.ice_cream),
        "popsicle" to context.getDrawable(R.drawable.popsicle)
    )

    fun updateDataset(orderProducts: List<Product>) {
        this.orderProducts.clear()
        this.orderProducts.addAll(orderProducts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return OrderListViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = orderProducts.size

    override fun onBindViewHolder(holder: OrderListViewHolder, position: Int) {
        val product: Product = orderProducts[position]
        holder.bind(product)
    }

    inner class OrderListViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_product_display, parent, false)) {
        private var title: TextView? = null
        private var price: TextView? = null
        private var image: ImageView? = null
        private var backgroundContainer: View? = null


        init {
            title = itemView.findViewById(R.id.textView_title)
            price = itemView.findViewById(R.id.textView_price)
            image = itemView.findViewById(R.id.product_image)
            backgroundContainer = itemView.findViewById(R.id.linearLayout_background_item)
        }

        fun bind(product: Product) {
            title?.text = product.name
            price?.text = product.price
            if (product.type in images) {
                image?.setImageDrawable(images[product.type])
            }

            backgroundContainer?.background?.let {
                val wrappedDrawable = DrawableCompat.wrap(it)
                DrawableCompat.setTint(wrappedDrawable, Color.parseColor(product.backgroundColor))
                backgroundContainer?.setBackgroundDrawable(wrappedDrawable)
            }



        }

    }
}