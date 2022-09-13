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
import com.example.eagle_parent.listners.CheckBoxListner;
import com.example.eagle_parent.models.AppModel;

import java.util.ArrayList;

public class AllAppsAdapter extends RecyclerView.Adapter<AllAppsAdapter.MyViewHolder> {
    ArrayList<AppModel> list;
    ArrayList<AppModel> selectedList = new ArrayList<>();
    Context context;
    CheckBoxListner checkBoxListner;

    public AllAppsAdapter(Context context, ArrayList<AppModel> list, CheckBoxListner checkBoxListner) {
        this.context = context;
        this.list = list;
        this.checkBoxListner = checkBoxListner;

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_select_social_app, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        AppModel appModel = list.get(position);

        holder.txtAppName.setText(appModel.getName());
        holder.ivAppImage.setImageResource(appModel.getIcon());

        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!appModel.getSelected()){

                    //holder.checkBox.setChecked(false);
                    appModel.setSelected(true);
                    selectedList.add(appModel);
                    holder.checkBox.setChecked(appModel.getSelected());
                    checkBoxListner.setListApp(selectedList);
                    notifyDataSetChanged();


                }else {
                  //  holder.checkBox.setChecked(false);
                    selectedList.remove(appModel);
                    appModel.setSelected(false);
                    checkBoxListner.setListApp(selectedList);
                    holder.checkBox.setChecked(appModel.getSelected());
                    notifyDataSetChanged();

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
        ImageView ivAppImage;
        TextView txtAppName;
        CheckBox checkBox;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            ivAppImage = itemView.findViewById(R.id.ivAppImage);
            txtAppName = itemView.findViewById(R.id.txtAppName);
            checkBox = itemView.findViewById(R.id.checkBox);

        }
    }
}