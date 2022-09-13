package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.adapters.AlertAdapter;
import com.example.eagle_parent.customViews.TitleBar;

import butterknife.BindView;

public class NeedsReviewAlertFragment extends  BaseFragment{

    @BindView(R.id.rvAlertNeedsReview)
    RecyclerView rvAlertNeedsReview;

    AlertAdapter alertAdapter;

    LinearLayoutManager layoutManager;




    @Override
    protected void setTitleBar(TitleBar titleBar) {


//        titleBar.showHeaderView();
//        titleBar.showHeaderTitle("Booking History");
//        titleBar.showHeaderTitle(Gravity.CENTER);
//        titleBar.showLeftIconAndListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                activityReference.onBackPressed();
//            }
//        });
//
//        titleBar.showRightMessageIconAndSetListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MessageFragment messageFragment = new MessageFragment();
//                activityReference.addSupportFragment(messageFragment, AppConstant.TRANSITION_TYPES.SLIDE);
//
//            }
//        });

    }




    @Override
    protected int getMainLayout() {

        return R.layout.fragment_alert_needs_review;
    }

    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {


        layoutManager = new LinearLayoutManager(activityReference, LinearLayoutManager.VERTICAL, false);

        rvAlertNeedsReview.setLayoutManager(layoutManager);
        alertAdapter = new AlertAdapter(activityReference, null);
        rvAlertNeedsReview.setAdapter(alertAdapter);


    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();
    }



}
