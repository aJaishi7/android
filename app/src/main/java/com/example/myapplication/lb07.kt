package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class lb07 : AppCompatActivity() {

    private lateinit var lstPerson: ListView;
    private lateinit var btnGoTo: Button;
    val listOfPerson = arrayListOf<lb07Person>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lb07)
        lstPerson = findViewById(R.id.lstPerson);
        btnGoTo = findViewById(R.id.btnGoTo);

        btnGoTo.setOnClickListener {
            startActivityForResult(Intent(this, lb07_1::class.java), 1);
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val values = data?.getSerializableExtra("data") as lb07Person;
                listOfPerson.add(values);

                lstPerson.adapter =
                    ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfPerson);

            }
        }
    }
}