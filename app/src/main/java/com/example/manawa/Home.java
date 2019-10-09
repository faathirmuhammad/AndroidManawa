package com.example.manawa;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.orhanobut.hawk.Hawk;
import com.yarolegovich.lovelydialog.LovelyStandardDialog;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    CardView tambah;
    private LineChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //CHART
        chart = findViewById(R.id.chart1);
        chart.setViewPortOffsets(0,0,0,0);
        chart.getDescription().setEnabled(false);
        chart.setTouchEnabled(true);
        chart.setDragEnabled(true);
        chart.setPinchZoom(false);
        chart.setDrawGridBackground(false);
        chart.getAxisLeft().setDrawGridLines(false);
        chart.getAxisRight().setDrawGridLines(false);
        chart.getXAxis().setDrawGridLines(false);
        chart.getLegend().setEnabled(false);

        List<Entry> entries = new ArrayList<Entry>();
        entries.add(new Entry(0,1));
        entries.add(new Entry(1,2));
        entries.add(new Entry(2,2));
        entries.add(new Entry(3,3));
        entries.add(new Entry(4,5));
        entries.add(new Entry(5,3));

        LineDataSet dataSet = new LineDataSet(entries, "Customized values");
        dataSet.setLineWidth(5);
        dataSet.setValueTextSize(10);
        dataSet.setColor(ContextCompat.getColor(this, R.color.putih));
        dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
        dataSet.setValueTextColor(ContextCompat.getColor(this, R.color.putih));

        LineData data = new LineData(dataSet);
        chart.setData(data);
        chart.invalidate();

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

        CardView card_keranjang = findViewById(R.id.card_keranjang);
        card_keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Home.this, DetailPemesanan.class);
                startActivity(i);
            }
        });

        boolean isDone = getIntent().getBooleanExtra("DonePayment", false);
        if(isDone == true){
            new LovelyStandardDialog(this, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                    .setTopColorRes(R.color.colorPrimaryDark)
                    .setButtonsColorRes(R.color.colorAccent)
                    .setTitle("Pembayaran Berhasil !")
                    .setMessage("Pembayaran anda berhasil diterima, anda dapat melihat hewan ternak yang telah dibeli melalui menu Ternak Saya")
                    .setPositiveButton("Ternak Saya", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(Home.this, TernakSaya.class);
                            startActivity(i);
                        }
                    })
                    .setNegativeButton("Tutup", null)
                    .show();
        }


//        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        if(Hawk.get("terjual").toString().equals("")){
            new LovelyStandardDialog(this, LovelyStandardDialog.ButtonLayout.HORIZONTAL)
                    .setTopColorRes(R.color.colorPrimaryDark)
                    .setButtonsColorRes(R.color.colorAccent)
                    .setTitle("Pembayaran Berhasil !")
                    .setMessage("Pembayaran anda berhasil diterima, anda dapat melihat hewan ternak yang telah dibeli melalui menu Ternak Saya")
                    .setPositiveButton("Ternak Saya", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent i = new Intent(Home.this, TernakSaya.class);
                            startActivity(i);
                        }
                    })
                    .setNegativeButton("Tutup", null)
                    .show();
        }else{

        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("test", String.valueOf(requestCode));

    }
}
