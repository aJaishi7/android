package com.example.lecturrenineten

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class DashboardActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnCountries: Button;
    private lateinit var btnListView: Button;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        btnCountries = findViewById(R.id.btnCountries);
        btnListView = findViewById(R.id.btnListView);

        btnListView.setOnClickListener(this);
        btnCountries.setOnClickListener(this);
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btnListView -> {
                startActivity(Intent(this, ListviewActivity::class.java));
            }
            R.id.btnCountries -> {
                startActivity(Intent(this, CountryActivity::class.java));
            }

        }

    }


}