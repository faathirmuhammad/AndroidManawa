package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.io.Console;

public class DetailTernak extends AppCompatActivity {

    CarouselView cv;
    int[] images = {R.drawable.kambing, R.drawable.kambing1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_ternak);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
//        toolbar.setBackgroundColor(Color.WHITE);
//        toolbar.setTitleTextColor(Color.WHITE);
//        getSupportActionBar().setTitle("Kambing Etawa");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cv = findViewById(R.id.carouselview);
        cv.setPageCount(images.length);
        cv.setImageListener(imageListener);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailTernak.this, DetailPemesanan.class);
                startActivity(i);
            }
        });

        TextView text_nama = findViewById(R.id.textView9);
        text_nama.setText(Hawk.get("nama").toString());
        getSupportActionBar().setTitle(Hawk.get("nama").toString());
        TextView text_umurlokasi = findViewById(R.id.textView24);
        text_umurlokasi.setText(Hawk.get("umur").toString()+" Bulan - "+Hawk.get("lokasi").toString());
        TextView text_harga = findViewById(R.id.textView25);
        text_harga.setText(Hawk.get("harga").toString());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DetailTernak.this, PilihTernak.class);
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
