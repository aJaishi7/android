package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isInvisible
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //Declaring views
    private lateinit var btnFirst: Button;
    private lateinit var btnSecond: Button;
    private lateinit var tvIncorrect: TextView;
    private lateinit var tvCorrect: TextView;
    private lateinit var tvRes: TextView;
    private lateinit var btnReset: Button;
    private lateinit var btnRestart: Button;

    //Global Variables
    var count: Int = 0;
    var incorrect: Int = 0;
    var correct: Int = 0;

    //Runs on app startup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        //Binding Values
        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        tvIncorrect = findViewById(R.id.tvInCorrect);
        tvCorrect = findViewById(R.id.tvCorrect);
        tvRes = findViewById(R.id.tvRes);
        btnReset = findViewById(R.id.btnReset);


        //Initial Random Numbers in Buttons
        getSuffled();
        checkResult();
        hideRes();


        //EventListeners for Button Click
        btnFirst.setOnClickListener(this);
        btnSecond.setOnClickListener(this);
        btnReset.setOnClickListener(this);


    }

    //Generates random Numbers from..to
    private fun getRandom(from: Int, to: Int): Int {
        require(from <= to) { "Illegal Value Supplied" };
        val rand = Random(System.nanoTime());
        return (from..to).random(rand);
    }

    //Overriding setOnClickListener : Interface is used to do so.
    override fun onClick(v: View) {

        if (btnFirst.text.toString() != btnSecond.text.toString()) {
            when (v.id) {
                R.id.btnFirst -> {
                    btnFirst.text = getRandom(1, 100).toString();
                    checkGreatest();
                }

                R.id.btnSecond -> {
                    btnSecond.text = getRandom(1, 100).toString();
                    checkGreatest();
                }
                R.id.btnReset -> {
                    Reset();

                }
            }
        } else {
            getSuffled();
        }

        countPlus();


//        tvRes.text = i.toString();
    }

    private fun countPlus(): Int {

        if (btnFirst.isPressed || btnSecond.isPressed) {
            count++;
            if (count >= 10) {
                btnFirst.isEnabled = false;
                btnSecond.isEnabled = false;
                checkResult();
            }
        }
        return count;
    }

    //To heck Greatest number between two numbers
    private fun checkGreatest() {

        if (btnFirst.text.toString() > btnSecond.text.toString() && btnSecond.text.toString() > btnFirst.text.toString()) {
            correct++;
            tvCorrect.text = "Correct: " + correct.toString();
        } else {
            incorrect++;
            tvIncorrect.text = "Incorrect: " + incorrect.toString();
        }
    }


    //Reset all views to default
    private fun Reset() {
        getSuffled();
        count = 0;
        correct = 0;
        incorrect = 0;
        tvRes.visibility = View.INVISIBLE;
        tvCorrect.text = "";
        tvIncorrect.text = "";
        btnFirst.isEnabled = true;
        btnSecond.isEnabled = true;
    }

    //Generte random numbers using function getRandom()
    private fun getSuffled() {
        btnFirst.text = getRandom(1, 100).toString();
        btnSecond.text = getRandom(1, 100).toString();
    }

    private fun checkResult() {

        if (correct > incorrect) {
            tvRes.text = "You Won";
            showRes();
        } else if (correct < incorrect) {
            tvRes.text = "You Lose";
            showRes();
        } else if(correct==incorrect) {
            tvRes.text = "Match Draw";
            showRes();
        }

    }

    private fun showRes(){
        tvRes.visibility=View.VISIBLE;

    }
    private fun hideRes(){
        tvRes.visibility=View.INVISIBLE;

    }
}