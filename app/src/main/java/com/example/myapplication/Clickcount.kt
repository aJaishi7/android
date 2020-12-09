package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isInvisible
import org.w3c.dom.Text

class Clickcount : AppCompatActivity() {

    private lateinit var btnClick: Button;
    private lateinit var tvCount: TextView;
    private lateinit var btnReset: Button;
    private lateinit var tvHidden: TextView;

    var count: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clickcount)

        btnClick = findViewById(R.id.btnClick);
        tvCount = findViewById(R.id.tvCount);
        btnReset = findViewById(R.id.btnReset);
        tvHidden = findViewById(R.id.tvHidden);


        tvHidden.isInvisible = true;
        btnClick.setOnClickListener {
            count++;
            tvCount.text = count.toString();
            if (count >= 10) {
                tvHidden.isInvisible = false;
            }


        }
        btnReset.setOnClickListener {
            tvCount.text = "0";
            count = 0;
            tvHidden.visibility = View.INVISIBLE;
        }


    }
}