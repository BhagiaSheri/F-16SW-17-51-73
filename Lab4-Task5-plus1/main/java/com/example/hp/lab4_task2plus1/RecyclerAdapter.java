package com.example.hp.lab4_task2plus1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private String[] data;
    public RecyclerAdapter(String[] data){
        this.data = data;
        }

    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view=inflater.inflate(R.layout.itemslayout,viewGroup,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
      String title=data[i];
      recyclerViewHolder.tv.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
           ImageView img;
           TextView tv;
        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.itemimg);
            tv=itemView.findViewById(R.id.itemname);
        }
    }

}
