package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import org.w3c.dom.Text

class Radioaction : AppCompatActivity() {
    private lateinit var rdoMale: RadioButton;
    private lateinit var rdoFemale: RadioButton;
    private lateinit var tvGender: TextView;
    private  lateinit var imgGender:ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radioaction)

        rdoFemale = findViewById(R.id.rdoFemale);
        rdoMale = findViewById(R.id.rdoMale);
        tvGender = findViewById(R.id.tvGender);
        imgGender = findViewById(R.id.imgGender);
    }

    fun clickRadioEvent(view: View) {

        when (view.id) {
            R.id.rdoFemale -> {
                tvGender.text = rdoFemale.text.toString();
               imgGender.setImageResource(R.drawable.female);
            }
            R.id.rdoMale -> {
                tvGender.text = rdoMale.text.toString();
                imgGender.setImageResource(R.drawable.male)
            }
        }
    }
}