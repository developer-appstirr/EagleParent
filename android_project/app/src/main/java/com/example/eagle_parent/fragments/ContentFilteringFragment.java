package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eagle_parent.R;
import com.example.eagle_parent.adapters.AllAppsAdapter;
import com.example.eagle_parent.adapters.ContentFilteringAdapter;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.models.ContentFilteringModel;

import java.util.ArrayList;

import butterknife.BindView;


public class ContentFilteringFragment extends BaseFragment {

    @BindView(R.id.rvContentFiltering)
    RecyclerView rvContentFiltering;

    ContentFilteringAdapter contentFilteringAdapter;

    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Content Filtering");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });



    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_content_filtering;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {

        ArrayList<ContentFilteringModel> contentList = new ArrayList<>();
        ContentFilteringModel contentFilteringModel = new ContentFilteringModel();
        contentFilteringModel.setFilterName("Abortion");
        contentFilteringModel.setAlert(false);
        contentFilteringModel.setAllow(true);
        contentFilteringModel.setBlock(false);

        ContentFilteringModel contentFilteringModel1 = new ContentFilteringModel();
        contentFilteringModel1.setFilterName("Adult Novelty");
        contentFilteringModel1.setAlert(true);
        contentFilteringModel1.setAllow(false);
        contentFilteringModel1.setBlock(false);

        ContentFilteringModel contentFilteringModel2 = new ContentFilteringModel();
        contentFilteringModel2.setFilterName("Anime");
        contentFilteringModel2.setAlert(false);
        contentFilteringModel2.setAllow(true);
        contentFilteringModel2.setBlock(false);

        ContentFilteringModel contentFilteringModel3 = new ContentFilteringModel();
        contentFilteringModel3.setFilterName("Death/Gore");
        contentFilteringModel3.setAlert(false);
        contentFilteringModel3.setAllow(true);
        contentFilteringModel3.setBlock(true);

        ContentFilteringModel contentFilteringModel4 = new ContentFilteringModel();
        contentFilteringModel4.setFilterName("Drugs");
        contentFilteringModel4.setAlert(false);
        contentFilteringModel4.setAllow(false);
        contentFilteringModel4.setBlock(true);

        ContentFilteringModel contentFilteringModel5 = new ContentFilteringModel();
        contentFilteringModel5.setFilterName("Gambling");
        contentFilteringModel5.setAlert(false);
        contentFilteringModel5.setAllow(true);
        contentFilteringModel5.setBlock(false);

        ContentFilteringModel contentFilteringModel6 = new ContentFilteringModel();
        contentFilteringModel6.setFilterName("Harassing");
        contentFilteringModel6.setAlert(false);
        contentFilteringModel6.setAllow(true);
        contentFilteringModel6.setBlock(false);

        ContentFilteringModel contentFilteringModel7 = new ContentFilteringModel();
        contentFilteringModel7.setFilterName("Mature Content");
        contentFilteringModel7.setAlert(false);
        contentFilteringModel7.setAllow(true);
        contentFilteringModel7.setBlock(false);

        contentList.add(contentFilteringModel);
        contentList.add(contentFilteringModel1);
        contentList.add(contentFilteringModel2);
        contentList.add(contentFilteringModel3);
        contentList.add(contentFilteringModel4);
        contentList.add(contentFilteringModel5);
        contentList.add(contentFilteringModel6);
        contentList.add(contentFilteringModel7);

        contentFilteringAdapter = new ContentFilteringAdapter(activityReference, contentList);
        rvContentFiltering.setAdapter(contentFilteringAdapter);
    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }




}

