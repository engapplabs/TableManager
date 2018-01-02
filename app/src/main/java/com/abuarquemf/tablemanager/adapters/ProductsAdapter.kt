package com.abuarquemf.tablemanager.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.abuarquemf.tablemanager.R
import com.abuarquemf.tablemanager.entities.Product

/**
 * Created by animal505 on 02/01/18.
 */

class ProductsAdapter(private var context: Context,
                      private var products: List<Product>) : BaseAdapter() {

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var view = p1
        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.current_product_layout, null)

        val product = products.get(p0)

        val currentProductName = view!!.findViewById<TextView>(R.id.currentProduct)
        currentProductName.text = product.getName()
        return view!!
    }

    override fun getItem(p0: Int) = products[p0]

    override fun getItemId(p0: Int) = p0.toLong()

    override fun getCount() = products.size

}
