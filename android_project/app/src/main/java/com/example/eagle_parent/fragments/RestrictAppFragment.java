package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.adapters.AllAppsAdapter;
import com.example.eagle_parent.adapters.MyAppsAdapter;
import com.example.eagle_parent.adapters.MyWebExcemptionsAdapter;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.dialog.AppDialogs;
import com.example.eagle_parent.listners.WebsiteExemptionsListner;
import com.example.eagle_parent.models.AppModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;


public class RestrictAppFragment extends BaseFragment implements WebsiteExemptionsListner {

    @BindView(R.id.rvMyApps)
    RecyclerView rvMyApps;

    @BindView(R.id.rvWeb)
    RecyclerView rvWeb;

    MyAppsAdapter myAppsAdapter;
    MyWebExcemptionsAdapter myWebExcemptionsAdapter;

    ArrayList<String> webList;



    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Web Exceptions");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });




    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_web_exceptions;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {


        ArrayList<AppModel> listApp = new ArrayList<>();

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

        webList = new ArrayList<>();
        myAppsAdapter = new MyAppsAdapter(activityReference, listApp);
        rvMyApps.setAdapter(myAppsAdapter);

        myWebExcemptionsAdapter = new MyWebExcemptionsAdapter(activityReference, webList);
        rvWeb.setAdapter(myWebExcemptionsAdapter);
    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }



    @OnClick({R.id.btnAddWebException})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.btnAddWebException:

                AppDialogs dialogs = new AppDialogs();
                dialogs.showWebSiteExemptionDialog(activityReference,RestrictAppFragment.this);


                break;


            default:
                break;

        }
    }


    @Override
    public void setWebsiteUrl(String websiteUrl) {
        webList.add(websiteUrl);
        myWebExcemptionsAdapter.notifyDataSetChanged();

    }
}

