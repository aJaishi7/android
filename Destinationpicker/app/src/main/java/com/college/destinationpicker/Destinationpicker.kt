package com.college.destinationpicker

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.*
import java.util.*

class Destinationpicker : AppCompatActivity() {

    private lateinit var spinnerDestination: Spinner;
    private lateinit var etCheckInDate: EditText;
    private lateinit var etCheckOutDate: EditText;
    private lateinit var etNoOfAdults: EditText;
    private lateinit var etNoOfChildren: EditText
    private lateinit var btnBook: Button;

    val mapOfLocations = mutableMapOf<String, Float>();

//    var amtPerAdult: Float = 5000F;
//    var amtPerChild: Float = 5000F;
//    var dateDifference: Int = 0;
//    var totalAdultAmount: Float = 0F;
//    var totalChildrenAmount: Float = 0F;
//    var total: Float = 0F;
//    var taxable: Float = 0F;
//    var grandTotal: Float = 0F;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_destinationpicker)

        mapOfLocations["Pokhara"] = 10000F;
        mapOfLocations["Lumbini"] = 12000F;
        mapOfLocations["Chitlang"] = 8000F;
        mapOfLocations["Gorkha"] = 9000F;
        mapOfLocations["Manakamana"] = 6000F;
        mapOfLocations["Kathmandu"] = 16000F;
        mapOfLocations["Mustang"] = 13000F;
        mapOfLocations["Manang"] = 11500F;

        spinnerDestination = findViewById(R.id.spinnerDestination);
        etCheckInDate = findViewById(R.id.etCheckinDate);
        etCheckOutDate = findViewById(R.id.etCheckoutDate);
        etNoOfAdults = findViewById(R.id.etNoOfAdults);
        etNoOfChildren = findViewById(R.id.etNoOfChildren);
        btnBook = findViewById(R.id.btnBook);

        loadSpinner();
        etCheckInDate.setOnClickListener {
            loadDatePicker(etCheckInDate);
            etCheckInDate.isFocusable = false;
        }
        etCheckOutDate.setOnClickListener {
            loadDatePicker(etCheckOutDate);
        }

//        var taxAmt: Float = 0.13F;
//        dateDifference = etCheckInDate.text.toString().toInt() - etCheckOutDate.text.toString().toInt();
//        totalAdultAmount = etNoOfAdults.text.toString().toFloat() * 5000;
//        totalChildrenAmount = (etNoOfChildren.text.toString().toFloat() * 5000) / 2; //50% disount given to childrens
//        total = totalAdultAmount + totalChildrenAmount;
//        taxable = (total * taxAmt) - total;
//        grandTotal = total + taxable;

        loadSpinner();


    }

    fun loadSpinner() {

        spinnerDestination.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line,
            mapOfLocations.keys.toTypedArray()
        );

//        spinnerDestination.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//                TODO("Not yet implemented")
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                val location = parent?.getItemAtPosition(position).toString();
//                val price = mapOfLocations[location]!!;
//
//                var intent: Intent = Intent(this@Destinationpicker, BillActivity::class.java);
//                intent.putExtra("location", location);
//                intent.putExtra("price", price);
//                startActivity(intent);
//
//
//            }
//
//        }


    }


    fun loadDatePicker(view: View) {


        when (view?.id) {
            R.id.etCheckinDate -> {
                DatePickerDialog(
                    this,
                    { _, year, month, dayOfMonth ->
                        etCheckInDate.setText("$year - ${month + 1} - $dayOfMonth")
                    },
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                ).show();
            }
            R.id.etCheckoutDate -> {
                DatePickerDialog(
                    this,
                    { _, year, month, dayOfMonth ->
                        etCheckOutDate.setText("$year - ${month + 1} - $dayOfMonth")
                    },
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        }
    }
}