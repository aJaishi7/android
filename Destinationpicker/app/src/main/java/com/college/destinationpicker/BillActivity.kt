package com.college.destinationpicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.TextView

class BillActivity : AppCompatActivity() {
    private lateinit var tvTotalDays: TextView;
    private lateinit var tvAdultAmount: TextView;
    private lateinit var tvChildrenAmount: TextView;
    private lateinit var tvTotal: TextView;
    private lateinit var tvTaxAmount: TextView;
    private lateinit var tvGrandTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        supportActionBar?.hide();
        setContentView(R.layout.activity_bill);

        //Binding Values
        tvTotalDays = findViewById(R.id.tvTotalDays);
        tvAdultAmount = findViewById(R.id.tvAdultAmount);
        tvChildrenAmount = findViewById(R.id.tvChildrenAmount);
        tvTotal = findViewById(R.id.tvTotal);
        tvTaxAmount = findViewById(R.id.tvTaxAmount);
        tvGrandTotal = findViewById(R.id.tvGrandTotal);


        //Receving Values from another activity.
        val intent: Intent = intent;
        if (intent.extras != null) {
            val adults = intent.getStringExtra("noOfAdults").toString();
            val children = intent.getStringExtra("noOfChildren").toString();
            val location = intent.getStringExtra("location")
            val price = intent.getStringExtra("price").toString();
            val diff = intent.getStringExtra("dateDiff");

            val adultAmt = adults.toFloat() * price.toFloat() * diff.toString().toInt();
            val childrenAmt =
                children.toFloat() * (price.toFloat() / 2).toFloat() * diff.toString().toInt();
            val total = adultAmt + childrenAmt;
//
            val taxAmt = 0.13 * total;
            val grandTotal = taxAmt + total;

            tvTotalDays.text = "Total Holidays Spent: " + diff.toString() + " Days";
            tvAdultAmount.text = "Total Amount of Adults: " + adultAmt.toString()
            tvChildrenAmount.text = "Totat Amount of Childrens:" + childrenAmt.toString();
            tvTotal.text = "Total Amount: " + total.toString();
            tvTaxAmount.text = "Tax (13%): " + taxAmt.toString();
            tvGrandTotal.text = "Grand Total: " + grandTotal.toString();


        } else {

            tvTotal.text = "";

        }
    }
}


