package com.example.android.demos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorage extends AppCompatActivity {
    EditText userName,password,email,firstName,LastName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        userName=(EditText)findViewById(R.id.username1);
        password=(EditText)findViewById(R.id.password1);
        email=(EditText)findViewById(R.id.email1);
        firstName=(EditText)findViewById(R.id.firstName1);
        LastName=(EditText)findViewById(R.id.lastName1);

    }
    public void dataBase (View view){
        Toast.makeText(this,"Moved to Data Base",Toast.LENGTH_LONG).show();

        Intent intent= new Intent(this,DBActivity.class);
        startActivity(intent);
    }
    public void saveData (View view){
        String userName4= userName.getText().toString()+" ";
        String password4=password.getText().toString()+" ";
        String email4=email.getText().toString()+" ";
        String firstName4=firstName.getText().toString()+" ";
        String LastName4=LastName.getText().toString()+" ";
        File file=null;
        FileOutputStream fileOutputStream=null;
        try {
            file=getFilesDir();
            fileOutputStream= openFileOutput("data.txt", Context.MODE_PRIVATE);
            fileOutputStream.write(userName4.getBytes());
            fileOutputStream.write(password4.getBytes());
            fileOutputStream.write(email4.getBytes());
            fileOutputStream.write(firstName4.getBytes());
            fileOutputStream.write(LastName4.getBytes());


        } catch (IOException e) {
            Log.d("data.txt",e.toString());
            e.printStackTrace();
        }
        finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }


        Toast.makeText(this,"saved SuccessFully"+file+"/data.txt",Toast.LENGTH_LONG).show();
    }
}
