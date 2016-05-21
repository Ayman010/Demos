package com.example.android.demos;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DB extends SQLiteOpenHelper {
    private static final String dataBase_Name="DataBaseName";
    private static final String dataBAseTable="DataBAseTable";
    private static final int dataBase_version=2;
    private static final String UID="id";
    private static final String names="name";
    private static final String email="Email";
    private static final String Drop_Table="Drop TAble is exist"+dataBAseTable;
    private static final String CREATE_TABLE="CREATE TABLE "+dataBAseTable+
            " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+names+" VARCHAR(255), "+email+" VARCHAR(255));";
    private Context context;





    public DB(Context context    ) {
        super(context, dataBase_Name, null, dataBase_version);
        this.context=context;
        Toast.makeText(context,"this is constructor",Toast.LENGTH_LONG).show();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"this is onCreate Method",Toast.LENGTH_LONG).show();
        }catch (SQLException e){
            Toast.makeText(context,"due to : "+e,Toast.LENGTH_LONG).show();

        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try{
            Toast.makeText(context,"this is onUpgrade Method",Toast.LENGTH_LONG).show();

            db.execSQL(Drop_Table);
            onCreate(db);
        }catch (SQLException e){
            Toast.makeText(context,"du to: "+e,Toast.LENGTH_LONG).show();

        }

    }


}

