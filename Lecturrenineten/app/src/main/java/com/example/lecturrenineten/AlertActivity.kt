package com.example.lecturrenineten

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AlertActivity : AppCompatActivity() {

    private lateinit var btnCalculate: Button;
    private lateinit var etFirst: EditText;
    private lateinit var etSecond: EditText;
    private lateinit var tvResult: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)
        btnCalculate = findViewById(R.id.btnCalculate);
        etFirst = findViewById(R.id.etFirst);
        etSecond = findViewById(R.id.etSecond);

        btnCalculate.setOnClickListener {
            loadAlert();
            val sum = etFirst.text.toString().toInt() + etSecond.text.toString().toInt();

        }
    }


    private fun loadAlert() {

        val alertBuilder = AlertDialog.Builder(this);
        alertBuilder.setTitle("Applicatio Alert");
        alertBuilder.setMessage("Do you want to add?");
        alertBuilder.setIcon(android.R.drawable.ic_dialog_alert);

        alertBuilder.setPositiveButton("Yes") { dialog, which ->
            Toast.makeText(
                this
                , "Yes Clicked", Toast.LENGTH_LONG
            ).show()
        }



        alertBuilder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(
                this
                , "No Clicked", Toast.LENGTH_LONG
            ).show()
        }

        alertBuilder.setNeutralButton("Cancel") { dialog, which ->
            Toast.makeText(
                this
                , "Cancle Clicked", Toast.LENGTH_LONG
            ).show()
        }

        val alertDialog: AlertDialog = alertBuilder.create();
        alertDialog.setCancelable(true);
        alertDialog.show();
    }
}