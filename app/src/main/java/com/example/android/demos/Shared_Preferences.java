package com.example.android.demos;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Shared_Preferences extends AppCompatActivity {
    EditText Name;
    Button copy, past,delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        Name=(EditText)findViewById(R.id.editText);
        copy=(Button)findViewById(R.id.copy);
        past=(Button)findViewById(R.id.past);
        delete=(Button)findViewById(R.id.delete);




    }
    public void copy (View view){
        SharedPreferences sharedPreferences = getSharedPreferences("NAME",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("name", Name.getText().toString());
        editor.commit();



    }
    public void past(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("NAME",MODE_PRIVATE);
        Name.setText(sharedPreferences.getString("name","").toString());
    }
    public void delete (View view){
        Name.setText("");
    }
}
