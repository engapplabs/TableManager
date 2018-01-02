package com.abuarquemf.tablemanager.entities

import java.util.ArrayList

/**
 * Created by animal505 on 29/12/17.
 */

// refact to abstract factory method
class Order(val orderId: Int) {

    var product: String? = null // bottle of water, candle of coke...
    var price: Double = 0.toDouble()
    var orders: List<Product>? = null

    constructor(orderId: Int, price: Double): this(orderId) {
        this.orders = ArrayList()
        this.price = price
    }
}
