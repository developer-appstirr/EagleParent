package com.example.eagle_parent.adapters;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.activities.BaseActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.JsonElement;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    Context context;
    final LayoutInflater inflater;
    List<String> data;

    public NotificationAdapter(Context context, List<String> data) {

        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_notification, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

//        holder.txtNotificationTitle.setText(data.get(position).getTitle());
//        holder.txtNotificationDescription.setText(data.get(position).getDiscription());
//        holder.txtDate.setText(Utils.getDateFromServer(data.get(position).getDate()));
//        holder.txtTime.setText(Utils.getTimeFromServer(data.get(position).getDate()));

        holder.btnMenu.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {

                Context context1 = new ContextThemeWrapper(context, R.style.popupMenuStyle);
                MenuBuilder menuBuilder =new MenuBuilder(context1);
                MenuInflater inflater = new MenuInflater(context1);
                inflater.inflate(R.menu.notification_menu, menuBuilder);
                @SuppressLint("RestrictedApi") MenuPopupHelper optionsMenu = new MenuPopupHelper(context1 , menuBuilder, v);
                optionsMenu.setForceShowIcon(true);
                optionsMenu.setGravity(Gravity.CENTER_HORIZONTAL);

                // Set Item Click Listener
                menuBuilder.setCallback(new MenuBuilder.Callback() {
                    @Override
                    public boolean onMenuItemSelected(MenuBuilder menu, MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.notification_delete:
                                new MaterialAlertDialogBuilder(context,R.style.AlertDialogTheme)
                                        .setTitle("Delete Notification")
                                        .setMessage("Are you sure? you want to delete this")
                                        .setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
//                                               deleteNotificationToServer(String.valueOf(data.get(position).getId()),position);
                                                dialogInterface.dismiss();
                                            }
                                        })
                                        .setNeutralButton("CANCEL", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                            }
                                        })
                                        .show();
                                break;

                            default:
                                break;
                        }
                        return true;
                    }

                    @Override
                    public void onMenuModeChange(MenuBuilder menu) {}
                });

                optionsMenu.show();
            }
        });



    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtNotificationTitle,txtNotificationDescription,txtDate,txtTime;
        ImageView imgNotification,btnMenu;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNotificationTitle = itemView.findViewById(R.id.txtNotificationTitle);
            txtNotificationDescription = itemView.findViewById(R.id.txtNotificationDescription);
            txtDate = itemView.findViewById(R.id.txtDate);
            txtTime = itemView.findViewById(R.id.txtTime);
            btnMenu = itemView.findViewById(R.id.btnMenu);
            imgNotification = itemView.findViewById(R.id.imgNotification);
        }

    }
    public void addAllList(List<String> data) {

        this.data.addAll(data);
        notifyDataSetChanged();

    }

//    private void deleteNotificationToServer(String id,int position) {
//
//        ((BaseActivity) context).onLoadingStarted();
//        WebApiRequest.getInstance( ((BaseActivity) context), true).deleteNotificaion(id,new WebApiRequest. APIRequestDataCallBack() {
//            @Override
//            public void onSuccess(JsonElement response) {
//                Utils.showToast(context,"Notification Deleted", AppConstant.TOAST_TYPES.SUCCESS);
//                data.remove(position);
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, data.size());
//
//
//
//            }
//
//            @Override
//            public void onError(JsonElement response) {
//
//                Utils.showToast(context,"Error", AppConstant.TOAST_TYPES.INFO);
//
//            }
//
//            @Override
//            public void onNoNetwork() {
//
//            }
//        });
//    }

}