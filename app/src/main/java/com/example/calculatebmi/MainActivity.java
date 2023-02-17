package com.example.calculatebmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewResult = findViewById(R.id.text_view_result);

        RadioButton radioButtonMale = findViewById(R.id.radio_button_male);
        RadioButton radioButtonFemale = findViewById(R.id.radio_button_female);

        EditText editTextAge = findViewById(R.id.edit_text_age);
        EditText editTextFeet = findViewById(R.id.edit_text_feet);
        EditText editTextInches = findViewById(R.id.edit_text_inches);
        EditText editTextWeight = findViewById(R.id.edit_text_weight);

        Button buttonCalculate = findViewById(R.id.button_calculate);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "WOW!!!!!!!", Toast.LENGTH_LONG).show();
            }
        });

    }
}