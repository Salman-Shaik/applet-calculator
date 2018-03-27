package com.thoughtworks;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class AppletCalculator extends Applet implements ActionListener{
    private Button plus,minus,multiply,divide,equals,clearAll,dot,clearChar,modulus;
    private TextField display;
    private Calculator calculator;
    public AppletCalculator() throws HeadlessException {
        this.plus = new Button("+");
        this.minus = new Button("-");
        this.multiply = new Button("X");
        this.divide = new Button("/");
        this.equals = new Button("=");
        this.clearAll=new Button("AC");
        this.dot=new Button(".");
        this.clearChar=new Button("CLEAR");
        this.modulus=new Button("%");
        calculator = new Calculator();
    }

    @Override
    public void init() {
        display=new TextField(10);
        add(display);add(clearAll);add(clearChar);add(modulus);
        Button button=null;
        for (int i=0;i<10;i++){
            button=new Button(""+(9-i));
            add(button);
            button.addActionListener(this);
        }
        add(plus);add(minus);add(multiply);add(divide);add(equals);add(dot);
        addListenersToOperators();
        setVisible(true);
        setLayout(new GridLayout(4,3));
    }

    private void addListenersToOperators() {
        plus.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        equals.addActionListener(this);
        clearAll.addActionListener(this);
        dot.addActionListener(this);
        clearChar.addActionListener(this);
        modulus.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonText=e.getActionCommand();
        if(buttonText.equals("=")){
            try { enableDot();displayResult(); }
            catch (DivideByZeroException e1) { e1.printStackTrace(); }
            return;
        }
        if(buttonText.equals("AC")) { clearText();return; }
        if(buttonText.equals("CLEAR")){clearLastChar();return;}
        String displayString=display.getText()+buttonText;
        display.setText(displayString);
        if (buttonText.equals(".")) disableDot();
        if(buttonText.equals("+")||buttonText.equals("-")||buttonText.equals("X")||buttonText.equals("/"))
            enableDot();
    }

    private void clearLastChar() {
        String displayText = display.getText();
        Character lastChar =displayText.charAt(displayText.length()-1);
        display.setText(displayText.replace(""+lastChar,""));
    }

    private void disableDot() {
        dot.setEnabled(false);
    }

    private void clearText() {
        display.setText("");
        enableDot();
    }


    private void displayResult() throws DivideByZeroException {
        String displayString=display.getText();
        if(displayString.contains("+")) display.setText(""+getResult(displayString,"+"));
        if(displayString.contains("-")) display.setText(""+getResult(displayString,"-"));
        if(displayString.contains("X")) display.setText(""+getResult(displayString,"X"));
        if(displayString.contains("/")) display.setText(""+getResult(displayString,"/"));
        if(displayString.contains("%")) display.setText(""+getResult(displayString,"%"));
    }

    private void enableDot() {
        dot.setEnabled(true);
    }

    private double getResult(String displayString, String symbol) throws DivideByZeroException {
        Double firstOperhand,secondOperhand;
        firstOperhand=Double.parseDouble(displayString.split(symbol)[0]);
        secondOperhand=Double.parseDouble(displayString.split(symbol)[1]);
        if(symbol.equals("+")) return calculator.add(firstOperhand,secondOperhand);
        if(symbol.equals("-")) return calculator.subtract(firstOperhand,secondOperhand);
        if(symbol.equals("X")) return calculator.multiply(firstOperhand,secondOperhand);
        if(symbol.equals("/")) return calculator.divide(firstOperhand,secondOperhand);
        if(symbol.equals("%")) return calculator.modulus(firstOperhand,secondOperhand);
        return 0.0;
    }
    /*
<applet code=”AppletCalculator.class” width=600 height=600>
</applet>
*/
}
