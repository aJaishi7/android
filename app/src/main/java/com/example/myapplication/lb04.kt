package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class lb04 : AppCompatActivity() {
    private lateinit var etEmpName: EditText;
    private lateinit var spinnerDepartmant: Spinner;
    private lateinit var autoAddress: AutoCompleteTextView;
    private lateinit var etJoinedDate: EditText;
    private lateinit var btnSubmit: Button;
    private lateinit var tvResult: TextView;

    val department = arrayListOf<String>(
        "IT", "Logistics", "HR", "Markeeting", "Finance"
    );

    val address = arrayListOf<String>(
        "Lainchwor",
        "Chabahil",
        "Maitidevi",
        "Lazimpath",
        "Koteshwor",
        "Kalanki",
        "Mulpani",
        "Lalitpur"
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lb04)

        etEmpName = findViewById(R.id.etEmpName);
        spinnerDepartmant = findViewById(R.id.spinnerDepartment);
        autoAddress = findViewById(R.id.autoAddress);
        etJoinedDate = findViewById(R.id.etJoinedDate);
        btnSubmit = findViewById(R.id.btnSubmit);
        tvResult = findViewById(R.id.tvResult);

        etJoinedDate.setOnClickListener {
            loadDatePicker();
        }
        spinnerDepartmant.setOnClickListener {
            loadSpinner();
        }



        btnSubmit.setOnClickListener {
            tvResult.text =
                etEmpName.text.toString() + spinnerDepartmant + autoAddress.text.toString() + etJoinedDate.text.toString();
        }

    }

    fun loadSpinner(): String {

        var dept: String = "";
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, department);
        spinnerDepartmant.adapter = adapter;

        spinnerDepartmant.onItemSelectedListener =
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
                    val department = parent?.getItemAtPosition(position).toString();
                    dept = department;
                }
            }
        return dept;

    }

    fun loadAddress() {
        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, address);
        autoAddress.setAdapter(adapter);
        autoAddress.threshold = 1;

        autoAddress.onItemClickListener =
            object : AdapterView.OnItemClickListener {
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val address = parent?.getItemAtPosition(position).toString();
                    autoAddress.setText(address);
                }
            }
    }

    fun loadDatePicker() {

        val datPickerDialog = DatePickerDialog(
            this,
            { view: DatePicker?, year: Int, month: Int, dayOfMonth: Int ->
                etJoinedDate.setText("${year} / ${month + 1} / ${dayOfMonth}");
            },
            Calendar.getInstance().get(Calendar.YEAR),
            Calendar.getInstance().get(Calendar.MONTH),
            Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        )
        datPickerDialog.show();
    }
}
