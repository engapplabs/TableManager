package com.abuarquemf.tablemanager.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.*
import com.abuarquemf.tablemanager.R
import com.abuarquemf.tablemanager.adapters.OrderAdapter
import com.abuarquemf.tablemanager.adapters.ProductsAdapter
import com.abuarquemf.tablemanager.entities.Order
import com.abuarquemf.tablemanager.entities.Product
import com.abuarquemf.tablemanager.entities.Table
import kotlinx.android.synthetic.main.activity_table_description.*

class TableDescriptionActivity : AppCompatActivity() {

    private var productsMap = HashMap<Int, Product>()

    private var orderCounter = 1

    private val orders = ArrayList<Order>()
    private var ordersAdapters: OrderAdapter? = null
    private var givenTable: Table? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_description)

        ordersAdapters = OrderAdapter(this, orders)
        ordersList.adapter = ordersAdapters

        ///////////MOCK/////////////////////////////////////////////////////
        productsMap.put(505, Product(505, "Coca", 5.0))     //
        productsMap.put(1, Product(1, "Cafe", 3.5))         //
        productsMap.put(2, Product(2, "Cheeseburger", 15.0))//
        ////////////////////////////////////////////////////////////////////

        //getting sent table from main activity
        givenTable = intent.getParcelableExtra<Table>(MainActivity.TABLE_PASS)

        //setting table id
        tableId.text = String.format("Table %d", givenTable!!.getTableId())
        //setting if table is open or not
        if(givenTable!!.isBillOpen)
            tableOpened.text = "Table opened"
        else
            tableOpened.text = "Table closed"
        //setting totalprice
        tablePrice.text = "Total price: R$ " + givenTable!!.totalPrice
        //adding listener to bottom nav view
        bottomOnTables.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.back -> finish()
                R.id.addOrder -> addOrderHandler()
                R.id.checkTable -> checkTableHandler()
            }
            true
        }
    }

    private fun addOrderHandler() {
        var productId = -505
        val onAddProductGUI = AlertDialog.Builder(this)
        onAddProductGUI.setTitle("New order:")
        onAddProductGUI.setIcon(R.drawable.ic_product_add)

        val onAddProductLayout = LayoutInflater.from(this)
                .inflate(R.layout.on_adding_product, null)

        val givenProductName = onAddProductLayout
                .findViewById<EditText>(R.id.givenProductIdEditText)

        var products = ArrayList<Product>()
        var productsAdapter = ProductsAdapter(this, products)

        val productsListView = onAddProductLayout
                .findViewById<ListView>(R.id.currentOrdersListView)
        productsListView.adapter = productsAdapter

        val addProductButton = onAddProductLayout
                .findViewById<ImageButton>(R.id.addProduct)

        addProductButton.setOnClickListener({
            val givenProductInfo = givenProductName.text.toString()
            var validInput = true
            try {
                productId = givenProductInfo.toInt()
            } catch (e: Exception) {
                validInput = false
                if(givenProductInfo == "")
                    Toast.makeText(this, "Type product id", Toast.LENGTH_SHORT).show()
                else
                    Toast.makeText(this, "Type only numbers", Toast.LENGTH_SHORT).show()
            }
            if(validInput) {
                products.add(productsMap[productId]!!)
                productsAdapter.notifyDataSetChanged()
            }
            givenProductName.setText("")
        })

        //setting up layout to GUI
        onAddProductGUI.setView(onAddProductLayout)

        onAddProductGUI.setNegativeButton("Cancel", {dialogInterface, _ ->
            dialogInterface.dismiss()
        })

        onAddProductGUI.setPositiveButton("Ok", {dialogInterface, _ ->
            val currentOrder = Order(orderCounter++, products.sumByDouble { e -> e.getPrice() }, products)
            givenTable!!.addOrder(currentOrder)
            orders.add(currentOrder)
            ordersAdapters!!.notifyDataSetChanged()
            tablePrice.text = "Total price: R$ " + givenTable!!.totalPrice
            dialogInterface.dismiss()
        })

        onAddProductGUI.show()
    }

    private fun checkTableHandler() {
        Toast.makeText(this, "check", Toast.LENGTH_SHORT).show()
    }
}
