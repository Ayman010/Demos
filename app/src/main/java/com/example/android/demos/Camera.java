package com.example.android.demos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Camera extends AppCompatActivity {
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        button=(Button)findViewById(R.id.takephoto);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCamera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(openCamera,2);

            }
        });
    }
    protected void onActivityResult(int requestCode , int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode==RESULT_OK){
            if (requestCode==2){

                Uri selectedImage= data.getData();
                if (selectedImage.getPath()!=null){

                }

            }
        }

    }

}
