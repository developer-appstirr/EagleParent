package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.eagle_parent.R;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.dialog.AppDialogs;

import butterknife.OnClick;


public class AboutFragment extends BaseFragment {

    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("About App");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });


    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_about_app;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {


    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }


}

