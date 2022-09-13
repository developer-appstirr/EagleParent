package com.example.eagle_parent.fragments;

import android.Manifest;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.adapters.AlertAdapter;
import com.example.eagle_parent.adapters.AppsAdapter;
import com.example.eagle_parent.adapters.ChildAdapter;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.models.ChildModel;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;


public class HomeFragment extends BaseFragment {


    @BindView(R.id.rvChildProfile)
    RecyclerView rvChildProfile;

    @BindView(R.id.chipGroup)
    ChipGroup chipGroup;

    @BindView(R.id.flContainer)
    FrameLayout flContainer;

    ChildAdapter childAdapter;

    @BindView(R.id.txtNoResults)
    TextView txtNoResults;

    @BindView(R.id.llHomePanel)
    LinearLayout llHomePanel;

    @BindView(R.id.llAlerts)
    LinearLayout llAlerts;


    @BindView(R.id.txtChildName)
    TextView txtChildName;

    @BindView(R.id.ivChildProfile)
    CircleImageView ivChildProfile;

    @BindView(R.id.llProtectedDevice)
    LinearLayout llProtectedDevice;

    @BindView(R.id.imgHideMonitor)
    ImageView imgHideMonitorApp;

    @BindView(R.id.imgHideScreenTime)
    ImageView imgHideScreenTime;

    @BindView(R.id.graph)
    ImageView graph;

    boolean toggleMonitor = true;
    boolean toggleScreen= true;

    @BindView(R.id.btnTotalActivities)
    Button btnTotalActivities;

    @BindView(R.id.btnDisconnect)
    Button btnDisconnect;

    ArrayList<ChildModel> childList = new ArrayList<>();
    ChildModel childModel;

    boolean isConnected = true;

