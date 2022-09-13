package com.example.eagle_parent.Utils;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentManager;

import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.R;
import com.example.eagle_parent.listners.DateListner;
import com.example.eagle_parent.listners.EndTimePickerListner;
import com.example.eagle_parent.listners.StartTimePickerListner;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;

import java.io.IOException;
import java.time.LocalDateTime;

import es.dmoral.toasty.Toasty;


public class Utils {

    public int selectedHour = 0;
    public int selectedMinute = 0;


    public static Bitmap ResizeMapIcon(Context ctx){
        int height = 140;
        int width = 140;
        BitmapDrawable bitmapdraw = (BitmapDrawable)ctx.getResources().getDrawable(R.drawable.profile);
        Bitmap b = bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        return smallMarker;
    }

    public static Drawable tintMyDrawable(Drawable drawable, int color) {
        drawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTint(drawable, color);
        DrawableCompat.setTintMode(drawable, PorterDuff.Mode.SRC_IN);
        return drawable;
    }


    public static boolean isEmptyOrNull(String string) {
        if (string == null)
            return true;

        return (string.trim().length() <= 0);
    }


    public static class NoConnectivityException extends IOException {

        @Override
        public String getMessage() {
            return "No Internet Connection";
            // You can send any message whatever you want from here.
        }
    }


    public static void datePicker(FragmentManager fragmentManager, DateListner dateListner){
        MaterialDatePicker.Builder materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("SELECT DATE");
        final MaterialDatePicker materialDatePicker = materialDateBuilder.build();

        materialDatePicker.show(fragmentManager, "MATERIAL_DATE_PICKER");


        materialDatePicker.addOnPositiveButtonClickListener(
                new MaterialPickerOnPositiveButtonClickListener() {
                    @Override
                    public void onPositiveButtonClick(Object selection) {
                        dateListner.setDate(materialDatePicker.getHeaderText());
                        //  tvPolicyDate.setText(materialDatePicker.getHeaderText());
                    }
                });

    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void StartTimePicker(FragmentManager fragmentManager, StartTimePickerListner startTimePickerListner){
        int isSystem24Hour = TimeFormat.CLOCK_24H;
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();

        MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(isSystem24Hour)
                .setHour(hour)
                .setMinute(minute)
                .setTitleText("Select Start Time")
                .build();
        materialTimePicker.show(fragmentManager, "MATERIAL_TIME_PICKER");

        materialTimePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hour = null;
                String min = null;

                if(materialTimePicker.getHour()<10){
                    hour = "0"+materialTimePicker.getHour();
                }else {
                    hour= String.valueOf(materialTimePicker.getHour());
                }

                if(materialTimePicker.getMinute() < 10){
                    min = "0"+materialTimePicker.getMinute();
                }else{
                    min =  String.valueOf(materialTimePicker.getMinute());
                }
                startTimePickerListner.setStartTime( hour + ":" + min);
            }
        });
        materialTimePicker.addOnNegativeButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void EndTimePicker(FragmentManager fragmentManager, EndTimePickerListner endTimePickerListner){
        int isSystem24Hour = TimeFormat.CLOCK_24H;
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(isSystem24Hour)
                .setHour(hour)
                .setMinute(minute)
                .setTitleText("Select End Time")
                .build();

        materialTimePicker.show(fragmentManager, "MATERIAL_TIME_PICKER");

        materialTimePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String hour = null;
                String min = null;

                if(materialTimePicker.getHour()<10){
                    hour = "0"+materialTimePicker.getHour();
                }else {
                    hour= String.valueOf(materialTimePicker.getHour());
                }

                if(materialTimePicker.getMinute() < 10){
                    min = "0"+materialTimePicker.getMinute();
                }else{
                    min =  String.valueOf(materialTimePicker.getMinute());
                }
                endTimePickerListner.setEndTime( hour + ":" + min);
            }
        });
        materialTimePicker.addOnNegativeButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }


    public static void showToast(Context ctx, String msg, int type) {

        switch (type){
            case AppConstant.TOAST_TYPES.INFO:
                Toasty.custom(ctx, msg, R.drawable.ic_error, R.color.golden,  Toast.LENGTH_SHORT,true,true).show();
                break;

            case AppConstant.TOAST_TYPES.ERROR:
                Toasty.custom(ctx, msg, R.drawable.ic_error, R.color.red,  Toast.LENGTH_SHORT,true,true).show();
                break;

            case AppConstant.TOAST_TYPES.SUCCESS:
                Toasty.custom(ctx, msg, R.drawable.ic_check, R.color.primaryBlue,  Toast.LENGTH_SHORT,true,true).show();
               // Toasty.success(ctx, msg,).show();
                break;

        }
    }


}
