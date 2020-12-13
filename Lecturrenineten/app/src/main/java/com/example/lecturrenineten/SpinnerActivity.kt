package com.example.lecturrenineten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner;

    private var arrLanguage = arrayOf(
        "Nepali", "English", "Hindi", "Chinese"
    );

//    private var arrLanguage = arrayListOf<String>(  "Nepali", "English", "Hindi", "Chinese");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)
        spinner = findViewById(R.id.spinner);

        var adapter = ArrayAdapter<String>(
            this@SpinnerActivity, android.R.layout.simple_list_item_1,
            arrLanguage
        );

        //setting adapter to spinner's adapter
        spinner.adapter = adapter;

        //On item selected listener
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem = parent?.getItemAtPosition(position).toString(); // getting selected item.
                val selectedItemId = parent?.getItemIdAtPosition(position).toString();//getting item id at selected position.
                Toast.makeText(
                    this@SpinnerActivity,
                    "Selected Item : $selectedItem",
                    Toast.LENGTH_LONG
                ).show();
            }

        }


    }
}