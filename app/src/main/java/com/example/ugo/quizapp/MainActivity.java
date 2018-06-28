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

    //This method displays the score summary when submit button is clicked.
    public void displayTotalScore(View view) {
        EditText name = (EditText) findViewById(R.id.candidate_name) ;
        String candidate = name.getText().toString();
        CheckBox firstFour = (CheckBox) findViewById(R.id.answer_no4a);
        boolean answer4A = firstFour.isChecked();
        CheckBox secondFour = (CheckBox) findViewById(R.id.answer_no4b);
        boolean answer4B = secondFour.isChecked();
        int score = scoreSummary(answer4A, answer4B);



        Toast.makeText(this, "Hi " + candidate + ". Your total score is " + score , Toast.LENGTH_SHORT).show();
    }

    public void firstOne(){
        EditText answerOne = (EditText) findViewById(R.id.candidate_name) ;
        String questionOne = answerOne.getText().toString();
        String keyWords[] = new String[4];
        keyWords[0] = "temporary endeavor";
        keyWords[1] = "tools";
        keyWords[2] = "techniques";
        keyWords[3] = "unique";
    }



    //this method adds up scores from multichoice, edittext filed and single choice questions
    int scoreSummary(boolean fourA, boolean fourB){
        int multScore = 0;

        if (fourA & fourB){multScore = 20;}
        else{multScore = 0;}

        return totalScore + singleScore2 + singleScore3 + singleScore5 + multScore;
    }

    public void checkAnswer2(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        singleScore2 = 0;


        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.wrong_no2a:
                if (checked) singleScore2 = initialScore + 0;
            break;
            case R.id.answer_no2:
                if (checked) singleScore2 = initialScore + 20;
            break;
            case R.id.wrong_no2b:
                if (checked) singleScore2 = initialScore + 0;
            break;
            case R.id.wrong_no2c:
                if (checked) singleScore2 = initialScore + 0;
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
    //This method resets the app.
    public void resetScores(View view) {

        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.question_2);
        radioGroup2.clearCheck();
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.question_3);
        radioGroup3.clearCheck();
        RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.question_5);
        radioGroup5.clearCheck();


    }
}



