package edu.ysu.jehughes.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private final Calculator calculator;

    public MainActivity(){
        super();
        calculator = new Calculator();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = this.findViewById(R.id.numberDisplay);

        Button zeroButton = this.findViewById(R.id.zeroButton);
        zeroButton.setOnClickListener(view -> {
            handleInput(0);
        });
        Button oneButton = this.findViewById(R.id.oneButton);
        oneButton.setOnClickListener(view -> {
            handleInput(1);
        });
        Button twoButton = this.findViewById(R.id.twoButton);
        twoButton.setOnClickListener(view -> {
            handleInput(2);
        });
        Button threeButton = this.findViewById(R.id.threeButton);
        threeButton.setOnClickListener(view -> {
            handleInput(3);
        });
        Button fourButton = this.findViewById(R.id.fourButton);
        fourButton.setOnClickListener(view -> {
            handleInput(4);
        });
        Button fiveButton = this.findViewById(R.id.fiveButton);
        fiveButton.setOnClickListener(view ->{handleInput(5); });

        Button sixButton = this.findViewById(R.id.sixButton);
        sixButton.setOnClickListener(view ->{handleInput(6); });

        Button sevenButton = this.findViewById(R.id.sevenButton);
        sevenButton.setOnClickListener(view ->{handleInput(7); });

        Button eightButton = this.findViewById(R.id.eightButton);
        eightButton.setOnClickListener(view ->{handleInput(8); });

        Button nineButton = this.findViewById(R.id.nineButton);
        nineButton.setOnClickListener(view ->{handleInput(9); });

        Button addButton = this.findViewById(R.id.addButton);
        addButton.setOnClickListener(view ->{handleOperator(Operator.Add); });

        Button subtractButton = this.findViewById(R.id.subtractButton);
        subtractButton.setOnClickListener(view ->{handleOperator(Operator.Subtract); });

        Button multiplyButton = this.findViewById(R.id.multiplyButton);
        multiplyButton.setOnClickListener(view -> {
            handleOperator(Operator.Multiply);
        });

        Button divideButton = this.findViewById(R.id.divideButton);
        divideButton.setOnClickListener(view ->{handleOperator(Operator.Divide); });

        Button equalButton = this.findViewById(R.id.equalsButton);
        equalButton.setOnClickListener(view ->{
            calculator.equals();
            display.setText(calculator.getInput());
        });

        Button signButton = this.findViewById(R.id.signButton);
        signButton.setOnClickListener(view ->{
            calculator.signSwitch();
            display.setText(calculator.getInput());
        });

        Button clearButton = this.findViewById(R.id.clearButton);
        clearButton.setOnClickListener(view ->{
            calculator.clear();
            display.setText(calculator.getInput());
        });

        Button decimalButton = this.findViewById(R.id.decimalButton);
        decimalButton.setOnClickListener(view -> {
            calculator.decimal();
            display.setText(calculator.getInput());
        });

        Button percentButton = this.findViewById(R.id.percentSymbol);
        percentButton.setOnClickListener(view ->{
            calculator.percent();
            display.setText(calculator.getInput());
        });
    }

    public void handleInput(Integer number) {
        calculator.inputNum(number);
        display.setText(calculator.getInput());
    }

    public void handleOperator(Operator operator){
        calculator.inputOpr(operator);
        display.setText(calculator.getInput());
    }
}