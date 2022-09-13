package com.example.eagle_parent.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.activities.BaseActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.fragments.MonitoringControlsFragment;
import com.example.eagle_parent.models.ProtectedDeviceModel;

import java.util.ArrayList;

public class ProtectedDeviceAdapter extends RecyclerView.Adapter<ProtectedDeviceAdapter.MyViewHolder> {
    ArrayList<ProtectedDeviceModel> list;
    Context context;


    public ProtectedDeviceAdapter(Context context, ArrayList<ProtectedDeviceModel> list) {
        this.context = context;
        this.list = list;

    }





    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_protected_device, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ProtectedDeviceModel protectedDeviceModel = list.get(position);
        holder.txtDevice.setText(protectedDeviceModel.getTitle());
        holder.txtBlock.setText(protectedDeviceModel.getBlockAlerts());
        holder.txtMessage.setText(protectedDeviceModel.getActivitiesCount());
        holder.txtReviewed.setText(protectedDeviceModel.getReviewedAlerts());
        holder.txtTime.setText(protectedDeviceModel.getScreenTime());

        holder.btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonitoringControlsFragment monitoringControlsFragment = new MonitoringControlsFragment();
                ((BaseActivity) context).addSupportFragment(monitoringControlsFragment, AppConstant.TRANSITION_TYPES.SLIDE);
            }
        });

        holder.btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showToast(context,protectedDeviceModel.getTitle()+" Device Paused",AppConstant.TOAST_TYPES.SUCCESS);
            }
        });

        holder.btnDisconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showToast(context, protectedDeviceModel.getTitle()+" Device Internet Access Restricted",AppConstant.TOAST_TYPES.SUCCESS);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's

        TextView txtDevice,txtMessage,txtReviewed,txtTime,txtBlock;
        Button btnSetting,btnPause,btnDisconnect;


        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            txtDevice = itemView.findViewById(R.id.txtDevice);
            btnSetting = itemView.findViewById(R.id.btnSetting);

            txtMessage = itemView.findViewById(R.id.txtMessage);
            btnPause = itemView.findViewById(R.id.btnPause);
            btnDisconnect = itemView.findViewById(R.id.btnDisconnect);


            txtBlock = itemView.findViewById(R.id.txtBlock);
            txtTime = itemView.findViewById(R.id.txtTimeRange);
            txtReviewed = itemView.findViewById(R.id.txtReviewed);

        }
    }
}