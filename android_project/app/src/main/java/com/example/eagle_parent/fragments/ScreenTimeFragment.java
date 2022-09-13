package com.example.eagle_parent.fragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.adapters.ContentFilteringAdapter;
import com.example.eagle_parent.adapters.ScreenTimeAdapter;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.dialog.AppDialogs;
import com.example.eagle_parent.listners.ScreenTimeListner;
import com.example.eagle_parent.models.AppModel;
import com.example.eagle_parent.models.ScreenTimeModel;

import java.util.ArrayList;

import butterknife.BindView;


public class ScreenTimeFragment extends BaseFragment implements ScreenTimeListner {

    @BindView(R.id.rvScreenTime)
    RecyclerView rvScreenTime;

    ScreenTimeAdapter screenTimeAdapter;

    ArrayList<ScreenTimeModel> screenTimeList;

    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Screen Time");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });

        titleBar.showRightAddIconAndListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                AppDialogs dialogs = new AppDialogs();
                dialogs.showScreenTimeDialog(activityReference,getChildFragmentManager(),ScreenTimeFragment.this);


            }
        });


    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_screen_time;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {

        screenTimeList = new ArrayList<>();

       ScreenTimeModel screenTimeModel = new ScreenTimeModel();
       screenTimeModel.setActive(true);
       screenTimeModel.setScreenName("Default");
       screenTimeModel.setStartTime("06:00 AM");
       screenTimeModel.setEndTime("09:00 PM");
       screenTimeList.add(screenTimeModel);

        screenTimeAdapter = new ScreenTimeAdapter(activityReference, screenTimeList);
        rvScreenTime.setAdapter(screenTimeAdapter);
    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }


    @Override
    public void setScreenTime(ScreenTimeModel screenTimeModel) {
        screenTimeList.add(screenTimeModel);
        screenTimeAdapter.notifyDataSetChanged();
    }
}

