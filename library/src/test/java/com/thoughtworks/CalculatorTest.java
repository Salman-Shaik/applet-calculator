package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    Calculator calculator;
    @Before
    public void setUp() throws Exception {
        calculator = new Calculator();
    }

    @Test
    public void checkAddition() {

        assertThat(calculator.add(3,5),is(8.0));
    }

    @Test
    public void checkSubtraction() {
        assertThat(calculator.subtract(10,25),is(-15.0));
    }

    @Test
    public void checkMultiplication() {
        assertThat(calculator.multiply(11,13),is(143.0));
    }

    @Test
    public void checkDivision() throws DivideByZeroException {
        assertThat(calculator.divide(20,20),is(1.0));
    }

    @Test (expected = DivideByZeroException.class)
    public void checkDivideByZeroException() throws DivideByZeroException {
        calculator.divide(200000,0);
    }
}
