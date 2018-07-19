package com.example.vantruong.baitapvenha207;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    Context mContext;
    int viTri;
    boolean listenClickItem = false; //lắng nghe item dc chọn.
    List<Data> list = new ArrayList<>();

    public Adapter(Context mContext, List<Data> list) {
        this.mContext = mContext;
        this.list = list;
    }

    public boolean isListenClickItem() {
        return listenClickItem;
    }

    public int getViTri() {
        return viTri;
    }

    public void setList(List<Data> list) {
        this.list = list;
    }

    public List<Data> getList() {
        return list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        Data data = list.get(position);
        listenClickItem = false;
        holder.tvItem.setText(data.getTen() + " - " + data.getTuoi() + " tuổi - " + data.getDiaChi());
        holder.tvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viTri = position;
                listenClickItem = true;
//                Toast.makeText(mContext,""+position,Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvItem;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvItem = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }
}
