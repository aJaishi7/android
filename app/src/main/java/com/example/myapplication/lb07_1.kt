package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class lb07_1 : AppCompatActivity() {

    private lateinit var etName: EditText;
    private lateinit var etAddress: EditText;
    private lateinit var etPhone: EditText;
    private lateinit var rdoGender: RadioGroup;
    private lateinit var rdoMale: RadioButton;
    private lateinit var rdoFemale: RadioButton;
    private lateinit var btnSubmit: Button;
    var genderSelected: String = "";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_07_1)

        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etPhone = findViewById(R.id.etPhone);
        rdoFemale = findViewById(R.id.rdoFemale);
        rdoMale = findViewById(R.id.rdoMale);
        rdoGender = findViewById(R.id.rdoGender);
        btnSubmit = findViewById(R.id.btnSubmit);


        onRadioChecked();
        btnSubmit.setOnClickListener {
            val person =
                lb07Person(
                    etName.text.toString(),
                    etAddress.text.toString(),
                    etPhone.text.toString(),
                    genderSelected
                );

            var intent: Intent = intent;
            intent.putExtra("data", person);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }

    }

    private fun onRadioChecked() {
        rdoGender.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rdoMale -> {
                        genderSelected = rdoMale.text.toString();
                    }
                    R.id.rdoFemale -> {
                        genderSelected = rdoFemale.text.toString();
                    }
                }
            }

        })
    }
}