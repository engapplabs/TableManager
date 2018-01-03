package com.abuarquemf.tablemanager.entities

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by animal505 on 29/12/17.
 */
class Product(private var id: Int, private var name: String, private var price: Double) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readDouble()) {
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getName() = name!!

    fun getId() = id

    fun getPrice() = price

    fun setPrice(price: Double) {
        this.price = price
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}

