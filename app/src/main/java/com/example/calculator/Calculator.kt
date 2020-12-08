package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.badge.BadgeUtils

class Calculator : AppCompatActivity() {

    //Declaring Primitive Properties of Class
    var isNewOp: Boolean = true;
    var oldNumber: String = "";
    var op: String = "";

    //Declaring Complex Properties of Class
    private lateinit var tvResult: TextView;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        tvResult = findViewById(R.id.tbResult);
    }

    //Function for Number Click
    fun numberEvent(view: View) {
        if (isNewOp)
            tvResult.setText("");
        isNewOp = false;

        var buttonClick: String = tvResult.text.toString(); // stores values displays in TextView
        var btnView = view as Button; // fetch id from views

        when (btnView.id) {

            R.id.btnZero -> {
                buttonClick += "0"
            }
            R.id.btnOne -> {
                buttonClick += "1"; }
            R.id.btnTwo -> {
                buttonClick += "2";
            }
            R.id.btnThree -> {
                buttonClick += "3"
            }
            R.id.btnFour -> {
                buttonClick += "4"; }
            R.id.btnFive -> {
                buttonClick += "5";
            }
            R.id.btnSix -> {
                buttonClick += "6"
            }
            R.id.btnSeven -> {
                buttonClick += "7";
            }
            R.id.btnEight -> {
                buttonClick += "8";
            }
            R.id.btnNine -> {
                buttonClick += "9";
            }
            R.id.btnDot -> {
                buttonClick += "."
            }
            R.id.btnPlusMinus -> {
                buttonClick = "-" + buttonClick;
            }
        }
        tvResult.setText(buttonClick);

    }


    //Function For Operations
    fun optEvent(view: View) {

        isNewOp = true;
        oldNumber = tvResult.text.toString();
        var opt = view as Button;

        when (opt.id) {

            R.id.btnPlus -> {
                op = "+";
            }
            R.id.btnMinus -> {
                op = "-";
            }
            R.id.btnMultiply -> {
                op = "x";
            }
            R.id.btnDivide -> {
                op = "÷";
            }

        }
        tvResult.setText(op);

    }


    fun equalEvent(view: View) {


        var newNumber: String = tvResult.text.toString();
        var res: Double = 0.0;

        when (op) {
            "+" -> {
                res = oldNumber.toDouble() + newNumber.toDouble();
            }
            "-" -> {
                res = oldNumber.toDouble() - newNumber.toDouble();
            }
            "x" -> {
                res = oldNumber.toDouble() * newNumber.toDouble();
            }
            "÷" -> {
                res = oldNumber.toDouble() / newNumber.toDouble();
            }
            "%" -> {
                res = ((oldNumber.toDouble() + newNumber.toDouble())) / 100;
            }
        }
        tvResult.setText(res.toString());
    }

    fun optPercentage(view: View) {
        tvResult.text = (tvResult.text.toString().toDouble() / 100).toString();
        isNewOp = true;
    }

    fun clearEvent(view: View) {
        tvResult.setText("0");
        isNewOp = true;

    }


}
