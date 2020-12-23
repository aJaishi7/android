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
    var location: String = "";
    var price: Float = 0F;

    var d1: String = String();
    var d2: String = String();


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_destinationpicker)

        spinnerDestination = findViewById(R.id.spinnerDestination);
        etCheckInDate = findViewById(R.id.etCheckinDate);
        etCheckOutDate = findViewById(R.id.etCheckoutDate);
        etNoOfAdults = findViewById(R.id.etNoOfAdults);
        etNoOfChildren = findViewById(R.id.etNoOfChildren);
        btnBook = findViewById(R.id.btnBook);

        mapOfLocations["Pokhara"] = 10000F;
        mapOfLocations["Lumbini"] = 12000F;
        mapOfLocations["Chitlang"] = 8000F;
        mapOfLocations["Gorkha"] = 9000F;
        mapOfLocations["Manakamana"] = 6000F;
        mapOfLocations["Kathmandu"] = 16000F;
        mapOfLocations["Mustang"] = 13000F;
        mapOfLocations["Manang"] = 11500F;



        spinnerDestination.adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_dropdown_item_1line,
            mapOfLocations.keys.toTypedArray()
        );

        spinnerDestination.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    location = parent?.getItemAtPosition(position).toString();
                    price = mapOfLocations[location].toString().toFloat();
                }

            }


        etCheckInDate.setOnClickListener {
            loadDatePicker(etCheckInDate);
        }
        etCheckOutDate.setOnClickListener {
            loadDatePicker(etCheckOutDate);
        }

        btnBook.setOnClickListener(View.OnClickListener {

            val diff = d2.toString().toInt() - d1.toString().toInt();
            val intent: Intent = Intent(this, BillActivity::class.java);
            intent.putExtra("noOfAdults", etNoOfAdults.text.toString());
            intent.putExtra("noOfChildren", etNoOfChildren.text.toString());
            intent.putExtra("location", location);
            intent.putExtra("price", price.toString());
            intent.putExtra("dateDiff", diff.toString());
            startActivity(intent);


        });

    }


    fun loadDatePicker(view: View) {

        when (view?.id) {
            R.id.etCheckinDate -> {
                DatePickerDialog(
                    this,
                    { _, year, month, dayOfMonth ->
                        etCheckInDate.setText("$year - ${month + 1} - $dayOfMonth")
                        d1 = dayOfMonth.toString();
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
                        d2 = dayOfMonth.toString();
                    },
                    Calendar.getInstance().get(Calendar.YEAR),
                    Calendar.getInstance().get(Calendar.MONTH),
                    Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
                ).show();
            }
        }
    }

}