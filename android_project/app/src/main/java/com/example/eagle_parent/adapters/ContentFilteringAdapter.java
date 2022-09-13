package com.example.eagle_parent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.fragments.ContentFilteringFragment;
import com.example.eagle_parent.models.ContentFilteringModel;

import java.util.ArrayList;

public class ContentFilteringAdapter extends RecyclerView.Adapter<ContentFilteringAdapter.MyViewHolder> {
    ArrayList<ContentFilteringModel> list;
    Context context;


    public ContentFilteringAdapter(Context context, ArrayList<ContentFilteringModel> list) {
        this.context = context;
        this.list = list;

    }





    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_content_filtering, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ContentFilteringModel contentFilteringModel = list.get(position);
        holder.txtCategoryName.setText(contentFilteringModel.getFilterName());

        if (contentFilteringModel.isAlert()) {
            holder.imgAlert.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_alert));
            holder.imgAlert.setColorFilter(ContextCompat.getColor(context, R.color.primaryBlue));
        } else {
            holder.imgAlert.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_alert));
            holder.imgAlert.setColorFilter(ContextCompat.getColor(context, R.color.textHintColor));
        }
        holder.imgAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contentFilteringModel.isAlert()) {
                    contentFilteringModel.setAlert(false);
                    holder.imgAlert.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_alert));
                    holder.imgAlert.setColorFilter(ContextCompat.getColor(context, R.color.textHintColor));
                    Utils.showToast(context, "Alerts for this filter is OFF", AppConstant.TOAST_TYPES.SUCCESS);
                } else {
                    holder.imgAlert.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_alert));
                    contentFilteringModel.setAlert(true);
                    holder.imgAlert.setColorFilter(ContextCompat.getColor(context, R.color.primaryBlue));
                    Utils.showToast(context, "Alerts for this filter is ON", AppConstant.TOAST_TYPES.SUCCESS);
                }

            }
        });


        if (contentFilteringModel.isAllow()) {
            holder.imgAllow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_check_circle_outline_24));
            holder.imgAllow.setColorFilter(ContextCompat.getColor(context, R.color.green));
        } else {
            holder.imgAllow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_check_circle_outline_24));
            holder.imgAllow.setColorFilter(ContextCompat.getColor(context, R.color.red));

        }

        holder.imgAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contentFilteringModel.isAllow()) {
                    contentFilteringModel.setAllow(false);
                    holder.imgAllow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_check_circle_outline_24));
                    holder.imgAllow.setColorFilter(ContextCompat.getColor(context, R.color.red));
                    Utils.showToast(context, "You have disable this filter", AppConstant.TOAST_TYPES.SUCCESS);
                } else {
                    contentFilteringModel.setAllow(true);
                    holder.imgAllow.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_baseline_check_circle_outline_24));
                    holder.imgAllow.setColorFilter(ContextCompat.getColor(context, R.color.green));
                    Utils.showToast(context, "You have allowed this filter", AppConstant.TOAST_TYPES.SUCCESS);
                }

            }
        });



        if (contentFilteringModel.isBlock()) {
            holder.imgBlock.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_unblock));
            holder.imgBlock.setColorFilter(ContextCompat.getColor(context, R.color.green));
        } else {
            holder.imgBlock.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_block));
            holder.imgBlock.setColorFilter(ContextCompat.getColor(context, R.color.red));
        }
        holder.imgBlock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (contentFilteringModel.isBlock()) {
                    contentFilteringModel.setBlock(false);
                 //   holder.imgBlock.setBackgroundResource(R.drawable.ic_block);
                    holder.imgBlock.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_block));
                    holder.imgBlock.setColorFilter(ContextCompat.getColor(context, R.color.red));
                    Utils.showToast(context, "You have blocked this filter", AppConstant.TOAST_TYPES.SUCCESS);
                } else {
                    contentFilteringModel.setBlock(true);
                    holder.imgBlock.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_unblock));
                    holder.imgBlock.setColorFilter(ContextCompat.getColor(context, R.color.green));
                    Utils.showToast(context, "You have unblock this filter", AppConstant.TOAST_TYPES.SUCCESS);
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

        TextView txtCategoryName;
        ImageView imgAllow,imgAlert,imgBlock;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            txtCategoryName = itemView.findViewById(R.id.txtCategoryName);
            imgAllow = itemView.findViewById(R.id.imgAllow);
            imgAlert = itemView.findViewById(R.id.imgAlert);
            imgBlock = itemView.findViewById(R.id.imgBlock);

        }
    }
}