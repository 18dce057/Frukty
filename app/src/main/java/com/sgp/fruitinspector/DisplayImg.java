package com.sgp.fruitinspector;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.File;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DisplayImg extends AppCompatActivity {
    ImageView imgv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_img);
        imgv=findViewById(R.id.imageView);
       //File file= new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), getIntent().getStringExtra("image_path"));
        File file= new File(getIntent().getStringExtra("image_path"));
        /*if(file==null){
            Bitmap bitmap= BitmapFactory.decodeFile(getIntent().getStringExtra("image_path"));
            imgv.setImageBitmap(bitmap);
        }*/
        final Transformation transformation = new RoundedCornersTransformation(450, 15);
        Picasso.get().load(file).centerCrop().resize(500, 500).transform(transformation).into(imgv);

    }
}