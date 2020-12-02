package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnFirst: Button;
    private lateinit var btnSecond: Button;
    private lateinit var tvIncorrect: TextView;
    private lateinit var tvCorrect: TextView;
    private lateinit var tvRes: TextView;
    private lateinit var btnReset: Button;

    var count: Int = 0;// Why this works on global variable only?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        tvIncorrect = findViewById(R.id.tvInCorrect);
        tvCorrect = findViewById(R.id.tvCorrect);
        tvRes = findViewById(R.id.tvRes);
        btnReset = findViewById(R.id.btnReset);

        btnFirst.text = getRandom(1, 100).toString();
        btnSecond.text = getRandom(1, 100).toString();

        btnFirst.setOnClickListener(this);
        btnSecond.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }

    override fun onClick(v: View) {


        when (v.id) {

            R.id.btnFirst -> {
                btnFirst.text = getRandom(1, 100).toString();
                checkValues();
            }
            R.id.btnSecond -> {
                btnSecond.text = getRandom(1, 100).toString();
                checkValues();
            }
            R.id.btnReset -> {
                Reset();
            }

        }
    }


    private fun getRandom(from: Int, to: Int): Int {
        require(from <= to) { "Illegal Value Supplied" };
        val rand = Random(System.nanoTime());
        return (from..to).random(rand);

    }

    private fun Reset() {

        btnFirst.text = "";
        btnSecond.text = "";
    }

    private fun checkValues() {


        if (btnFirst.text.toString() > btnSecond.text.toString()) {
            count++;
            tvCorrect.text = count.toString();

        } else if (btnFirst.text.toString() < btnSecond.text.toString()) {
            count--;
            tvIncorrect.text = count.toString();
        }

    }


}