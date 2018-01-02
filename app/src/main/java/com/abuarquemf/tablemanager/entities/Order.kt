package com.abuarquemf.tablemanager.entities

import java.util.ArrayList

/**
 * Created by animal505 on 29/12/17.
 */

// refact to abstract factory method
data class Order(val orderId: Int, val price: Double, val orders: List<Product>)
