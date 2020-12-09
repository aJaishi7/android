package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    private lateinit var etUsername: EditText;
    private lateinit var etPassword: EditText;
    private lateinit var btnLogin: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener {
            var uname: String = etUsername.text.toString();
            var password: String = etPassword.text.toString();

            if (uname == "admin" && password == "password") {
                Toast.makeText(this, "Welcome $uname", Toast.LENGTH_LONG).show();
               // clearFields(uname = uname, pass = password);

//                  Moivng from one activity to another using Intent
//                var i = Intent(this, Radioaction::class.java)
//                startActivity(i);
            } else {
                Toast.makeText(this, "No match found", Toast.LENGTH_LONG).show();
                //clearFields(uname = uname, pass = password)

            }
        }
    }

//    private fun clearFields(uname: String, pass: String) {
//        uname.equals(etUsername.text.toString());
//        pass.equals(etPassword.text.toString());
//        uname == "";
//        pass == "";
//    }
}