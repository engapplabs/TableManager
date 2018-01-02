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
import com.abuarquemf.tablemanager.entities.Product

/**
 * Created by animal505 on 29/12/17.
 */

//TODO bota logo pra pegar os produtos
class OrderAdapter(private val context: Context,
                   private val products: ArrayList<Product>) : BaseAdapter() {

    override fun getCount() = this.products.size

    override fun getItem(i: Int) = this.products[i]

    override fun getItemId(i: Int) = i.toLong()

    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View {
       return view
    }
}

