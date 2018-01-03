package com.abuarquemf.tablemanager.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.abuarquemf.tablemanager.R
import com.abuarquemf.tablemanager.entities.Order

class OrderAdapter(private val context: Context,
                   private val orders: List<Order>) : BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var layout = p1
        if(layout == null)
            layout = LayoutInflater.from(context).inflate(R.layout.orders_indicator_layout, null)
        val currentOrder = orders[p0]
        val orderInfoTextView = layout!!.findViewById<TextView>(R.id.orderItemCounter)
        orderInfoTextView.text = "Order ${currentOrder.orderId}"
        return layout!!
    }

    override fun getItem(p0: Int) = orders[p0]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getCount() = orders.size
}

