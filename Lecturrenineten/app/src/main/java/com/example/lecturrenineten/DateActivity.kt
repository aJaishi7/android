package com.example.lecturrenineten

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.util.*

class DateActivity : AppCompatActivity() {
    private lateinit var btnShowDialog: Button;
    private lateinit var tvShowDate: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date)

        btnShowDialog = findViewById(R.id.btnShowDialog);
        tvShowDate = findViewById(R.id.tvShowDate);

        btnShowDialog.setOnClickListener {
            loadDatePicker();
        }
    }

    fun loadDatePicker() {

        val datePicker = DatePickerDialog(
            this,
            { view, year, month, dayOfMonth -> tvShowDate.text = "$year-${month + 1}-$dayOfMonth" },

            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datePicker.show();
    }

}