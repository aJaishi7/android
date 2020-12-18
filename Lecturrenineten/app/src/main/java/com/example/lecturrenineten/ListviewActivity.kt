package com.example.lecturrenineten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class ListviewActivity : AppCompatActivity() {

    private lateinit var lstCountries: ListView;

    val lstCountry =
        arrayOf<String>("Nepal", "India", "China", "Bhutan", "Pakistan", "Bangladesh", "Bhutan");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listview)
        lstCountries = findViewById(R.id.lstCountries);

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstCountry);
        lstCountries.adapter = adapter;

        lstCountries.setOnItemClickListener { parent, view, position, id ->

            val country = parent?.getItemAtPosition(position).toString();
            Toast.makeText(this, "Welcome to ${country}", Toast.LENGTH_LONG).show();
        }
    }
}