package com.example.lecturrenineten

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class AutocompleteActivity : AppCompatActivity() {

    private lateinit var autoComplete: AutoCompleteTextView;

    private val arrayLanguage = arrayOf(
        "English", "Hindi", "Nepali", "Chinese", "Newari", "Dutch"
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_autocomplete)

        autoComplete = findViewById(R.id.autoComplete);
        val autoLanguageAdapter = ArrayAdapter(
            this, android.R.layout.simple_dropdown_item_1line, arrayLanguage
        )
        autoComplete.setAdapter(autoLanguageAdapter);
        autoComplete.threshold = 1;

    }
}