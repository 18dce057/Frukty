package com.sgp.fruitinspector;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DisplayImg extends AppCompatActivity {
    ImageView imgv;
    ListView listView;
    String fruits[]={
            "Apple","Strawberry","Orange","Guava","Cherry","Watermelon",
    };

    /*int img[]={R.drawable.a1,R.drawable.a2,R.drawable.cup,R.drawable.a4,R.drawable.a5,R.drawable.a6,R.drawable.a7,R.drawable.a8
            ,R.drawable.a9,R.drawable.a10,R.drawable.a11,R.drawable.a12,R.drawable.a13,R.drawable.a14,R.drawable.a15,R.drawable.apie,R.drawable.a16};*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_img);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.appbar_layout);
        imgv=findViewById(R.id.imageView);
        File file= new File(getIntent().getStringExtra("image_path"));

        final Transformation transformation = new RoundedCornersTransformation(450, 15);
        Picasso.get().load(file).centerCrop().resize(500, 500).transform(transformation).into(imgv);
        listView=(ListView)findViewById(R.id.fruitlist);
        customAdapter cad=new customAdapter();
        listView.setAdapter(cad);

    }

    class customAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return fruits.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView=getLayoutInflater().inflate(R.layout.activity_fruit_list,null);
            TextView textView_fruit=convertView.findViewById(R.id.fruitname);

            textView_fruit.setText(fruits[position]);
            return convertView;
        }
    }
}