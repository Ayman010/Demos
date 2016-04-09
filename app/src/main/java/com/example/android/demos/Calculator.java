package com.example.android.demos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    EditText t1,t2;
    TextView v1,v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        t1=(EditText)findViewById(R.id.num1);
        t2=(EditText)findViewById(R.id.num2);
        v1=(TextView)findViewById(R.id.sign);
        v2=(TextView)findViewById(R.id.View0);
    }
    public void onClick(View view){
        float number1,number2;
        float result=0;
        if (TextUtils.isEmpty(t1.getText().toString())|| TextUtils.isEmpty(t2.getText().toString())){
            return;
        }
        number1=Float.parseFloat(t1.getText().toString());
        number2=Float.parseFloat(t2.getText().toString());
        switch (view.getId()){
            case R.id.on1:
                result=number1+number2;
                v1.setText("+");
                break;
            case R.id.on2:
                result=number1-number2;
                v1.setText("-");
                break;
            case R.id.on3:
                result=number1/number2;
                v1.setText("/");
                break;
            case R.id.on4:
                result=number1*number2;
                v1.setText("*");
                break;
            case R.id.on5:
                t1.setText("");
                t2.setText("");
                v1.setText(".");
                break;

        }
        v2.setText(""+result+"");
    }

}
