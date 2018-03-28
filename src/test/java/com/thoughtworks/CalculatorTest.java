package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator;
    @Before
    public void setUp() {
        calculator=new Calculator();
    }

    @Test
    public void add() {
        assertThat(calculator.add(20,10),is(30.0));
    }

    @Test
    public void subtract() {
        assertThat(calculator.subtract(100,1000),is(-900.0));
    }

    @Test
    public void multiply() {
        assertThat(calculator.multiply(10,10),is(100.0));
    }

    @Test
    public void divide() throws DivideByZeroException {
        assertThat(calculator.divide(10,10),is(1.0));
    }

    @Test(expected = DivideByZeroException.class)
    public void checkDivideByZero() throws DivideByZeroException {
        calculator.divide(10,0);
    }

    @Test
    public void modulus() {
        assertThat(calculator.modulus(22,10),is(2.0));
    }
}