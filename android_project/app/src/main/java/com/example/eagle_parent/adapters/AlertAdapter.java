package com.example.eagle_parent.adapters;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.activities.BaseActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.models.AlertModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

public class AlertAdapter extends RecyclerView.Adapter<AlertAdapter.MyViewHolder> {
    ArrayList<AlertModel> list;
    Context context;
    final LayoutInflater inflater;



    public AlertAdapter(Context context, ArrayList<AlertModel> list) {
        this.context = context;
        this.list = list;

        inflater = LayoutInflater.from(context);

    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_threat_alert, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        AlertModel alertModel = list.get(position);

            holder.ivAppImage.setImageResource(alertModel.getAppLogo());
            holder.txtAppName.setText(alertModel.getAppName());
            holder.txtDate.setText("on " + alertModel.getDate());
            holder.txtThreatSeverity.setText(alertModel.getSeverityLevel());
            holder.imvProfile.setImageResource(alertModel.getOffenderImg());
            holder.txtUserName.setText(alertModel.getOffenderName());

            if(alertModel.getOffenderDescription()!=null) {
                holder.txtThreatMessage.setVisibility(View.VISIBLE);
                holder.txtThreatMessage.setText(alertModel.getOffenderDescription());
            }else{
                holder.txtThreatMessage.setVisibility(View.GONE);
            }
            holder.txtLink.setText(alertModel.getOffenderLink());


            holder.ivPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    TedPermission.with(context)
                            .setPermissions(Manifest.permission.CALL_PHONE)
                            .setPermissionListener(new PermissionListener() {
                                @Override
                                public void onPermissionGranted() {
                                    String phone = "+12025550132";
                                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+ phone));
                                    context.startActivity(intent);
                                }

                                @Override
                                public void onPermissionDenied(List<String> deniedPermissions) {
                                    Toasty.warning(context, context.getString(R.string.permission_denied), Toast.LENGTH_SHORT).show();
                                }

                            }).check();

                }
            });


        if (alertModel.isBlockApp()) {
            holder.ivBlock.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_unblock));
            holder.ivBlock.setColorFilter(ContextCompat.getColor(context, R.color.green));
        } else {
            holder.ivBlock.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_block));
            holder.ivBlock.setColorFilter(ContextCompat.getColor(context, R.color.red));
        }

            holder.ivBlock.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (alertModel.isBlockApp()) {
                        alertModel.setBlockApp(false);
                        holder.ivBlock.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_block));
                        holder.ivBlock.setColorFilter(ContextCompat.getColor(context, R.color.red));
                        Utils.showToast(context, alertModel.getAppName() + " Blocked", AppConstant.TOAST_TYPES.SUCCESS);
                    } else {
                        alertModel.setBlockApp(true);
                        holder.ivBlock.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_unblock));
                        holder.ivBlock.setColorFilter(ContextCompat.getColor(context, R.color.green));
                        Utils.showToast(context, alertModel.getAppName() + " Unblocked", AppConstant.TOAST_TYPES.SUCCESS);

                    }
                }
            });


            holder.txtLink.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String url = holder.txtLink.getText().toString();
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    ((BaseActivity) context).startActivity(i);
                }
            });


            holder.ivDisconnect.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (alertModel.isWifiOn()) {
                        alertModel.setWifiOn(false);
                        holder.ivDisconnect.setColorFilter(ContextCompat.getColor(context, R.color.red));
                        Utils.showToast(context, "WiFi Disconnected", AppConstant.TOAST_TYPES.SUCCESS);
                    } else {
                        alertModel.setWifiOn(true);
                        holder.ivDisconnect.setColorFilter(ContextCompat.getColor(context, R.color.green));
                        Utils.showToast(context, "WiFi Connected", AppConstant.TOAST_TYPES.SUCCESS);
                    }

                }
            });
        }

//            if(list==null){
//                holder.chipGroup.setVisibility(View.GONE);
//            }else {
//                setCategoryChips(null,holder.chipGroup);
//            }





    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        ImageView ivAppImage,ivBlock,ivPhone,ivDisconnect;
        TextView txtAppName,txtDate,txtThreatSeverity,txtUserName,txtThreatMessage,txtLink;
        Button btnBadge,btnBlock,btnSendReport;
        CircleImageView imvProfile;
        ChipGroup chipGroup;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            ivAppImage = itemView.findViewById(R.id.ivAppImage);
            txtAppName = itemView.findViewById(R.id.txtAppName);
            txtDate = itemView.findViewById(R.id.txtDate);
            btnBadge = itemView.findViewById(R.id.btnBadge);
            imvProfile = itemView.findViewById(R.id.imvProfile);
            ivBlock = itemView.findViewById(R.id.ivBlock);
            ivPhone = itemView.findViewById(R.id.ivPhone);
            ivDisconnect = itemView.findViewById(R.id.ivDisconnect);
            txtThreatSeverity = itemView.findViewById(R.id.txtThreatSeverity);
            txtUserName = itemView.findViewById(R.id.txtUserName);
            txtThreatMessage = itemView.findViewById(R.id.txtThreatMessage);
            txtLink = itemView.findViewById(R.id.txtLink);
        }
    }

    public void setCategoryChips(ArrayList<String> categorys, ChipGroup chipGroup) {
        for (String category : categorys) {
            Chip mChip = (Chip) inflater.inflate(R.layout.item_chip, null, false);
            mChip.setText(category);
            int paddingDp = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 10,
                    context.getResources().getDisplayMetrics()
            );
            mChip.setPadding(paddingDp, 0, paddingDp, 0);
            chipGroup.addView(mChip);
        }
    }
}