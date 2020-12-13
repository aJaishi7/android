package com.example.myapplication

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.util.*

class DateActivity : AppCompatActivity() {
    private lateinit var tvDate: TextView;
    private lateinit var btnLoad: Button;

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)
        tvDate = findViewById(R.id.tvDate);
        btnLoad = findViewById(R.id.btnLoad);

        btnLoad.setOnClickListener {
            loadCalander();
        }

    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun loadCalander() {
        var calendar = Calendar.getInstance();
        var day: Int = calendar.get(Calendar.DAY_OF_MONTH);
        var month: Int = calendar.get(Calendar.MONTH);
        var year: Int = calendar.get(Calendar.YEAR);


        val datePickerDialog = DatePickerDialog(
            this,
            { view, year, month, dayOfMonth -> tvDate.text = "Date: $day/$month/$year" },
            year,
            month,
            day
        );
        datePickerDialog.show();


    }

}