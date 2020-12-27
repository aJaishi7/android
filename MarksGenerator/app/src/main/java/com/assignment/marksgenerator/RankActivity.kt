package com.assignment.marksgenerator

import Student
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RankActivity : AppCompatActivity() {

    private lateinit var tvFirstRank: TextView;
    private lateinit var tvSecondRank: TextView;
    private lateinit var tvThirdRank: TextView;
    private lateinit var tvAndroidFirst: TextView;
    private lateinit var tvAndroidSecond: TextView;
    private lateinit var tvAndroidThird: TextView;
//    var studentArrayList = arrayListOf<Student>();

    var obj: ArrayList<Student> = arrayListOf<Student>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)

        tvFirstRank = findViewById(R.id.tvFirstRank);
        tvSecondRank = findViewById(R.id.tvSecondRank);
        tvThirdRank = findViewById(R.id.tvThirdRank);
        tvAndroidFirst = findViewById(R.id.tvAndroidFirst);
        tvAndroidSecond = findViewById(R.id.tvAndroidSecond);
        tvAndroidThird = findViewById(R.id.tvAndroidThird);


        val intent: Intent = intent;
        if (intent.extras != null) {
            val args = intent.getBundleExtra("bundle");
            obj = args?.getSerializable("StudentData") as ArrayList<Student>;


            obj.forEach {
                if (obj.count() >= 3) {

                    val avg0 = obj[0].getAverage();
                    val avg1 = obj[1].getAverage();
                    val avg2 = obj[2].getAverage();

                    //Finding First Student
                    findFirstStudent(avg0 = avg0, avg1 = avg1, avg2 = avg2);

                    //Finding Second Student
                    findSecondStudent(avg0 = avg0, avg1 = avg1, avg2 = avg2);

                    //Finding third student
                    findThirdStudent(avg0 = avg0, avg1 = avg1, avg2 = avg2);

                    //First marks in android
                    androidFirst();

                    //Second Mark in Android
                    androidSecond();

                    //Third Marks in Android
                    androidThird();


                }
            }
        }
    }

    fun findFirstStudent(avg0: Int, avg1: Int, avg2: Int) {
        var first = "";
        if (avg0 > avg1 && avg0 > avg2) {
            first = obj[0].studentName + " " + avg0 + " %";
        } else if (avg1 > avg2 && avg1 > avg0) {
            first = obj[1].studentName + " " + avg1 + " %";
        } else if (avg2 > avg0 && avg2 > avg1) {
            first = obj[2].studentName + " " + avg2 + " %";
        }
        tvFirstRank.text = first.toString();

    }

    fun findSecondStudent(avg0: Int, avg1: Int, avg2: Int) {
        var second = "";
        if (avg0 > avg1 && avg1 > avg2 || avg2 > avg1 && avg1 > avg0) {
            second = obj[1].studentName + " " + avg1 + " %";
        } else if (avg1 > avg0 && avg0 > avg2 || avg2 > avg0 && avg0 > avg1) {
            second = obj[0].studentName + " " + avg0 + " %";
        } else if (avg0 > avg2 && avg2 > avg1 || avg1 > avg2 && avg2 > avg0) {
            second = obj[2].studentName + " " + avg2 + " %";
        }
        tvSecondRank.text = second.toString();

    }

    fun findThirdStudent(avg0: Int, avg1: Int, avg2: Int) {
        var third = "";
        if (avg0 < avg1 && avg0 < avg2) {
            third = obj[0].studentName + " " + avg0 + " %";
        } else if (avg1 < avg2 && avg1 < avg0) {
            third = obj[1].studentName + " " + avg1 + " %";
        } else if (avg2 < avg0 && avg2 < avg1) {
            third = obj[2].studentName + " " + avg2 + " %";
        }
        tvThirdRank.text = third.toString();

    }

    fun androidFirst() {

        var firstAndroid = "";
        if (obj[0].androidMarks > obj[1].androidMarks && obj[0].androidMarks > obj[2].androidMarks) {
            firstAndroid = obj[0].studentName + " " + obj[0].androidMarks;
        } else if (obj[1].androidMarks > obj[2].androidMarks && obj[1].androidMarks > obj[0].androidMarks) {
            firstAndroid = obj[1].studentName + " " + obj[1].androidMarks;
        } else if (obj[2].androidMarks > obj[1].androidMarks && obj[2].androidMarks > obj[0].androidMarks) {
            firstAndroid = obj[2].studentName + " " + obj[2].androidMarks;
        }
        tvAndroidFirst.text = firstAndroid.toString();

    }

    fun androidSecond() {
        var secondAndroid = "";
        if (obj[0].androidMarks > obj[1].androidMarks && obj[1].androidMarks > obj[2].androidMarks || obj[2].androidMarks > obj[1].androidMarks && obj[1].androidMarks > obj[0].androidMarks) {
            secondAndroid = obj[1].studentName + " " + obj[1].androidMarks;
        } else if (obj[1].androidMarks > obj[0].androidMarks && obj[0].androidMarks > obj[2].androidMarks || obj[2].androidMarks > obj[0].androidMarks && obj[0].androidMarks > obj[1].androidMarks) {
            secondAndroid = obj[0].studentName + " " + obj[0].androidMarks;
        } else if (obj[0].androidMarks > obj[2].androidMarks && obj[2].androidMarks > obj[1].androidMarks || obj[1].androidMarks > obj[2].androidMarks && obj[2].androidMarks > obj[0].androidMarks) {
            secondAndroid = obj[2].studentName + " " + obj[2].androidMarks;
        }
        tvAndroidSecond.text = secondAndroid.toString();
    }

    fun androidThird() {

        var thirdAndroid = "";
        if (obj[0].androidMarks < obj[1].androidMarks && obj[0].androidMarks < obj[2].androidMarks) {
            thirdAndroid = obj[0].studentName + " " + obj[0].androidMarks;
        } else if (obj[1].androidMarks < obj[2].androidMarks && obj[1].androidMarks < obj[0].androidMarks) {
            thirdAndroid = obj[1].studentName + " " + obj[1].androidMarks;
        } else if (obj[2].androidMarks < obj[1].androidMarks && obj[2].androidMarks < obj[0].androidMarks) {
            thirdAndroid = obj[2].studentName + " " + obj[2].androidMarks;
        }
        tvAndroidThird.text = thirdAndroid.toString();

    }

}


