package com.abuarquemf.tablemanager.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.abuarquemf.tablemanager.R
import com.abuarquemf.tablemanager.entities.Order
import com.abuarquemf.tablemanager.entities.Table

/**
 * Created by animal505 on 29/12/17.
 */

class OrderAdapter(private val context: Context,
                   private val orders: List<Order>) : BaseAdapter() {

    override fun getCount() = this.orders.size


    override fun getItem(i: Int) = this.orders[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View {
        return view
    }
}

