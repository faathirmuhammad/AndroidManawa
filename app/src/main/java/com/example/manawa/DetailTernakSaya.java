package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class DetailTernakSaya extends AppCompatActivity {

    CarouselView cv;
    int[] images = {R.drawable.kambing, R.drawable.kambing1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ternak_saya);
        Hawk.init(getApplicationContext()).build();

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar9);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getIntent().getStringExtra("nama"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cv = findViewById(R.id.carouselview);
        cv.setPageCount(images.length);
        cv.setImageListener(imageListener);

        TextView nama = findViewById(R.id.textView9);
        TextView umurlokasi = findViewById(R.id.textView24);
        nama.setText(getIntent().getStringExtra("nama"));
        umurlokasi.setText(getIntent().getStringExtra("umurlokasi"));

        Button button = findViewById(R.id.button2);

        if(getIntent().getStringExtra("terjual").equals("terjual")){
            button.setBackgroundColor(Color.RED);
            button.setTextColor(Color.WHITE);
            button.setText("Ternak Ini Siap Dijual");
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DetailTernakSaya.this, TernakSaya.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };
}
