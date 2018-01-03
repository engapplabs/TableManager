package com.abuarquemf.tablemanager.entities

import android.os.Parcel
import android.os.Parcelable
import kotlin.collections.ArrayList

/**
 * Created by animal505 on 29/12/17.
 */

data class Order(val orderId: Int, val price: Double, val orders: ArrayList<Product>): Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readDouble(),
            TODO("orders")) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(orderId)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Order> {
        override fun createFromParcel(parcel: Parcel): Order {
            return Order(parcel)
        }

        override fun newArray(size: Int): Array<Order?> {
            return arrayOfNulls(size)
        }
    }
}