package com.example.android.demos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
كود لعمل شاشة تظهر عند فتح التطبيق لأول مرة
        if (isFirstRun) {
            startActivity(new Intent(this, First.class));
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();*/
    }
    public void shared (View view){
        Intent shared = new Intent(this,Shared_Preferences.class);
        startActivity(shared);


    }
    public void changeTextSize (View view){
        Intent change =new Intent(this,ChangeTextSizeBySeekBar.class);
        startActivity(change);
    }
    public void calculator (View view){
        Intent calculate =new Intent(this,Calculator.class);
        startActivity(calculate);
    }
    public void openFile (View view){
        Intent open =new Intent(this,OpenFile.class);
        startActivity(open);
    }
}
