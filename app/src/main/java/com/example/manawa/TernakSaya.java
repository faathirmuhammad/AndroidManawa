package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orhanobut.hawk.Hawk;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TernakSaya extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TernakAdapter adapter;
    private ArrayList<Ternak> ternakArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ternak_saya);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar8);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Ternak Saya");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView cardView = findViewById(R.id.cardView5);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TernakSaya.this, DetailTernakSaya.class);
                i.putExtra("nama", "Kambing Kacang");
                i.putExtra("umurlokasi", "12 Bulan - Dayeuhkolot");
                i.putExtra("terjual", "terjual");
                startActivity(i);
            }
        });

        Hawk.init(getApplicationContext()).build();


        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Gson gson = new Gson();
        String json = sharedPrefs.getString("Ternak", null);
        Type type = new TypeToken<ArrayList<Ternak>>() {}.getType();
        ArrayList<Ternak> arrayList = gson.fromJson(json, type);

//        ternakArrayList = new ArrayList<>();
//        ternakArrayList.add(new Ternak("Kambing Kacang", "Bandung", "65.000", "3"));

        RecyclerView recyclerView = findViewById(R.id.recyclerTernak);
        adapter = new TernakAdapter(TernakSaya.this, arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TernakSaya.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(TernakSaya.this, Home.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
