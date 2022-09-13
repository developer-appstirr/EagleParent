package com.example.eagle_parent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MyWebExcemptionsAdapter extends RecyclerView.Adapter<MyWebExcemptionsAdapter.MyViewHolder> {
    ArrayList<String> list;
    Context context;


    public MyWebExcemptionsAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_web_list, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.txtWebName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's

        TextView txtWebName;
        MaterialButton txtAllow,txtBlock;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            txtWebName = itemView.findViewById(R.id.txtWebName);
            txtAllow = itemView.findViewById(R.id.txtAllow);
            txtBlock = itemView.findViewById(R.id.txtBlock);

        }
    }
}