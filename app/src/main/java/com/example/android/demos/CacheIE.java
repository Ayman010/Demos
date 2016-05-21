package com.example.android.demos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CacheIE extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache_ie);
        editText=(EditText)findViewById(R.id.user1);
    }
    public void saveInternal(View view){
        String name=editText.getText().toString();
        File file=getCacheDir();
        File file1=new File(file,"Ayman.txt");
        dataStore(name, file1);

    }



    public void saveExternal (View view){
        String name=editText.getText().toString();
        File file =getExternalCacheDir();
        File file1=new File(file, "external.txt");
        dataStore(name,file1);

    }

    private void dataStore(String name, File file1) {
        FileOutputStream fileOutputStream= null;
        try {
            fileOutputStream = new FileOutputStream(file1);
            fileOutputStream.write(name.getBytes());
            Toast.makeText(this, "Data Stored successfully ", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