    public void setCategoryChips(ArrayList<String> categorys) {
        for (String category : categorys) {
            Chip mChip = (Chip) this.getLayoutInflater().inflate(R.layout.item_chip, null, false);
//            if (category.equals("All")){
//               // mChip.setActivated(true);
//                //mChip.setCheckable(true);
//
//                FilterAlertFragment filterAlertFragment = new FilterAlertFragment();
//                filterAlertFragment.setCategory("All");
//                activityReference.replaceSupportFragmentWithContainer(R.id.flContainer,filterAlertFragment, AppConstant.TRANSITION_TYPES.SLIDE);
//
//            }


//            else {
//                mChip.setSelected(false);
//            }


            mChip.setText(category);
            int paddingDp = (int) TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP, 10,
                    getResources().getDisplayMetrics()
            );
            mChip.setPadding(paddingDp, 0, paddingDp, 0);
            mChip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FilterAlertFragment filterAlertFragment = new FilterAlertFragment();
                    filterAlertFragment.setCategory(category);
                    activityReference.replaceSupportFragmentWithContainer(R.id.flContainer,filterAlertFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                }
            });
            chipGroup.addView(mChip);
        }
    }

    @Override
    protected void setTitleBar(TitleBar titleBar) {

        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Welcome To Eagle,");


        titleBar.showLeftNavigationIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(getHomeActivity() != null){
                    getHomeActivity().openDrawer();
                }

            }
        });

        titleBar.showRightNotificationAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationFragment notificationFragment = new NotificationFragment();
                activityReference.addSupportFragment(notificationFragment, AppConstant.TRANSITION_TYPES.SLIDE);
            }
        });
    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_home;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {



        if (childList != null) {
            if (childList.size() > 0) {
                childAdapter = new ChildAdapter(activityReference, childList);
                rvChildProfile.setAdapter(childAdapter);
                rvChildProfile.setVisibility(View.VISIBLE);
                llHomePanel.setVisibility(View.VISIBLE);
                txtNoResults.setVisibility(View.GONE);
            } else {
                rvChildProfile.setVisibility(View.GONE);
                llHomePanel.setVisibility(View.GONE);
                txtNoResults.setVisibility(View.VISIBLE);
            }

        }

        if(childModel!=null){
            Glide.with(activityReference).load(childModel.getImage()).into(ivChildProfile);
            txtChildName.setText(childModel.getFirstName());
        }



        ArrayList<String> category = new ArrayList<>();
        category.add("All");
        category.add("Harassing");
        category.add("Suicidal");
        category.add("Sexual Content");
        category.add("Drugs");
        category.add("Mature Content");


        setCategoryChips(category);
//
//        CriticalAlertFragment criticalAlertFragment = new CriticalAlertFragment();
//        activityReference.replaceSupportFragmentWithContainer(R.id.flContainer,criticalAlertFragment, AppConstant.TRANSITION_TYPES.SLIDE);
//
//        llCritical.setBackgroundColor(activityReference.getResources().getColor(R.color.red));
//        txtCritical.setTextColor(activityReference.getResources().getColor(R.color.white));


    }

    @Override
    public void onCustomBackPressed() {
        FragmentManager fragmentManager = activityReference.getSupportFragmentManager();
        //this will clear the back stack and displays no animation on the screen
        fragmentManager.popBackStackImmediate(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        activityReference.onPageBack();

    }

    public void setChildList(ChildModel childModel){
       childList.add(childModel);
       this.childModel = childModel;
    }


    @OnClick({R.id.llAlerts,R.id.btnAddChild,R.id.ivSettings,R.id.btnAddDevice,R.id.btnDisconnect,R.id.llProtectedDevice,R.id.ivLocation,R.id.llHideMonitorApp,R.id.llHideScreenTime})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.llAlerts:
                AllAlertFragment allAlertFragment = new AllAlertFragment();
                activityReference.addSupportFragment(allAlertFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                break;

            case R.id.llHideMonitorApp:

                if(toggleMonitor) {
                    toggleMonitor = false;
                    imgHideMonitorApp.setRotation(90);
                    flContainer.setVisibility(View.GONE);
                    chipGroup.setVisibility(View.GONE);
                }else{
                    toggleMonitor = true;
                    imgHideMonitorApp.setRotation(-90);
                    flContainer.setVisibility(View.VISIBLE);
                    chipGroup.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.llHideScreenTime:

                if(toggleScreen) {
                    toggleScreen =false;
                    imgHideScreenTime.setRotation(90);
                    btnTotalActivities.setVisibility(View.GONE);
                    graph.setVisibility(View.GONE);
                }else{
                    imgHideScreenTime.setRotation(-90);
                    toggleScreen = true;
                    btnTotalActivities.setVisibility(View.VISIBLE);
                    graph.setVisibility(View.VISIBLE);
                }
                break;

            case R.id.ivLocation:

                TedPermission.with(activityReference)
                        .setPermissions(Manifest.permission.ACCESS_COARSE_LOCATION,Manifest.permission.ACCESS_FINE_LOCATION)
                        .setPermissionListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted() {
                                MapFragment mapFragment = new MapFragment();
                                activityReference.addSupportFragment(mapFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                            }

                            @Override
                            public void onPermissionDenied(List<String> deniedPermissions) {
                                Toasty.warning(activityReference, activityReference.getString(R.string.permission_denied), Toast.LENGTH_SHORT).show();
                            }

                        }).check();

                break;

            case R.id.llProtectedDevice:
                ProtectedDeviceFragment protectedDeviceFragment = new ProtectedDeviceFragment();
                activityReference.addSupportFragment(protectedDeviceFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                break;

            case R.id.btnAddChild:
               AddChildFragment addChildFragment = new AddChildFragment();
                activityReference.addSupportFragment(addChildFragment, AppConstant.TRANSITION_TYPES.SLIDE);

                break;

            case R.id.ivSettings:
                MonitoringControlsFragment monitoringControlsFragment = new MonitoringControlsFragment();
                activityReference.addSupportFragment(monitoringControlsFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                break;

            case R.id.btnAddDevice:
                AddDeviceFragment addDeviceFragment = new AddDeviceFragment();
                activityReference.addSupportFragment(addDeviceFragment, AppConstant.TRANSITION_TYPES.SLIDE);

                break;

            case R.id.btnDisconnect:
                if(isConnected){
                    isConnected=false;
                    btnDisconnect.setBackgroundColor(activityReference.getResources().getColor(R.color.red));
                    btnDisconnect.setText("Disconnected");
                    Utils.showToast(activityReference,"Internet Disconnected",AppConstant.TOAST_TYPES.SUCCESS);
                }else {
                    isConnected=true;
                    btnDisconnect.setBackgroundColor(activityReference.getResources().getColor(R.color.green));
                    btnDisconnect.setText("Connected");
                    Utils.showToast(activityReference,"Internet Connected",AppConstant.TOAST_TYPES.SUCCESS);
                }

                break;

//            case R.id.llReviewed:
//
//                ReviewedAlertFragment reviewedAlertFragment = new ReviewedAlertFragment();
//                activityReference.replaceSupportFragmentWithContainer(R.id.flContainer,reviewedAlertFragment, AppConstant.TRANSITION_TYPES.SLIDE);
//
//                llReviewed.setBackgroundColor(activityReference.getResources().getColor(R.color.green));
//                txtReviewed.setTextColor(activityReference.getResources().getColor(R.color.white));
//
//                llCritical.setBackgroundColor(activityReference.getResources().getColor(R.color.white));
//                txtCritical.setTextColor(activityReference.getResources().getColor(R.color.black));
//
//                llNeedsReview.setBackgroundColor(activityReference.getResources().getColor(R.color.white));
//                txtNeedsReview.setTextColor(activityReference.getResources().getColor(R.color.black));
//
//                break;
//
//            case R.id.llCritical:
//                CriticalAlertFragment criticalAlertFragment = new CriticalAlertFragment();
//                activityReference.replaceSupportFragmentWithContainer(R.id.flContainer,criticalAlertFragment, AppConstant.TRANSITION_TYPES.SLIDE);
//
//                llCritical.setBackgroundColor(activityReference.getResources().getColor(R.color.red));
//                txtCritical.setTextColor(activityReference.getResources().getColor(R.color.white));
//
//                llReviewed.setBackgroundColor(activityReference.getResources().getColor(R.color.white));
//                txtReviewed.setTextColor(activityReference.getResources().getColor(R.color.black));
//
//                llNeedsReview.setBackgroundColor(activityReference.getResources().getColor(R.color.white));
//                txtNeedsReview.setTextColor(activityReference.getResources().getColor(R.color.black));
//                break;
//
//            case R.id.llNeedsReview:
//                NeedsReviewAlertFragment needsReviewAlertFragment = new NeedsReviewAlertFragment();
//                activityReference.replaceSupportFragmentWithContainer(R.id.flContainer,needsReviewAlertFragment, AppConstant.TRANSITION_TYPES.SLIDE);
//
//                llNeedsReview.setBackgroundColor(activityReference.getResources().getColor(R.color.primaryBlue));
//                txtNeedsReview.setTextColor(activityReference.getResources().getColor(R.color.white));
//
//                llCritical.setBackgroundColor(activityReference.getResources().getColor(R.color.white));
//                txtCritical.setTextColor(activityReference.getResources().getColor(R.color.black));
//
//                llReviewed.setBackgroundColor(activityReference.getResources().getColor(R.color.white));
//                txtReviewed.setTextColor(activityReference.getResources().getColor(R.color.black));
//                break;


            default:
                break;

        }
    }

}

