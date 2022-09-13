package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.adapters.AlertAdapter;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.models.AlertModel;

import java.util.ArrayList;

import butterknife.BindView;

public class AllAlertFragment extends  BaseFragment{

    @BindView(R.id.rvAlertFilter)
    RecyclerView rvAlertFilter;

    AlertAdapter alertAdapter;


    ArrayList<AlertModel> alertList;


    @Override
    protected void setTitleBar(TitleBar titleBar) {

        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Alerts");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });


    }




    @Override
    protected int getMainLayout() {

        return R.layout.fragment_alert;
    }

    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {


        alertList = new ArrayList<>();
        AlertModel alertModel = new AlertModel();
        alertModel.setAppLogo(R.drawable.facebook);
        alertModel.setAppName("Facebook");
        alertModel.setBlockApp(false);
        alertModel.setDate("August 01,2021");
        alertModel.setOffenderImg(R.drawable.profile);
        alertModel.setOffenderName("Sara");
        alertModel.setOffenderDescription("You have a ugly face, Just Die.");
        alertModel.setOffenderLink("https://www.facebook.com/sara/0211311");
        alertModel.setSeverityLevel("High");
        alertModel.setBlockApp(false);
        alertModel.setWifiOn(true);
        alertModel.setThreatCategory("Suicidal");

        AlertModel alertModel1 = new AlertModel();
        alertModel1.setAppLogo(R.drawable.chrome);
        alertModel1.setAppName("Google Chrome");
        alertModel1.setBlockApp(false);
        alertModel1.setDate("August 03,2021");
        alertModel1.setOffenderImg(R.drawable.profile);
        alertModel1.setOffenderName("Alexa");
        alertModel1.setOffenderLink("https://www.xyzporn.com/");
        alertModel1.setSeverityLevel("High");
        alertModel1.setBlockApp(false);
        alertModel1.setWifiOn(true);
        alertModel1.setThreatCategory("Sexual Content");



        alertList.add(alertModel);
        alertList.add(alertModel1);


        alertAdapter = new AlertAdapter(activityReference, alertList);
        rvAlertFilter.setAdapter(alertAdapter);


    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();
    }



}
