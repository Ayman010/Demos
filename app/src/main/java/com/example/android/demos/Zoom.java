package com.example.android.demos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Zoom extends AppCompatActivity implements Animation.AnimationListener{
    ImageView image;
    Animation animZoomin , animZoomout;
    Button btnZoomin , btnZoomout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        image = (ImageView) findViewById(R.id.image_andrody);
        animZoomin = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_in);
        animZoomout = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom_out);
        btnZoomin = (Button) findViewById(R.id.zoom_in);
        animZoomin.setAnimationListener(this);
        btnZoomin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                image.setVisibility(View.VISIBLE);

                // start the animation
                image.startAnimation(animZoomin);
            }
        });
        btnZoomout = (Button) findViewById(R.id.zoom_out);
        animZoomout.setAnimationListener(this);
        btnZoomout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                image.setVisibility(View.VISIBLE);


                image.startAnimation(animZoomout);
            }
        });



    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animZoomin) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }
        if (animation == animZoomout) {
            Toast.makeText(getApplicationContext(), "Animation Stopped",
                    Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
