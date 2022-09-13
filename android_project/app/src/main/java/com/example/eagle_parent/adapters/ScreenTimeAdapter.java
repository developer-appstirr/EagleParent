package com.example.eagle_parent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.models.ScreenTimeModel;

import java.util.ArrayList;

public class ScreenTimeAdapter extends RecyclerView.Adapter<ScreenTimeAdapter.MyViewHolder> {
    ArrayList<ScreenTimeModel> list;
    Context context;


    public ScreenTimeAdapter(Context context, ArrayList<ScreenTimeModel> list) {
        this.context = context;
        this.list = list;

    }





    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_screen_time, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ScreenTimeModel screenTimeModel = list.get(position);
        holder.txtScreenName.setText(screenTimeModel.getScreenName());
        holder.txtTime.setText(screenTimeModel.getStartTime() + " - " + screenTimeModel.getEndTime());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(screenTimeModel.isActive()) {
                    screenTimeModel.setActive(false);
                    holder.txtActive.setVisibility(View.GONE);
                }else {
                    screenTimeModel.setActive(true);
                    holder.txtActive.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's

        TextView txtScreenName,txtActive,txtTime;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            txtScreenName = itemView.findViewById(R.id.txtScreenName);
            txtActive = itemView.findViewById(R.id.txtActive);
            txtTime = itemView.findViewById(R.id.txtTime);

        }
    }
}