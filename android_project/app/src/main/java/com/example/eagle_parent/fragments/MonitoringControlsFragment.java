package com.example.eagle_parent.fragments;

import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.listners.EndTimePickerListner;
import com.example.eagle_parent.listners.StartTimePickerListner;
import com.example.eagle_parent.models.AppModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class MonitoringControlsFragment extends BaseFragment implements StartTimePickerListner, EndTimePickerListner {

    @BindView(R.id.txtToTime)
    TextView txtToTime;
    @BindView(R.id.txtFromTime)
    TextView txtFromTime;

    @BindView(R.id.txtAllowedApps)
    TextView txtAllowedApps;

    ArrayList<AppModel> listApp;

    void setListApp(ArrayList<AppModel> listApp){
        this.listApp = listApp;
    }

    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Monitoring Controls");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });


    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_monitoring_controls;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {

        if(listApp!=null){
            if (listApp.size() > 0) {
                txtAllowedApps.setText(listApp.size() + " Selected");
            }
        }

    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @OnClick({R.id.txtFromTime,R.id.txtToTime,R.id.btnFinishSetup,R.id.llAllowedApps,R.id.llRestrictApps})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.txtFromTime:
                startTimePicker();
                break;

            case R.id.txtToTime:
                endTimePicker();
                break;

            case R.id.llAllowedApps:
                AllowedAppFragment allowedAppFragment = new AllowedAppFragment();
                activityReference.addSupportFragment(allowedAppFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                break;

            case R.id.llRestrictApps:
                RestrictAppFragment restrictAppFragment = new RestrictAppFragment();
                activityReference.addSupportFragment(restrictAppFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                break;



            case R.id.btnFinishSetup:
                if(validate())
                activityReference.changeToHomeFragment(new HomeFragment());
                break;


            default:
                break;

        }
    }

    public Boolean validate(){

        if (txtFromTime.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.start_time_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (txtToTime.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.end_time_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }



        return true;


    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startTimePicker(){

        Utils.StartTimePicker(getFragmentManager(),MonitoringControlsFragment.this);

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void endTimePicker(){

        Utils.EndTimePicker(getFragmentManager(),MonitoringControlsFragment.this);

    }

    @Override
    public void setEndTime(String time) {

        txtToTime.setText(time);
    }

    @Override
    public void setStartTime(String time) {

        txtFromTime.setText(time);
    }
}

