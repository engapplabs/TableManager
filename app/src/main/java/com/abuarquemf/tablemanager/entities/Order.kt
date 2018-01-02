package com.abuarquemf.tablemanager.entities

import java.util.ArrayList

/**
 * Created by animal505 on 29/12/17.
 */

// refact to abstract factory method
class Order {

    var product: String? = null // bottle of water, candle of coke...
    var price: Double = 0.toDouble()
    var orderId: Int = 0
    var orders: MutableList<Product>

    init {
        this.orders = ArrayList()
    }
}
