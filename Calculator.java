package edu.ysu.jehughes.calculator;

public class Calculator {
    private static final String INITIAL_VALUE = "0";

    private String input;
    private String previousInput;
    private Operator operator;
    private boolean clearInput;

    public Calculator () {
        this.input = "0";
        this.clearInput = false;
        this.previousInput = INITIAL_VALUE;
    }
    public void inputNum(Integer number){
        if(clearInput) {
            previousInput = input;
            input = number.toString();
            clearInput = false;
        } else if(input.equals(INITIAL_VALUE)){
            input = number.toString();
        } else {
            input += number.toString();
        }
    }

    public String getInput(){
        return this.input;
    }

    public void inputOpr(Operator operator){
        if (this.operator != null){
            this.calcTotal();
        }
        this.operator = operator;
        this.clearInput = true;
    }
    private void calcTotal (){
        Double valueOne = Double.parseDouble(previousInput);
        Double valueTwo = Double.parseDouble(input);
        Double total = 0.0;
        switch(operator){
            case Add:
                total = valueOne + valueTwo;
                break;
            case Subtract:
                 total = valueOne - valueTwo;
                break;
            case Multiply:
                total = valueOne * valueTwo;
                break;
            case Divide:
                total = valueOne / valueTwo;
            case Equals:
                break;
        }
        input = total.toString();
    }
}
