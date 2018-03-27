package com.thoughtworks;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class CalculatorTest {
    Calculator calculator;
    @Before
    public void setUp(){
        calculator=new Calculator();
    }

    @Test
    public void add() {
        assertThat(calculator.add(10,20),is(30.0));
    }

    @Test
    public void subtract() {
        assertThat(calculator.subtract(10,20),is(-10.0));
    }

    @Test
    public void multiply() {
        assertThat(calculator.multiply(10,20),is(200.0));
    }

    @Test
    public void divide() throws DivideByZeroException {
        assertThat(calculator.divide(10,20),is(0.5));
    }

    @Test(expected = DivideByZeroException.class)
    public void checkDivideByZero() throws DivideByZeroException {
        calculator.divide(10,0);
    }

    @Test
    public void modulus() {
        assertThat(calculator.add(10,20),is(10));
    }
}