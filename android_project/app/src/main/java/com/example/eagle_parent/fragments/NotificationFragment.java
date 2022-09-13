package com.example.eagle_parent.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.adapters.NotificationAdapter;
import com.example.eagle_parent.customViews.TitleBar;

import butterknife.BindView;

public class NotificationFragment extends BaseFragment {


    NotificationAdapter notificationAdapter;
    @BindView(R.id.rvNotification)
    RecyclerView rvNotification;

    @BindView(R.id.txtNoResult)
    TextView txtNoResult;


    @Override
    protected void setTitleBar(TitleBar titleBar) {

        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Notifications");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });
    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_notification;
    }

    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onCustomBackPressed() {
        activityReference.onPageBack();
    }
}