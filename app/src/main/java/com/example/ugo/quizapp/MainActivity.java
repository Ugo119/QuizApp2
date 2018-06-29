package com.example.ugo.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    int initialScore = 0;
    int totalScore = 0;
    int singleScore2;
    int singleScore3;
    int singleScore5;
    int sentScore;
    String questionOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //This method displays the score summary using Toast when submit button is clicked.
    public void displayTotalScore(View view) {
        EditText name = (EditText) findViewById(R.id.candidate_name) ;
        String candidate = name.getText().toString();
        CheckBox firstFour = (CheckBox) findViewById(R.id.answer_no4a);
        boolean answer4A = firstFour.isChecked();
        CheckBox secondFour = (CheckBox) findViewById(R.id.answer_no4b);
        boolean answer4B = secondFour.isChecked();
        int score = scoreSummary(answer4A, answer4B) + firstOne();
        Toast.makeText(this, "Hi " + candidate + ". Your total score is " + score , Toast.LENGTH_SHORT).show();
    }
    // This method extracts keywords from the EditText view and adds the corresponding score to total.
     int firstOne() {
    EditText answerOne = (EditText) findViewById(R.id.quest1);
    //String keyWords[] = {"temporary endeavor", "tools", "techniques", "unique"};
        questionOne  = answerOne.getText().toString();
           if (!questionOne.equals("")) {
             if (questionOne.toLowerCase().equals("temporary endeavor")) sentScore = 20;
             else sentScore = 0;
    }
           return sentScore;
    }
    //this method adds up scores from multichoice and single choice questions
    int scoreSummary(boolean fourA, boolean fourB){
         int multScore = 0;
         if (fourA & fourB){multScore = 20;}
         else{multScore = 0;}
         return totalScore + singleScore2 + singleScore3 + singleScore5 + multScore;
    }
   //This method checks for the correct RadioButton clicked and adds the corresponding score.
    public void checkAnswer2(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        singleScore2 = 0;
        // Check if correct RadioButton was clicked and add score
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
// Check if correct RadioButton was clicked and add score
            switch(view.getId()) {
              case R.id.answer_no3:
                  if (checked3) singleScore3 = initialScore + 20;
              break;
              case R.id.wrong_no3a:
                   if (checked3) singleScore3 = initialScore + 0;
               break;
               case R.id.wrong_no3b:
                    if (checked3) singleScore3 = initialScore + 0;
                    break;
               case R.id.wrong_no3c:
                    if (checked3) singleScore3 = initialScore + 0;
                break;
            }
        }
     public void checkAnswer5(View view){
             boolean checked3 = ((RadioButton) view).isChecked();
             singleScore5 = 0;
      // Check if correct RadioButton was clicked and add score
             switch(view.getId()) {
                 case R.id.wrong_no5a:
                      if (checked3) singleScore5 = initialScore + 0;
                 break;
                 case R.id.wrong_no5b:
                      if (checked3) singleScore5 = initialScore + 0;
                  break;
                  case R.id.answer_no5:
                      if (checked3) singleScore5 = initialScore + 20;
                   break;
                   case R.id.wrong_no5c:
                       if (checked3) singleScore5 = initialScore + 0;
                    break;
        }
    }
    //This method resets the app.
     public void resetScores(View view) {
          EditText name = (EditText) findViewById(R.id.candidate_name) ;
          name.setText(" ");
          EditText answerOne = (EditText) findViewById(R.id.quest1) ;
          answerOne.setText(" ");
          RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.question_2);
          radioGroup2.clearCheck();
          RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.question_3);
          radioGroup3.clearCheck();
          RadioGroup radioGroup5 = (RadioGroup) findViewById(R.id.question_5);
          radioGroup5.clearCheck();
          CheckBox firstFour = (CheckBox) findViewById(R.id.answer_no4a);
          firstFour.setChecked(false);
          CheckBox secondFour = (CheckBox) findViewById(R.id.answer_no4b);
          secondFour.setChecked(false);
    }
}



