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
import com.example.eagle_parent.models.AlertModel;


import java.util.ArrayList;

import butterknife.BindView;

public class FilterAlertFragment extends  BaseFragment{

    @BindView(R.id.rvAlertFilter)
    RecyclerView rvAlertFilter;

    AlertAdapter alertAdapter;

    ArrayList<AlertModel> alertList;
    String category;



    @Override
    protected void setTitleBar(TitleBar titleBar) {

    }


    public void setCategory(String category){
        this.category = category;
    }


    @Override
    protected int getMainLayout() {

        return R.layout.fragment_alert_filter;
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

        ArrayList<AlertModel> filterList = new ArrayList<>();
        for (int i=0;i<alertList.size();i++){
            if(alertList.get(i).getThreatCategory().equals(category)){
                filterList.add(alertList.get(i));
            }
            if("All".equals(category)){
                filterList.add(alertList.get(i));
            }

        }

        alertAdapter = new AlertAdapter(activityReference, filterList);
        rvAlertFilter.setAdapter(alertAdapter);




    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();
    }



}
