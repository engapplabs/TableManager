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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_table_description)

        ///////////MOCK/////////////////////////////////////
        productsMap.put(505, Product(505, "Coca", 5.0))

        val givenTable = intent.getParcelableExtra<Table>(MainActivity.TABLE_PASS)

        tableId.text = String.format("Table %d", givenTable.getTableId())
        if(givenTable.isBillOpen)
            tableOpened.text = "Table opened"
        else
            tableOpened.text = "Table closed"

        tablePrice.text = "Total price: R$ " + givenTable.totalPrice

        val orders = ArrayList<Order>()

        ordersList.adapter = OrderAdapter(this, orders)

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

        val givenProductName = onAddProductLayout.findViewById<EditText>(R.id.givenProductIdEditText)

        var products = ArrayList<Product>()
        var productsAdapter = ProductsAdapter(this, products)

        val productsListView = onAddProductLayout.findViewById<ListView>(R.id.currentOrdersListView)
        productsListView.adapter = productsAdapter

        val addProductButton = onAddProductLayout.findViewById<ImageButton>(R.id.addProduct)
        addProductButton.setOnClickListener({
            val givenProductInfo = givenProductName.text.toString()
            var validInput = true
            try {
                productId = givenProductInfo.toInt()
            } catch (e: Exception) {
                validInput = false
                Toast.makeText(this, "Type only numbers", Toast.LENGTH_SHORT).show()
            }
            if(validInput) {
                products.add(productsMap[productId]!!)
                productsAdapter.notifyDataSetChanged()
            }
        })

        //setting up layout to GUI
        onAddProductGUI.setView(onAddProductLayout)

        onAddProductGUI.setNegativeButton("Cancel", {dialogInterface, _ ->
            dialogInterface.dismiss()
        })

        onAddProductGUI.setPositiveButton("Ok", {dialogInterface, _ ->
            //TODO ADD GIVEN PRODUCTS
            dialogInterface.dismiss()
        })

        onAddProductGUI.show()
    }

    private fun checkTableHandler() {
        Toast.makeText(this, "check", Toast.LENGTH_SHORT).show()
    }
}
