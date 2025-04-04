package com.example.bmi_calculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class MainActivityTest {
    private final MainActivity activity = new MainActivity();

    @Test
    public void testValidInputs() {
        String result = activity.calculateBMIForTest(70f, 175f);
        assertTrue(result.contains("BMI: 22.86"));
        assertTrue(result.contains("Normal weight"));
    }

    @Test
    public void testEmptyWeight() {
        String result = activity.calculateBMIForTest(null, 175f);
        assertEquals("Please enter both weight and height.", result);
    }

    @Test
    public void testEmptyHeight() {
        String result = activity.calculateBMIForTest(70f, null);
        assertEquals("Please enter both weight and height.", result);
    }

    @Test
    public void testZeroValues() {
        String result = activity.calculateBMIForTest(0f, 0f);
        assertEquals("Values must be greater than zero.", result);
    }

    @Test
    public void testNegativeValues() {
        String result = activity.calculateBMIForTest(-70f, -175f);
        assertEquals("Values must be greater than zero.", result);
    }

    @Test
    public void testExtremeWeight() {
        String result = activity.calculateBMIForTest(501f, 175f);
        assertEquals("Weight must be less than 500kg.", result);
    }

    @Test
    public void testExtremeHeight() {
        String result = activity.calculateBMIForTest(70f, 301f);
        assertEquals("Height must be less than 300cm.", result);
    }
}
