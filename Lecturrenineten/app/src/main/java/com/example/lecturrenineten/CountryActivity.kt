package com.example.lecturrenineten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class CountryActivity : AppCompatActivity() {
    private lateinit var listCountry: ListView;

    //    val countries = arrayListOf<String>("Nepal", "India", "China", "Bhutan");
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country)
        listCountry = findViewById(R.id.listCountry);

        val countryCapitalMap = mutableMapOf<String, String>()

        countryCapitalMap["Nepal"] = "Kathmandu";
        countryCapitalMap["India"] = "NewDelhi";
        countryCapitalMap["China"] = "Beijing";

        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            countryCapitalMap.keys.toTypedArray()
        );

        listCountry.adapter = adapter;

        listCountry.setOnItemClickListener { parent, view, position, id ->
            val country = parent?.getItemAtPosition(position).toString();
            val capital = countryCapitalMap[country]!!.toString();

            val intent = Intent(this, CapitalActivity::class.java);
            intent.putExtra("Country", country);
            intent.putExtra("Capital", capital);
            startActivity(intent);
        }
    }
}