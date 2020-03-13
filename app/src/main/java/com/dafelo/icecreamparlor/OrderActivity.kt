package com.dafelo.icecreamparlor

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.dafelo.icecreamparlor.di.OrderComponent
import com.dafelo.icecreamparlor.ui.main.OrderListFragment

class OrderActivity : AppCompatActivity() {

    lateinit var orderComponent: OrderComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        orderComponent =
            (application as Application).applicationComponent.ordersComponent().create()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM;
        supportActionBar?.setCustomView(R.layout.custom_action_bar_layout);
        displayProductCatalog()
    }

    private fun displayProductCatalog() {
        supportActionBar?.customView?.findViewById<AppCompatTextView>(R.id.textView_title)?.text =
            getString(R.string.order_list_label)
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, OrderListFragment.newInstance())
            .commit()
    }
}
