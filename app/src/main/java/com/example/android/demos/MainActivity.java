package com.example.android.demos;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //this code is to get notification
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),1,intent,0);
        Notification notification=new Notification.Builder(getApplicationContext())
                .setContentTitle("Lunch is ready")
                .setContentText("It's getting cold...")
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .build();
        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1,notification);






        //this code to get ads in the bottom of the application and we have to update manifest+gradle build +strings
        AdView adView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest =new AdRequest.Builder().build();
        adView.loadAd(adRequest);


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
    public void upload (View view){
        Intent upload =new Intent(this,UploadFromGallary.class);
        startActivity(upload);
    }
    public void animation (View view){
        Intent animate =new Intent(this,Zoom.class);
        startActivity(animate);
    }
    public void camera (View view){
        Intent camera =new Intent(this,Zoom.class);
        startActivity(camera);}

    public void bluetooth(View view){
        Intent blue =new Intent(this,Bluetooth.class);
        startActivity(blue);
    }


    public void nextPage(View view){
        Intent intent = new Intent(this,NextPage.class);
        startActivity(intent);
    }
    public void internalStorage(View view){
        Intent intent=new Intent(this, InternalStorage.class);
        startActivity(intent);
    }
    public void cacheIE(View view) {
        Intent intent = new Intent(this, CacheIE.class);
        startActivity(intent);
    }
    public void sqLite(View view){
        Intent intent= new Intent(this, SqliteDataBase.class);
        startActivity(intent);
    }



    }
