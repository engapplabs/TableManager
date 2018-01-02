package com.abuarquemf.tablemanager.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.Spinner
import com.abuarquemf.tablemanager.R
import com.abuarquemf.tablemanager.entities.Order

/**
 * Created by animal505 on 29/12/17.
 */

class OrderAdapter(private val context: Context,
                   private val orders: ArrayList<Order>) : BaseAdapter() {

    override fun getCount() = this.orders.size


    override fun getItem(i: Int) = this.orders[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View {
        var guiView = view
        if(guiView == null)
            guiView = LayoutInflater.from(context).inflate(R.layout.order_layout_description, null)
        val order = orders.get(i)
        val orderDescriptorSpinner = guiView.findViewById<Spinner>(R.id.productSpinner)
        val simpleAdapter = ArrayAdapter<String>(context, android.R.layout.simple_spinner_dropdown_item, arrayListOf("oi", "vaca"))
        orderDescriptorSpinner.adapter = simpleAdapter
        return guiView!!
    }
}

