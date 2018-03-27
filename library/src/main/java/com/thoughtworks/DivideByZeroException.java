package com.thoughtworks;

public class DivideByZeroException extends Throwable {
    public DivideByZeroException() {
        super("Number Can't Be Divided By Zero");
    }
}
