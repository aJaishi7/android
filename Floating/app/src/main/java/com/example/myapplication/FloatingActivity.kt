package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FloatingActivity : AppCompatActivity() {

    private lateinit var floatingButton: FloatingActionButton;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_floating)
        Toast.makeText(this, "I'm Floating Action Button", Toast.LENGTH_LONG).show();


        floatingButton = findViewById(R.id.floatingButton);
        floatingButton.setOnClickListener {
            Log.d("Floating Activity","Button ONClick")
            Toast.makeText(this, "I'm Floating Action Button", Toast.LENGTH_LONG).show();
        }
    }


}