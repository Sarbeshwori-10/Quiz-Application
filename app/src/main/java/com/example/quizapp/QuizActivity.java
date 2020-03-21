package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class QuizActivity extends AppCompatActivity {
    private Button submitButton;
    private int score;
    private RadioGroup numOneRadionGroup;
    private RadioGroup numTwoRadionGroup;
    private RadioGroup numFiveRadionGroup;
    private EditText editText;
    private CheckBox mobileCheckbox;
    private CheckBox laptopCheckbox;
    private CheckBox gasCheckbox;
    private CheckBox fanCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        submitButton = findViewById(R.id.submit);
        editText = findViewById(R.id.edit_text);
        mobileCheckbox = findViewById(R.id.mobile_checkbox);
        laptopCheckbox = findViewById(R.id.laptop_checkbox);
        gasCheckbox = findViewById(R.id.gas_checkbox);
        fanCheckbox = findViewById(R.id.fan_checkbox);
        numOneRadionGroup = findViewById(R.id.num_one_radio_group);
        numTwoRadionGroup = findViewById(R.id.num_two_radio_group);
        numFiveRadionGroup = findViewById(R.id.num_five_radio_group);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = 0;

                if(numOneRadionGroup.getCheckedRadioButtonId() == R.id.sahara_radio){
                    score += 1;
                }

                if(numTwoRadionGroup.getCheckedRadioButtonId() == R.id.russia_radio){
                    score += 1;
                }

                if(numFiveRadionGroup.getCheckedRadioButtonId() == R.id.insects_radio){
                    score += 1;
                }

                String userAnswer = editText.getText().toString();
                if(userAnswer.equalsIgnoreCase("48")){
                    score += 1;
                }

                if(mobileCheckbox.isChecked() && laptopCheckbox.isChecked() && !gasCheckbox.isChecked()
                        && !fanCheckbox.isChecked()){
                    score += 1;
                }

                Intent intent = new Intent(QuizActivity.this, ScoreActivity.class);
                intent.putExtra("SCORE", score+"/5");
                startActivity(intent);

            }
        });
    }
}
