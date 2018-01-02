package com.abuarquemf.tablemanager.entities

import android.os.Parcel
import android.os.Parcelable
import java.util.ArrayList

/**
 * Created by animal505 on 29/12/17.
 */

class Table() : Parcelable {

    private var tableId: Int = 0
    private var orders: MutableList<Order> = ArrayList()
    var totalPrice: Double = 0.toDouble()
    var isBillOpen: Boolean = false

    constructor(parcel: Parcel) : this() {
        tableId = parcel.readInt()
        totalPrice = parcel.readDouble()
        isBillOpen = parcel.readByte() != 0.toByte()
    }

    constructor(tableId: Int) : this() {
        this.tableId = tableId
        this.totalPrice = 0.0
        this.isBillOpen = true
    }

    fun getTableId() = tableId

    fun getOrders(): List<Order> {
        return orders
    }

    fun addOrder(order: Order) {
        this.orders.add(order)
        this.totalPrice += order.price
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(tableId)
        parcel.writeDouble(totalPrice)
        parcel.writeByte(if (isBillOpen) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Table> {
        override fun createFromParcel(parcel: Parcel): Table {
            return Table(parcel)
        }

        override fun newArray(size: Int): Array<Table?> {
            return arrayOfNulls(size)
        }
    }
}
