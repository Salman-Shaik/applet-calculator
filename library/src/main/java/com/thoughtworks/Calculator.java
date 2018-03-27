package com.thoughtworks;

public class Calculator {
    public double add(double firstOperhand, double secondOperhand) {
        return firstOperhand+secondOperhand;
    }

    public double subtract(double firstOperhand, double secondOperhand) {
        return firstOperhand-secondOperhand;
    }

    public double multiply(double firstOperhand, double secondOperhand) {
        return firstOperhand*secondOperhand;
    }

    public double divide(double firstOperhand, double secondOperhand) throws DivideByZeroException {
        if(secondOperhand==0) throw new DivideByZeroException();
        return firstOperhand/secondOperhand;
    }
}
