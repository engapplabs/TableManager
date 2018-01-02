package com.abuarquemf.tablemanager.entities

/**
 * Created by animal505 on 29/12/17.
 */
class Product(private var id: Int, private var name: String, private var price: Double) {

    fun setName(name: String) {
        this.name = name
    }

    fun getName() = name!!

    fun getId() = id

    fun getPrice() = price

    fun setPrice(price: Double) {
        this.price = price
    }
}

