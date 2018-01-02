package com.abuarquemf.tablemanager.activities

import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.Toast
import com.abuarquemf.tablemanager.R
import com.abuarquemf.tablemanager.adapters.TableAdapter
import com.abuarquemf.tablemanager.entities.Table
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        val TABLE_PASS = "-505"
    }

    //TODO HANDLE STATE KEEP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tables = ArrayList<Table>()

        val tablesAdapter = TableAdapter(this, tables)

        tablesList.adapter = tablesAdapter

        tablesList.setOnItemClickListener { parent, view, position, id ->
            val table = tablesList.adapter.getItem(position) as Table
            val tableDescribeActivity = Intent(this, TableDescriptionActivity::class.java)
            tableDescribeActivity.putExtra(TABLE_PASS, table)
            startActivity(tableDescribeActivity)
        }

        addTable.setOnClickListener({
            val addTableAlert = AlertDialog.Builder(this)
            addTableAlert.setTitle("Add Table")
            addTableAlert.setIcon(R.drawable.ic_add_table)

            val onAddingTableGUI = LayoutInflater.from(this).inflate(R.layout.on_adding_table, null)
            val idInputEdit = onAddingTableGUI.findViewById<EditText>(R.id.tableIdEditText)

            addTableAlert.setView(onAddingTableGUI)

            addTableAlert.setNegativeButton("Cancel",  { dialogInterface, _ ->
                dialogInterface.dismiss()
            })

            addTableAlert.setPositiveButton("Add", {dialogInterface, _ ->
                val givenTableId = idInputEdit.text.toString()
                var validInput = true
                var tableId: Int = -505
                try {
                    tableId = givenTableId.toInt()
                } catch (e: Exception) {
                    Toast.makeText(this, "Type only numbers", Toast.LENGTH_SHORT).show()
                    validInput = false
                }

                if(validInput) {
                    tables.add(Table(tableId))
                    tablesAdapter.notifyDataSetChanged()
                }
                dialogInterface.dismiss()
            })

            addTableAlert.show()

        })
    }
}
