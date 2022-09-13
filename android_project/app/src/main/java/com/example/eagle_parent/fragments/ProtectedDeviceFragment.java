package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.adapters.AlertAdapter;
import com.example.eagle_parent.adapters.ProtectedDeviceAdapter;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.models.ProtectedDeviceModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class ProtectedDeviceFragment extends BaseFragment {

    @BindView(R.id.rvProtectedDevice)
    RecyclerView rvProtectedDevice;

    ProtectedDeviceAdapter protectedDeviceAdapter;

    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Protected Devices");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });


    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_protected_device;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {

        ArrayList<ProtectedDeviceModel> deviceList = new ArrayList<>();

        ProtectedDeviceModel protectedDeviceModel = new ProtectedDeviceModel();
        protectedDeviceModel.setTitle("Iphone 12");
        protectedDeviceModel.setScreenTime("10:00 pm - 7:00 am");
        protectedDeviceModel.setBlockAlerts("12");
        protectedDeviceModel.setReviewedAlerts("03");
        protectedDeviceModel.setActivitiesCount("200 activities in last 7 days");


        ProtectedDeviceModel protectedDeviceModel1 = new ProtectedDeviceModel();
        protectedDeviceModel1.setTitle("Samsung Galaxy s21");
        protectedDeviceModel1.setScreenTime("9:00 pm - 18:00 am");
        protectedDeviceModel1.setBlockAlerts("34");
        protectedDeviceModel1.setReviewedAlerts("10");
        protectedDeviceModel1.setActivitiesCount("430 activities in last 15 days");

        ProtectedDeviceModel protectedDeviceModel2 = new ProtectedDeviceModel();
        protectedDeviceModel2.setTitle("John's Tablet");
        protectedDeviceModel2.setScreenTime("5:00 pm - 12:00 pm");
        protectedDeviceModel2.setBlockAlerts("14");
        protectedDeviceModel2.setReviewedAlerts("02");
        protectedDeviceModel2.setActivitiesCount("80 activities in last 5 days");

        deviceList.add(protectedDeviceModel);
        deviceList.add(protectedDeviceModel1);
        deviceList.add(protectedDeviceModel2);


        protectedDeviceAdapter = new ProtectedDeviceAdapter(activityReference, deviceList);
        rvProtectedDevice.setAdapter(protectedDeviceAdapter);

    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }




}

