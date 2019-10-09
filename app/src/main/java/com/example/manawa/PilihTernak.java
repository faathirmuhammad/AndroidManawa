package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.orhanobut.hawk.Hawk;

public class PilihTernak extends AppCompatActivity {

    CardView card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilih_ternak);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(Color.WHITE);
//        toolbar.setTitleTextColor(getResources().getColor(R.color.colorPrimary));
        getSupportActionBar().setTitle("Pilih Kambing");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Hawk.init(getApplicationContext()).build();

        //KAMBING NOMOR 1
        card = findViewById(R.id.cardView5);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hawk.put("nama", "Kambing Kacang");
                Hawk.put("umur", "3");
                Hawk.put("lokasi", "Dayeuhkolot");
                Hawk.put("harga", "Rp 578.000");
                Intent intent = new Intent(PilihTernak.this, DetailTernak.class);
                startActivity(intent);
            }
        });

        //KAMBING NOMOR 2
        CardView kambingdua = findViewById(R.id.cardView10);
        kambingdua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hawk.put("nama", "Kambing Etawa");
                Hawk.put("umur", "4");
                Hawk.put("lokasi", "Majalengka");
                Hawk.put("harga", "Rp 850.000");
                Intent intent = new Intent(PilihTernak.this, DetailTernak.class);
                startActivity(intent);
            }
        });

        //KAMBING NOMOR 3
        CardView kambingtiga = findViewById(R.id.cardView11);
        kambingtiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hawk.put("nama", "Kambing Kacang");
                Hawk.put("umur", "6");
                Hawk.put("lokasi", "Majalengka");
                Hawk.put("harga", "Rp 1.200.000");
                Intent intent = new Intent(PilihTernak.this, DetailTernak.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(PilihTernak.this, PilihHewan.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
