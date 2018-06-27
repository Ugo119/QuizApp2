package com.example.ugo.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.text.NumberFormat;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity {
    int initialScore = 0;
    int totalScore = 0;
    int singleScore2;
    int singleScore3;
    int singleScore5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void displayTotalScore(View view) {
        EditText name = (EditText) findViewById(R.id.candidate_name) ;
        String candidate = name.getText().toString();

        Toast.makeText(this, "Hi " + candidate + ". Your total score is " + scoreSummary() , Toast.LENGTH_SHORT).show();
    }

    int scoreSummary(){
        return totalScore + singleScore2 + singleScore3 + singleScore5;
    }

    public void checkAnswer2(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        singleScore2 = 0;


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.wrong_no2a:
                if (checked) singleScore2 = initialScore + 0;
                // Pirates are the best
                break;
            case R.id.answer_no2:
                if (checked) singleScore2 = initialScore + 20;
                // Ninjas rule
                break;
            case R.id.wrong_no2b:
                if (checked) singleScore2 = initialScore + 0;
                // Pirates are the best
                break;
            case R.id.wrong_no2c:
                if (checked) singleScore2 = initialScore + 0;
                // Pirates are the best
                break;

        }
    }

        public void checkAnswer3(View view){
            boolean checked3 = ((RadioButton) view).isChecked();
            singleScore3 = 0;

            switch(view.getId()) {
                case R.id.answer_no3:
                    if (checked3) singleScore3 = initialScore + 20;
                    // Pirates are the best
                    break;
                case R.id.wrong_no3a:
                    if (checked3) singleScore3 = initialScore + 0;
                    // Ninjas rule
                    break;
                case R.id.wrong_no3b:
                    if (checked3) singleScore3 = initialScore + 0;
                    // Pirates are the best
                    break;
                case R.id.wrong_no3c:
                    if (checked3) singleScore3 = initialScore + 0;
                    // Pirates are the best
                    break;

            }
        }
    public void checkAnswer5(View view){
        boolean checked3 = ((RadioButton) view).isChecked();
        singleScore5 = 0;

        switch(view.getId()) {
            case R.id.wrong_no5a:
                if (checked3) singleScore5 = initialScore + 0;
                // Pirates are the best
                break;
            case R.id.wrong_no5b:
                if (checked3) singleScore5 = initialScore + 0;
                // Ninjas rule
                break;
            case R.id.answer_no5:
                if (checked3) singleScore5 = initialScore + 20;
                // Pirates are the best
                break;
            case R.id.wrong_no5c:
                if (checked3) singleScore5 = initialScore + 0;
                // Pirates are the best
                break;

        }
    }
    }



