package com.example.calculatebmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // We declare the variables on top of the class so they can be used in a classes
    // class variables also are called 'fields'
    private TextView textViewResult;
    private Button buttonCalculate;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private EditText editTextAge;
    private EditText editTextFeet;
    private EditText editTextInches;
    private EditText editTextWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setupButtonClickListener();
    }

    private void findViews() {
        textViewResult = findViewById(R.id.text_view_result);
        radioButtonMale = findViewById(R.id.radio_button_male);
        radioButtonFemale = findViewById(R.id.radio_button_female);
        editTextAge = findViewById(R.id.edit_text_age);
        editTextFeet = findViewById(R.id.edit_text_feet);
        editTextInches = findViewById(R.id.edit_text_inches);
        editTextWeight = findViewById(R.id.edit_text_weight);
        buttonCalculate = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bmiResult = calculateBmi();

                String ageText = editTextAge.getText().toString();
                int age = Integer.parseInt(ageText);

                if (age >= 18) {
                    displayResult(bmiResult);
                } else {
                    displayGuidance(bmiResult);
                }
            }
        });
    }

    private double calculateBmi() {
        String feetText = editTextFeet.getText().toString();
        String inchesText = editTextInches.getText().toString();
        String weightText = editTextWeight.getText().toString();

        // converting the number 'Strings' into 'int' variables
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);

        // converting feet to inches and adding all together to get a total of inches
        int totalInches = (feet * 12) + inches;

        // heightInMeters is the inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;

        // BMI formula = weight in kg divided by height in meters squared
        // double bmi = weight / (heightInMeters * heightInMeters);

        // We must convert the double into string for our TextView
        // String bmiTextResult = String.valueOf(bmi);
        return weight / (heightInMeters * heightInMeters);

    }
    private void displayResult(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (bmi < 18.5) {
            // Display underweight
            fullResultString = bmiTextResult + " - You are underweight!";
        } else if (bmi > 25) {
            // Display overweight
            fullResultString = bmiTextResult + " - You are overweight!";
        } else {
            // Display healthy
            fullResultString = bmiTextResult + " - You are healthy!!!";
        }
        textViewResult.setText(fullResultString);
    }
    private void displayGuidance(double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResultString;
        if (radioButtonMale.isChecked()) {
            // Display boy guidance
            fullResultString = bmiTextResult + " -  As you are under 18, please consult" +
                    " with your doctor for the healthy range for boys";
        } else if (radioButtonFemale.isChecked()) {
            // Display girl guidance
            fullResultString = bmiTextResult + " -  As you are under 18, please consult" +
                    " with your doctor for the healthy range for girls";
        } else {
            // Display general guidance
            fullResultString = bmiTextResult + " -  As you are under 18, please consult" +
                    " with your doctor for the healhy range";

        }
        textViewResult.setText(fullResultString);
    }
}