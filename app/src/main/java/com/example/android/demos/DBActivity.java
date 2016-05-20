package com.example.android.demos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DBActivity extends AppCompatActivity {
    EditText userName2,password2,email2,firstName2,LastName2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db);
        userName2=(EditText)findViewById(R.id.firstName2);
        password2=(EditText)findViewById(R.id.password2);
        email2=(EditText)findViewById(R.id.email2);
        firstName2=(EditText)findViewById(R.id.firstName2);
        LastName2=(EditText)findViewById(R.id.lastName2);
    }
    public void back (View view){
        Intent intent=new Intent(this,InternalStorage.class);
        startActivity(intent);
    }
    public void returnData(View view) throws IOException {
        try {
            int read=-1;
            StringBuffer buffer=new StringBuffer();
            FileInputStream fileInputStream=openFileInput("data.txt");
            while ((read=fileInputStream.read())!=-1){
                buffer.append((char) read);
                            }
            Log.d(buffer.toString(),"data.txt");
            String m=buffer.toString();
            String[]x=m.split(" ");
            String userName5=x[0];
            String password5=x[1];
            String email5=x[2];
            String firstName5=x[3];
            String LastName5=x[4];
            userName2.setText(userName5);
            password2.setText(password5);
            email2.setText(email5);
            firstName2.setText(firstName5);
            LastName2.setText(LastName5);



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
