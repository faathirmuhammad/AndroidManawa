package com.example.manawa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;

public class Pembayaran extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembayaran);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar6);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pembayaran");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Pembayaran.this, Konfirmasi.class);
                startActivity(i);
            }
        });

        TextView hargatotal = findViewById(R.id.textView30);
        int random = (int)(Math.random()*300)+100;
        if(Hawk.get("umur").toString().equals("3")){
            hargatotal.setText("Rp 628."+String.valueOf(random));
        }else if(Hawk.get("umur").toString().equals("4")){
            hargatotal.setText("Rp 900."+String.valueOf(random));
        }else{
            hargatotal.setText("Rp 1.250."+String.valueOf(random));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(Pembayaran.this, Home.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
