package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    CardView tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tambah = findViewById(R.id.cardview_tambah);
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, PilihHewan.class);
                startActivity(i);
            }
        });

        CardView card_ternaksaya = findViewById(R.id.card_ternaksaya);
        card_ternaksaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, TernakSaya.class);
                startActivity(i);
            }
        });

        CardView card_user = findViewById(R.id.card_user);
        card_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Akun.class);
                startActivity(i);
            }
        });

        CardView card_peternak = findViewById(R.id.card_peternak);
        card_peternak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, Peternak.class);
                startActivity(i);
            }
        });

//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

    }
}
