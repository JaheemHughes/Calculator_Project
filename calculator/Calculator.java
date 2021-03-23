package edu.ysu.jehughes.calculator;

public class Calculator {
    private static final String INITIAL_VALUE = "0";

    private String input;
    private String previousInput;
    private Operator operator;
    private boolean clearInput;
    private boolean hasDecimal;

    public Calculator () {
        this.input = INITIAL_VALUE;
        this.clearInput = false;
        this.previousInput = INITIAL_VALUE;
        this.operator = Operator.None;
        this.hasDecimal = false;
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
        if (this.operator != Operator.None){
            this.calcTotal();
            this.clearInput = true;
        }
        this.operator = operator;
        this.clearInput = true;
    }
    
    private void calcTotal (){

        Double valueOne = Double.parseDouble(previousInput);
        Double valueTwo = Double.parseDouble(input);
        Double total = 0.0;
        switch(this.operator){
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
                hasDecimal = true;
                break;
            case None:
                total = valueTwo;
                break;

        }
        if(!hasDecimal){
            double doubleTotal = (double)total;
            int intTotal = (int)doubleTotal;
            Integer holder = Integer.valueOf(intTotal);
            input = holder.toString();
        } else {
            input = total.toString();
        }
    }

    public void equals(){
        if (previousInput.equals(INITIAL_VALUE)){
            previousInput = input;
            calcTotal();
        } else {
            calcTotal();
            operator = Operator.None;
        }
        //this.clearInput = true;
    }

    public void signSwitch() {
        if (hasDecimal) {
            Double holder = Double.parseDouble(input);
            holder *= -1;
            input = holder.toString();
        } else {
            Integer holder = Integer.valueOf(input);
            holder *= -1;
            input = holder.toString();
        }
    }

    public void clear() {
        input = INITIAL_VALUE;
        previousInput = INITIAL_VALUE;
        operator = Operator.None;
        this.clearInput = true;
        this.hasDecimal = false;
    }

    public void decimal(){
       if(!hasDecimal) {
           input += ".";
           hasDecimal = true;
       }
    }

    public void percent() {
        Double holder = Double.parseDouble(input);
        holder /= 100;
        input = holder.toString();
        hasDecimal = true;


    }

}
