package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup


class lb06 : AppCompatActivity() {

    private lateinit var gender: String
    private lateinit var etFullName: EditText;
    private lateinit var etAddress: EditText;
    private lateinit var etMobile: EditText;
    private lateinit var rdoMale: RadioButton;
    private lateinit var rdoFemale: RadioButton;
    private lateinit var rdoGender: RadioGroup;
    private lateinit var btnSubmit: Button;
    var personArray = arrayListOf<Person>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lb06);

        etFullName = findViewById(R.id.etFullName);
        etAddress = findViewById(R.id.etAddress);
        etMobile = findViewById(R.id.etMobile);
        rdoGender = findViewById(R.id.rdoGender);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        btnSubmit = findViewById(R.id.btnSubmit);


        genderLoad();





        btnSubmit.setOnClickListener {

            var fullName: String = etFullName.text.toString();
            var address: String = etAddress.text.toString();
            var etMobile: String = etMobile.text.toString();

            var p = Person(fullName, address, etMobile, gender);

            personArray.add(p)

            startActivity(
                Intent(this@lb06, lb6list::class.java)
                    .putExtra("data", personArray)
            );

        }
    }

    fun genderLoad() {
        rdoGender.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rdoFemale -> {
                        gender = rdoFemale.text.toString();
                    }
                    R.id.rdoMale -> {
                        gender = rdoMale.text.toString();
                    }
                }
            }

        });
    }
}