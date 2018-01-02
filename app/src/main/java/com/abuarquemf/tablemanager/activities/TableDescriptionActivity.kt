package com.abuarquemf.tablemanager.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abuarquemf.tablemanager.R
import com.abuarquemf.tablemanager.adapters.OrderAdapter
import com.abuarquemf.tablemanager.entities.Order
import com.abuarquemf.tablemanager.entities.Table
import kotlinx.android.synthetic.main.activity_table_description.*

class TableDescriptionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_description)

        val givenTable = intent.getParcelableExtra<Table>(MainActivity.TABLE_PASS)

        tableId.text = String.format("Table %d", givenTable.getTableId())
        if(givenTable.isBillOpen)
            tableOpened.text = "Table opened"
        else
            tableOpened.text = "Table closed"

        tablePrice.text = "Total price: R$ " + givenTable.totalPrice

        val orders = ArrayList<Order>()

        ordersList.adapter = OrderAdapter(this, orders)


    }
}
