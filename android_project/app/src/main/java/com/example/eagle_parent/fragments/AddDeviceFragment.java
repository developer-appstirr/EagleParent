package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.eagle_parent.R;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.dialog.AppDialogs;

import butterknife.OnClick;


public class AddDeviceFragment extends BaseFragment {

    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Add Device");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });


    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_add_device;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {


    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }


    @OnClick({R.id.btnIos,R.id.btnAndroid})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.btnIos:
                SendDeviceEmailFragment sendDeviceEmailFragment = new SendDeviceEmailFragment();
                sendDeviceEmailFragment.setTag("ios");
                activityReference.addSupportFragment(sendDeviceEmailFragment, AppConstant.TRANSITION_TYPES.SLIDE);

                break;

            case R.id.btnAndroid:
                SendDeviceEmailFragment sendDeviceEmailFragment1 = new SendDeviceEmailFragment();
                sendDeviceEmailFragment1.setTag("android");
                activityReference.addSupportFragment(sendDeviceEmailFragment1, AppConstant.TRANSITION_TYPES.SLIDE);

                break;


            default:
                break;

        }
    }

}

