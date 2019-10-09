package com.example.manawa;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.hawk.Hawk;

import java.util.ArrayList;

public class TernakAdapter extends RecyclerView.Adapter<TernakAdapter.TernakViewHolder> {

    private ArrayList<Ternak> dataList;
    private Context mContext;
    public TernakAdapter(Context mContext, ArrayList<Ternak> dataList){
        this.mContext = mContext;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public TernakViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.card_ternak, parent, false);
        return new TernakViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TernakViewHolder holder, final int position) {
        holder.nama.setText(dataList.get(position).getNama());
        holder.umurlokasi.setText(dataList.get(position).getUmur()+" Bulan - "+dataList.get(position).getLokasi());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(mContext, DetailTernakSaya.class);
                i.putExtra("nama", dataList.get(position).getNama());
                i.putExtra("umurlokasi", dataList.get(position).getUmur()+" Bulan - "+dataList.get(position).getLokasi());
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (dataList != null) ? dataList.size() : 0;
    }

    public class TernakViewHolder extends RecyclerView.ViewHolder{
        private TextView nama, umurlokasi;


        public TernakViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = (TextView)itemView.findViewById(R.id.textView46);
            umurlokasi = (TextView)itemView.findViewById(R.id.textView47);
        }

    }
}
