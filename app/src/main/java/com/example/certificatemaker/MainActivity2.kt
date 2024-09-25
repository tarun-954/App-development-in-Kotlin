package com.example.certificatemaker

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize ListView and Spinner
        val listView: ListView = findViewById(R.id.listView)
        val spinner: Spinner = findViewById(R.id.spinner)

        // Sample data for ListView and Spinner
        val listItems = arrayOf("Item 1", "Item 2", "Item 3", "Item 4")
        val spinnerItems = arrayOf("palampur", "kangra", "delhi")

        // Set up the ArrayAdapter for the ListView
        val listAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = listAdapter

        // Set up the ArrayAdapter for the Spinner
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerItems)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter

        // Handle ListView item clicks
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = listItems[position]
            Toast.makeText(this, "Clicked: $selectedItem", Toast.LENGTH_SHORT).show()
        }

        // Handle Spinner item selection
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                val selectedOption = spinnerItems[position]
                Toast.makeText(this@MainActivity2, "Selected: $selectedOption", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
                // Do nothing
            }
        }
    }
}
