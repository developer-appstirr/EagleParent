package com.example.eagle_parent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.models.AppModel;

import java.util.ArrayList;

public class MyAppsAdapter extends RecyclerView.Adapter<MyAppsAdapter.MyViewHolder> {
    ArrayList<AppModel> list;
    Context context;


    public MyAppsAdapter(Context context, ArrayList<AppModel> list) {
        this.context = context;
        this.list = list;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_my_apps, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AppModel appModel = list.get(position);
        holder.txtAppName.setText(appModel.getName());
        holder.ivAppImage.setImageResource(appModel.getIcon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        ImageView ivAppImage;
        TextView txtAppName,txtAllow,txtBlock;
        CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            ivAppImage = itemView.findViewById(R.id.ivAppImage);
            txtAppName = itemView.findViewById(R.id.txtAppName);
            checkBox = itemView.findViewById(R.id.checkBox);

            txtAllow = itemView.findViewById(R.id.txtAllow);
            txtBlock = itemView.findViewById(R.id.txtBlock);

        }
    }
}