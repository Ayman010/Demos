package com.example.android.demos;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SqliteDataBase extends AppCompatActivity {
    DB dataBAse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_data_base);
        dataBAse=new DB(this);
        SQLiteDatabase sqLiteDatabase=dataBAse.getWritableDatabase();
    }



}
