package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.hawk.Hawk;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Konfirmasi extends AppCompatActivity {

    private ArrayList<Ternak> ternakArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar7);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bukti Pembayaran");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Konfirmasi.this, Home.class);
                i.putExtra("DonePayment", true);

                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                Gson gson = new Gson();
                String value = sharedPrefs.getString("Ternak", null);
                if(value == null){
                    Log.d("test", "gaada");
                    ternakArrayList = new ArrayList<Ternak>();
                }else{
                    Log.d("test", "ada");
                    Type type = new TypeToken<ArrayList<Ternak>>() {}.getType();
                    ternakArrayList = gson.fromJson(value, type);
                }

                ternakArrayList.add(new Ternak(Hawk.get("nama").toString(), Hawk.get("lokasi").toString(), Hawk.get("harga").toString(), Hawk.get("umur").toString()));

//                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPrefs.edit();

                String json = gson.toJson(ternakArrayList);

                editor.putString("Ternak", json);
                editor.commit();


                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(Konfirmasi.this, Pembayaran.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
