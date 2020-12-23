package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import org.w3c.dom.Text

class lb05 : AppCompatActivity() {

    private lateinit var layout: LinearLayout
    private lateinit var radioGroup: RadioGroup
    private lateinit var etFullName: EditText;
    private lateinit var etEmail: EditText;
    private lateinit var rdoStudent: RadioButton;
    private lateinit var rdoStaff: RadioButton;
    private lateinit var spinner: Spinner;
    private lateinit var etPassword: EditText;
    private lateinit var etReenterPassword: EditText;
    private lateinit var btnRegister: Button;
    private lateinit var tvSection: TextView;

    val department = arrayListOf<String>(
        "Academic", "Admission", "Logistics", "Front-Desk", "Examination"
    );

    val batch = arrayListOf<String>(
        "24A", "24B", "24C",
        "25A", "25B", "25C"
    );

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lb05)


        etFullName = findViewById(R.id.etFullName);
        etEmail = findViewById(R.id.etEmail);
        rdoStaff = findViewById(R.id.rdoStaff);
        rdoStudent = findViewById(R.id.rdoStudent);
        spinner = findViewById(R.id.spinner);
        etPassword = findViewById(R.id.etPassword);
        etReenterPassword = findViewById(R.id.etReenterPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvSection = findViewById(R.id.tvSection);
        layout = findViewById(R.id.layoutLinear)
        layout.visibility = View.GONE;
        layout.visibility = View.VISIBLE;
        radioGroup = findViewById(R.id.rdoGroup);


        radioGroup.setOnCheckedChangeListener(object : RadioGroup.OnCheckedChangeListener {
            override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
                when (checkedId) {
                    R.id.rdoStaff -> {
                        spinner.adapter = ArrayAdapter<String>(
                            this@lb05,
                            android.R.layout.simple_list_item_1,
                            department
                        );
                        tvSection.text = "Department";
                    }
                    R.id.rdoStudent -> {
                        spinner.adapter =
                            ArrayAdapter(this@lb05, android.R.layout.simple_list_item_1, batch);
                        tvSection.text = "Batch"

                    }
                }
            }
        })

        btnRegister.setOnClickListener(View.OnClickListener {

            loadAlert();

        });

    }


    fun loadAlert() {

        val alertBuilder = AlertDialog.Builder(this);
        alertBuilder.setIcon(android.R.drawable.ic_dialog_alert);
        alertBuilder.setTitle("Information");
        var view: View = layoutInflater.inflate(R.layout.activity_customalert, null);

        var fullName: TextView = view.findViewById(R.id.tv_Fullname);
        fullName.text = ("FullName:");
//
//        var email: TextView = view.findViewById(R.id.tvEmail);
//        email.setText("Email: $etEmail");
//
//        var category: TextView = view.findViewById(R.id.tvCategory);
//        category.setText("Category: $tvSection : $spinner");
//
//        var password: TextView = view.findViewById(R.id.tvPassword);
//        password.setText("Password: $etPassword");

        var button: Button = view.findViewById(R.id.btnDismiss);
        button.setText("Dismiss");

        alertBuilder.setView(view);

        alertBuilder.setPositiveButton("Yes") { dialog, which -> "" };
        alertBuilder.setNegativeButton("No") { dialog, which -> "" };

        val alertDialog: AlertDialog = alertBuilder.create();
        alertDialog.setCancelable(false);
        alertDialog.show();


    }


}