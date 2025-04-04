package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText weightInput, heightInput;
    private Button calculateButton;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightInput = findViewById(R.id.weightInput);
        heightInput = findViewById(R.id.heightInput);
        calculateButton = findViewById(R.id.calculateButton);
        resultText = findViewById(R.id.resultText);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    // Public method for testing
    public String calculateBMIForTest(Float weight, Float height) {
        if (weight == null || height == null) {
            return "Please enter both weight and height.";
        }
        
        if (weight <= 0 || height <= 0) {
            return "Values must be greater than zero.";
        }
        if (weight > 500) {
            return "Weight must be less than 500kg.";
        }
        if (height > 300) {
            return "Height must be less than 300cm.";
        }

        height = height / 100; // Convert cm to meters
        float bmi = weight / (height * height);
        String category = getBMICategory(bmi);

        return "BMI: " + String.format("%.2f", bmi) + "\nCategory: " + category;
    }

    private void calculateBMI() {
        String weightStr = weightInput.getText().toString();
        String heightStr = heightInput.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            resultText.setText("Please enter both weight and height.");
            return;
        }

        try {
            float weight = Float.parseFloat(weightStr);
            float height = Float.parseFloat(heightStr);

            if (weight <= 0 || height <= 0) {
                resultText.setText("Values must be greater than zero.");
                return;
            }
            if (weight > 500) {
                resultText.setText("Weight must be less than 500kg.");
                return;
            }
            if (height > 300) {
                resultText.setText("Height must be less than 300cm.");
                return;
            }

            height = height / 100; // Convert cm to meters
            float bmi = weight / (height * height);
            String category = getBMICategory(bmi);

            resultText.setText("BMI: " + String.format("%.2f", bmi) + "\nCategory: " + category);
        } catch (NumberFormatException e) {
            resultText.setText("Please enter valid numbers.");
        }
    }

    private String getBMICategory(float bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal weight";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }
}
