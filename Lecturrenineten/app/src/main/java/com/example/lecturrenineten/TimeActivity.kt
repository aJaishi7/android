package com.example.lecturrenineten

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import java.util.*

class TimeActivity : AppCompatActivity() {
    private lateinit var btnLoadTime: Button;
    private lateinit var textView: TextView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        btnLoadTime = findViewById(R.id.btnLoadTime);
        textView = findViewById(R.id.textView);

        btnLoadTime.setOnClickListener {
            loadTimePicker();
        }
    }

    fun loadTimePicker() {
        val timePicker = TimePickerDialog(
            this,
            { view, hourOfDay, minute -> textView.text = "The time is: ${hourOfDay} : ${minute}" },
            Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
            Calendar.getInstance().get(Calendar.MINUTE),
            false

        );
        timePicker.show();
    }

    fun timeHour() {



    }

}