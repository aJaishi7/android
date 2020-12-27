package com.assignment.marksgenerator

import Student
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import java.io.Serializable

class AppActivity : AppCompatActivity() {

    private lateinit var etStudentId: EditText;
    private lateinit var etStudentName: EditText;
    private lateinit var etAndroidMarks: EditText;
    private lateinit var etAPIMarks: EditText;
    private lateinit var etIoTMarks: EditText;
    private lateinit var btnAdd: Button;
    var studentArrayList = arrayListOf<Student>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)
        etStudentId = findViewById(R.id.etStudentId);
        etStudentName = findViewById(R.id.etStudentName);
        etAndroidMarks = findViewById(R.id.etAndroidMarks);
        etAPIMarks = findViewById(R.id.etAPIMarks);
        etIoTMarks = findViewById(R.id.etIoTMarks);
        btnAdd = findViewById(R.id.btnAdd);


        btnAdd.setOnClickListener {

            val student = Student(
                etStudentId.text.toString().toInt(),
                etStudentName.text.toString(),
                etAndroidMarks.text.toString().toInt(),
                etAPIMarks.text.toString().toInt(),
                etIoTMarks.text.toString().toInt()
            );


            //Adding Student To List

            studentArrayList.add(student);
            if (studentArrayList.count() >= 3) {

                //Passing Data to another activity
                var intent = Intent(this, RankActivity::class.java);
                var bundle: Bundle = Bundle();
                bundle.putSerializable("StudentData", studentArrayList);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            } else {
                clearField();
            }


        }

    }

    fun clearField() {
        etStudentId.setText("");
        etStudentName.setText("");
        etIoTMarks.setText("");
        etAndroidMarks.setText("");
        etAPIMarks.setText("");
        etStudentId.requestFocus();
    }


}