package com.abuarquemf.tablemanager.entities

/**
 * Created by animal505 on 29/12/17.
 */
class Product {

    private var name: String? = null
    private var price: Double = 0.0

    fun setName(name: String) {
        this.name = name
    }

    fun getName() = name!!

    fun getPrice() = price

    fun setPrice(price: Double) {
        this.price = price
    }
}

