package com.example.eagle_parent.adapters;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.eagle_parent.R;
import com.example.eagle_parent.activities.BaseActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.fragments.ConnectAccountFragment;
import com.example.eagle_parent.models.AppModel;
import com.example.eagle_parent.models.ChildModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.MyViewHolder> {
    ArrayList<ChildModel> list;
    Context context;


    public ChildAdapter(Context context, ArrayList<ChildModel> list) {
        this.context = context;
        this.list = list;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_child, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ChildModel childModel = list.get(position);
        Glide.with(context).load(childModel.getImage()).into(holder.ivChildProfile);
       // holder.ivChildProfile.setImageBitmap(BitmapFactory.decodeFile(childModel.getImage()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        CircleImageView ivChildProfile;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            ivChildProfile = itemView.findViewById(R.id.ivChildProfile);
        }
    }
}