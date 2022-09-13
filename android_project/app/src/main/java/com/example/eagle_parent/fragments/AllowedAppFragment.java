package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.adapters.AlertAdapter;
import com.example.eagle_parent.adapters.AllAppsAdapter;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.listners.CheckBoxListner;
import com.example.eagle_parent.models.AppModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class AllowedAppFragment extends BaseFragment implements CheckBoxListner {

    @BindView(R.id.rvAllowedApps)
    RecyclerView rvAllowedApps;

    AllAppsAdapter allAppsAdapter;
    ArrayList<AppModel> listApp;

    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Allowed Apps");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });

        titleBar.showRightCheckAllAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MonitoringControlsFragment monitoringControlsFragment = new MonitoringControlsFragment();
                monitoringControlsFragment.setListApp(listApp);
                activityReference.addSupportFragment(monitoringControlsFragment, AppConstant.TRANSITION_TYPES.SLIDE);
            }
        });


    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_allowed_app;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {

        listApp = new ArrayList<>();

        AppModel appModel = new AppModel();
        appModel.setName("Facebook");
        appModel.setIcon(R.drawable.facebook);
        appModel.setId(1);
        appModel.setSelected(false);

        AppModel appModel1 = new AppModel();
        appModel1.setName("Twitter");
        appModel1.setIcon(R.drawable.twitter);
        appModel1.setId(2);
        appModel1.setSelected(false);

        AppModel appModel2 = new AppModel();
        appModel2.setName("Instagram");
        appModel2.setIcon(R.drawable.insta);
        appModel2.setId(3);
        appModel2.setSelected(false);

        listApp.add(appModel);
        listApp.add(appModel1);
        listApp.add(appModel2);

        allAppsAdapter = new AllAppsAdapter(activityReference,listApp,AllowedAppFragment.this);
        rvAllowedApps.setAdapter(allAppsAdapter);
    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }


    @Override
    public void setListApp(ArrayList<AppModel> listApp) {
        this.listApp = listApp;
    }
}

