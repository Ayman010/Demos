package com.example.android.demos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OpenFile extends AppCompatActivity {
    TextView textView;
    StringBuilder stringBuilder;
    InputStream inputStream;
    BufferedReader bufferedReader;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_file);
        try {
            result ="";
            stringBuilder =new StringBuilder();
            inputStream=this.getAssets().open("Ayman.txt");
            bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"UTF8"));
            if (inputStream!=null){
                while ((result=bufferedReader.readLine())!=null){
                    stringBuilder.append(result+"\n");
                }
            }
            textView=(TextView)findViewById(R.id.openFile);
            textView.setText(stringBuilder);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
