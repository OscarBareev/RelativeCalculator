package com.example.relativecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigDecimal;


public class MainActivity extends AppCompatActivity {

    private TextView resultField;
    private String result = "";
    private String keepNumber = "";


    //number buttons
    private Button oneBtn;
    private Button twoBtn;
    private Button threeBtn;
    private Button fourBtn;
    private Button fiveBtn;
    private Button sixBtn;
    private Button sevenBtn;
    private Button eightBtn;
    private Button nineBtn;
    private Button zeroBtn;
    private Button dotBtn;
    private Button resetBtn;

    //operation buttons
    private Button divideBtn;
    private Button multiplyBtn;
    private Button minusBtn;
    private Button plusBtn;
    private Button resultBtn;
    private Button plusMinusBtn;
    private Button percent;

    //operation booleans
    private boolean isDivide = false;
    private boolean isMultiply = false;
    private boolean isMinus = false;
    private boolean isPlus = false;
    private boolean negativeNmb = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        resultField = findViewById(R.id.textField);
        resultField.setText("0");

        //initialize number buttons
        oneBtn = findViewById(R.id.oneBtn);
        twoBtn = findViewById(R.id.twoBtn);
        threeBtn = findViewById(R.id.threeBtn);
        fourBtn = findViewById(R.id.fourBtn);
        fiveBtn = findViewById(R.id.fiveBtn);
        sixBtn = findViewById(R.id.sixBtn);
        sevenBtn = findViewById(R.id.sevenBtn);
        eightBtn = findViewById(R.id.eightBtn);
        nineBtn = findViewById(R.id.nineBtn);
        zeroBtn = findViewById(R.id.zeroBtn);
        dotBtn = findViewById(R.id.dotBtn);
        resetBtn = findViewById(R.id.resetBtn);

        //initialize operation buttons
        divideBtn = findViewById(R.id.divideBtn);
        multiplyBtn = findViewById(R.id.xBtn);
        minusBtn = findViewById(R.id.minusBtn);
        plusBtn = findViewById(R.id.plusBtn);
        resultBtn = findViewById(R.id.resultBtn);
        plusMinusBtn = findViewById(R.id.plusMinusBtn);
        percent = findViewById(R.id.percentBtn);


        oneBtn.setOnClickListener(numbersClickListener);
        twoBtn.setOnClickListener(numbersClickListener);
        threeBtn.setOnClickListener(numbersClickListener);
        fourBtn.setOnClickListener(numbersClickListener);
        fiveBtn.setOnClickListener(numbersClickListener);
        sixBtn.setOnClickListener(numbersClickListener);
        sevenBtn.setOnClickListener(numbersClickListener);
        eightBtn.setOnClickListener(numbersClickListener);
        nineBtn.setOnClickListener(numbersClickListener);
        zeroBtn.setOnClickListener(numbersClickListener);
        dotBtn.setOnClickListener(numbersClickListener);
        resetBtn.setOnClickListener(numbersClickListener);

        divideBtn.setOnClickListener(operationClickListener);
        multiplyBtn.setOnClickListener(operationClickListener);
        minusBtn.setOnClickListener(operationClickListener);
        plusBtn.setOnClickListener(operationClickListener);
        resultBtn.setOnClickListener(operationClickListener);
        plusMinusBtn.setOnClickListener(operationClickListener);
        percent.setOnClickListener(operationClickListener);
    }


    View.OnClickListener numbersClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.oneBtn:
                    clearResult();
                    result += oneBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.twoBtn:
                    clearResult();
                    result += twoBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.threeBtn:
                    clearResult();
                    result += threeBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.fourBtn:
                    clearResult();
                    result += fourBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.fiveBtn:
                    clearResult();
                    result += fiveBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.sixBtn:
                    clearResult();
                    result += sixBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.sevenBtn:
                    clearResult();
                    result += sevenBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.eightBtn:
                    clearResult();
                    result += eightBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.nineBtn:
                    clearResult();
                    result += nineBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.zeroBtn:
                    clearResult();
                    result += zeroBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.dotBtn:
                    result += dotBtn.getText().toString();
                    resultField.setText(result);
                    break;
                case R.id.resetBtn:
                    isDivide = false;
                    isMultiply = false;
                    isMinus = false;
                    isPlus = false;
                    negativeNmb = false;

                    result = zeroBtn.getText().toString();
                    resultField.setText(result);
                    break;
            }
        }
    };

    View.OnClickListener operationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.divideBtn:
                    makeOperations();
                    keepNumber = result;
                    result = "";
                    isDivide = true;
                    break;
                case R.id.xBtn:
                    makeOperations();
                    keepNumber = result;
                    result = "";
                    isMultiply = true;
                    break;
                case R.id.minusBtn:
                    makeOperations();
                    keepNumber = result;
                    result = "";
                    isMinus = true;
                    break;
                case R.id.plusBtn:
                    makeOperations();
                    keepNumber = result;
                    result = "";
                    isPlus = true;
                    break;
                case R.id.resultBtn:
                    makeOperations();
                    break;
                case R.id.plusMinusBtn:
                    if (!result.trim().equals("0") && !result.trim().equals("")) {
                        if (!negativeNmb) {
                            result = "-" + result;
                            negativeNmb = true;
                            resultField.setText(result);
                        } else {
                            result = result.substring(1);
                            negativeNmb = false;
                            resultField.setText(result);
                        }
                    }

                case R.id.percentBtn:
                    final BigDecimal makePercent = new BigDecimal("0.01");

                    if (result.trim().equals("")) result = "0";

                    if (isMultiply || isDivide) {
                        BigDecimal percentDecimal = new BigDecimal(result);
                        percentDecimal = percentDecimal.multiply(makePercent);
                        result = percentDecimal.toString();
                        resultField.setText(result);
                    }
                    if (isPlus || isMinus) {
                        BigDecimal keepDecimal = new BigDecimal(keepNumber);
                        BigDecimal resultDecimal = new BigDecimal(result);
                        resultDecimal = resultDecimal.multiply(makePercent);
                        result = keepDecimal.multiply(resultDecimal).toString();
                        resultField.setText(result);
                    }
            }
        }
    };

    private void clearResult() {
        if (resultField.getText().toString().trim().equals("0")) {
            result = "";
        }
    }


    private void makeOperations() {
        if (isDivide) {
            isDivide = false;
            BigDecimal keepDecimal = new BigDecimal(keepNumber);
            BigDecimal resultDecimal = new BigDecimal(result);
            keepDecimal = keepDecimal.divide(resultDecimal, 6, BigDecimal.ROUND_HALF_EVEN);
            result = keepDecimal.toString();
            resultField.setText(result);
        }

        if (isMultiply) {
            isMultiply = false;
            BigDecimal keepDecimal = new BigDecimal(keepNumber);
            BigDecimal resultDecimal = new BigDecimal(result);
            keepDecimal = keepDecimal.multiply(resultDecimal);
            result = keepDecimal.toString();
            resultField.setText(result);
        }

        if (isMinus) {
            isMinus = false;
            BigDecimal keepDecimal = new BigDecimal(keepNumber);
            BigDecimal resultDecimal = new BigDecimal(result);
            keepDecimal = keepDecimal.subtract(resultDecimal);
            result = keepDecimal.toString();
            resultField.setText(result);
        }

        if (isPlus) {
            isPlus = false;
            BigDecimal keepDecimal;
            keepDecimal = new BigDecimal(keepNumber);
            BigDecimal resultDecimal = new BigDecimal(result);
            keepDecimal = keepDecimal.add(resultDecimal);
            result = keepDecimal.toString();
            resultField.setText(result);
        }
    }
}
