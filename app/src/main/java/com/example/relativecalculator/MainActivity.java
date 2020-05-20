package com.example.relativecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private TextView resultField;
    private String result = "";

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init(){
        resultField = findViewById(R.id.textField);
        resultField.setText("0");

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

        oneBtn.setOnClickListener(myButtonClickListener);
        twoBtn.setOnClickListener(myButtonClickListener);
        threeBtn.setOnClickListener(myButtonClickListener);
        fourBtn.setOnClickListener(myButtonClickListener);
        fiveBtn.setOnClickListener(myButtonClickListener);
        sixBtn.setOnClickListener(myButtonClickListener);
        sevenBtn.setOnClickListener(myButtonClickListener);
        eightBtn.setOnClickListener(myButtonClickListener);
        nineBtn.setOnClickListener(myButtonClickListener);
        zeroBtn.setOnClickListener(myButtonClickListener);
        dotBtn.setOnClickListener(myButtonClickListener);
        resetBtn.setOnClickListener(myButtonClickListener);
    }



    View.OnClickListener myButtonClickListener = new View.OnClickListener() {
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
                    result = zeroBtn.getText().toString();
                    resultField.setText(result);
                    break;

            }
        }
    };

    private void clearResult(){
        if (resultField.getText().toString().trim().equals("0")){
            result = "";
        }
    }
}