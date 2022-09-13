package com.example.eagle_parent.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentManager;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.activities.BaseActivity;
import com.example.eagle_parent.activities.LoginFlow.LoginActivity;
import com.example.eagle_parent.fragments.MonitoringControlsFragment;
import com.example.eagle_parent.listners.ChooseImageInterface;
import com.example.eagle_parent.listners.DialogBoxListner;
import com.example.eagle_parent.listners.EndTimePickerListner;
import com.example.eagle_parent.listners.ExitAppListner;
import com.example.eagle_parent.listners.ScreenTimeListner;
import com.example.eagle_parent.listners.StartTimePickerListner;
import com.example.eagle_parent.listners.WebsiteExemptionsListner;
import com.example.eagle_parent.models.ScreenTimeModel;
import com.googlecode.mp4parser.authoring.Edit;

import org.w3c.dom.Text;


public class AppDialogs implements DialogBoxListner {

    Dialog dialog;



    public void showChooseImageDialog(final Activity activity, ChooseImageInterface chooseImageInterface){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_choose_image);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        final TextView btnGallery = dialog.findViewById(R.id.btnGallery);
        final TextView btnCamera = dialog.findViewById(R.id.btnCamera);
        final ImageView btnCross = dialog.findViewById(R.id.btnCross);


        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                chooseImageInterface.chooseGalleryCallBack();
                // logoutInterface.logoutCallBack();
            }
        });

        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                // logoutInterface.logoutCallBack();
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

                chooseImageInterface.chooseCameraCallBack();
                // logoutInterface.logoutCallBack();
            }
        });


        dialog.setCancelable(false);

        //Dismiss the Dialog
        dialog.dismiss();
        //Show Dialog
        dialog.show();


    }


    public void showWebSiteExemptionDialog(final Activity activity, WebsiteExemptionsListner websiteExemptionsListner){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_add_web);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        final EditText etWebsite = dialog.findViewById(R.id.etWebsite);
        final TextView btnSave = dialog.findViewById(R.id.btnSave);
        final ImageView btnCross = dialog.findViewById(R.id.btnCross);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                websiteExemptionsListner.setWebsiteUrl(etWebsite.getText().toString());
                dialog.dismiss();
            }
        });

        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        dialog.setCancelable(false);

        //Dismiss the Dialog
        dialog.dismiss();
        //Show Dialog
        dialog.show();


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void showScreenTimeDialog(final Activity activity, FragmentManager childFragmentManager, ScreenTimeListner screenTimeListner){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_add_screen_time);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        final EditText etScreenName = dialog.findViewById(R.id.etScreenName);
        final TextView btnSave = dialog.findViewById(R.id.btnSave);
        final ImageView btnCross = dialog.findViewById(R.id.btnCross);
        final TextView txtToTime = dialog.findViewById(R.id.txtToTime);
        final TextView txtFromTime = dialog.findViewById(R.id.txtFromTime);

        txtFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.StartTimePicker(childFragmentManager, new StartTimePickerListner() {
                    @Override
                    public void setStartTime(String time) {
                        txtFromTime.setText(time);
                    }
                });
            }
        });

        txtToTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.EndTimePicker(childFragmentManager, new EndTimePickerListner() {
                    @Override
                    public void setEndTime(String time) {
                        txtToTime.setText(time);
                    }
                });
            }
        });



        btnSave.setOnClickListener(v -> {
            ScreenTimeModel screenTimeModel = new ScreenTimeModel();
            screenTimeModel.setActive(false);
            screenTimeModel.setScreenName(etScreenName.getText().toString());
            screenTimeModel.setStartTime(txtFromTime.getText().toString());
            screenTimeModel.setEndTime(txtToTime.getText().toString());

            screenTimeListner.setScreenTime(screenTimeModel);
            dialog.dismiss();
        });

        btnCross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        dialog.setCancelable(false);

        //Dismiss the Dialog
        dialog.dismiss();
        //Show Dialog
        dialog.show();


    }

    public void exitAppDialog(final Activity activity, ExitAppListner exitAppListner){

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_exit_app);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        final TextView btnYes = dialog.findViewById(R.id.btnYes);
        final TextView btnNo = dialog.findViewById(R.id.btnNo);


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitAppListner.exitApp();
                dialog.dismiss();
                // logoutInterface.logoutCallBack();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                // logoutInterface.logoutCallBack();
            }
        });

        dialog.setCancelable(false);

        //Show Dialog
        dialog.show();


    }


    public void signOutDialog(final Activity activity ){

        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_sign_out);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        final TextView btnYes = dialog.findViewById(R.id.btnYes);
        final TextView btnNo = dialog.findViewById(R.id.btnNo);


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(activity, LoginActivity.class);
                activity.startActivity(intentLogin);
                activity.finish();
                dialog.dismiss();
                // logoutInterface.logoutCallBack();
            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                // logoutInterface.logoutCallBack();
            }
        });

        dialog.setCancelable(false);

        //Show Dialog
        dialog.show();


    }


    @Override
    public void dismiss() {
        dialog.dismiss();
    }


}
