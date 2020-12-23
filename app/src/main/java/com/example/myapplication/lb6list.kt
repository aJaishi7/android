package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class lb6list : AppCompatActivity() {

    private lateinit var listView:ListView;
    private lateinit var data : ArrayList<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lb6list)
        listView = findViewById(R.id.listView);

        val intent: Intent = intent;
        if (intent.extras != null) {
            data = intent.getSerializableExtra("data") as ArrayList<Person>;
            listView.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,data);
        }

    }
}