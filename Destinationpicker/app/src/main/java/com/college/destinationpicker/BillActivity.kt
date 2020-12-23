package com.college.destinationpicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class BillActivity : AppCompatActivity() {
    private lateinit var tvAdult:TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvAdult= findViewById(R.id.tvAdult);


        var intent:Intent = intent;
        if(intent.extras!=null){
            val tvAdults = intent.getStringExtra("noOfAdults");
            tvAdult.text = "Total Adults: $tvAdults";

        }
        else{
            tvAdult.setText("No Values Received")
        }
    }
}