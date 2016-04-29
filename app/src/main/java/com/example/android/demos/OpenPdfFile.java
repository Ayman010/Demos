package com.example.android.demos;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

public class OpenPdfFile extends AppCompatActivity {
    private ImageView imageView;
    private int currentPage=0;
    private Button previous,next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_pdf_file);
        previous =(Button)findViewById(R.id.previous);
        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage++;
                render();

            }
        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPage--;
                render();
            }
        });
        render();


    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void render(){
        try {imageView=(ImageView)findViewById(R.id.pdf);
            int REQ_WIDTH=imageView.getWidth();
            int REQ_HIEGHT=imageView.getHeight();
            Bitmap bitmap=Bitmap.createBitmap(REQ_WIDTH,REQ_HIEGHT,Bitmap.Config.ARGB_4444);
            File file= new File("/sdcard/Download/sample.pdf");
            PdfRenderer renderer=new PdfRenderer(ParcelFileDescriptor.open(file,ParcelFileDescriptor.MODE_READ_ONLY));
            if (currentPage<0){
                currentPage=0;
            }else if(currentPage>renderer.getPageCount()){
                currentPage=renderer.getPageCount()-1;
            }
            Matrix m =imageView.getImageMatrix();
            Rect rect=new Rect(0,0,REQ_WIDTH,REQ_HIEGHT);
            renderer.openPage(currentPage).render(bitmap,rect,m,PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            imageView.setImageMatrix(m);
            imageView.setImageBitmap(bitmap);
            imageView.invalidate();


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
