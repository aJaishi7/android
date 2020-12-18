package com.example.lecturrenineten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CapitalActivity : AppCompatActivity() {

    private lateinit var tvCapital: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_capital)
        tvCapital = findViewById(R.id.tvCapital);

        val intent = intent;
        if (intent.extras != null) {
            val country = intent.getStringExtra("Country");
            val capital = intent.getStringExtra("Capital");
            tvCapital.text = "${country} = $capital";
        } else {
            tvCapital.text = "No country Selected"
        }
    }
}