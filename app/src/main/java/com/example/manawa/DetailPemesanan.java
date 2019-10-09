package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

public class DetailPemesanan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemesanan);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Detail Pemesanan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Checkout
        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(DetailPemesanan.this, Pembayaran.class);
                startActivity(i);
            }
        });

        TextView nama = findViewById(R.id.textView10);
        TextView umurlokasi = findViewById(R.id.textView11);
        TextView harga = findViewById(R.id.textView12);
        TextView hargasebelum = findViewById(R.id.textView35);
        TextView total = findViewById(R.id.textView29);
        TextView detail_nama = findViewById(R.id.textView34);

        nama.setText(Hawk.get("nama").toString());
        umurlokasi.setText(Hawk.get("umur").toString()+" Bulan - "+Hawk.get("lokasi"));
        harga.setText(Hawk.get("harga").toString());
        hargasebelum.setText(Hawk.get("harga").toString());
        detail_nama.setText("1 Ekor "+Hawk.get("nama").toString());

        if(Hawk.get("umur").toString().equals("3")){
            total.setText("Rp 628.000");
        }else if(Hawk.get("umur").toString().equals("4")){
            total.setText("Rp 900.000");
        }else{
            total.setText("Rp 1.250.000");
        }

        Log.d("test", Hawk.get("umur").toString());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DetailPemesanan.this, DetailTernak.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
