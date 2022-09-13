package com.example.eagle_parent.activities;


import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.eagle_parent.R;
import com.example.eagle_parent.activities.LoginFlow.ForgetPasswordActivity;
import com.example.eagle_parent.activities.LoginFlow.LoginActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.fragments.AboutFragment;
import com.example.eagle_parent.fragments.AllAlertFragment;
import com.example.eagle_parent.fragments.ContentFilteringFragment;
import com.example.eagle_parent.fragments.FilterAlertFragment;
import com.example.eagle_parent.fragments.HomeFragment;
import com.example.eagle_parent.fragments.ProfileFragment;
import com.example.eagle_parent.fragments.ScreenTimeFragment;
import com.example.eagle_parent.fragments.SettingFragment;
import com.example.eagle_parent.helpers.preference.BasePreferenceHelper;
import com.google.android.material.navigation.NavigationView;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class HomeActivity extends BaseActivity {


    @BindView(R.id.fragmentContainer)
    FrameLayout fragmentContainer;
    @BindView(R.id.mTitleBar)
    TitleBar mTitleBar;


    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    TextView tvName ;
    TextView tvEmail;
    CircleImageView imvProfile;


    private ActionBarDrawerToggle toggle;
    public BasePreferenceHelper preferenceHelper;



    @Override
    public int getMainLayoutId() {
        return R.layout.activity_drawer;
    }

    @Override
    public int getFragmentFrameLayoutId() {
        return R.id.fragmentContainer;
    }

    @Override
    public TitleBar getTitleBar() {
        return mTitleBar;
    }


    @Override
    protected void onViewReady() {

       setAndBindTitleBar();


        preferenceHelper = this.prefHelper;


        View hView =   navigationView.getHeaderView(0);
        imvProfile = (CircleImageView)hView.findViewById(R.id.imgAvatar);
        tvName = hView.findViewById(R.id.nav_header_userName);
        tvEmail = hView.findViewById(R.id.nav_header_userEmail);
       // ImageView selectImage = (ImageView)hView.findViewById(R.id.selectImage);


        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment profileFragment = new ProfileFragment();
                addSupportFragment(profileFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);
            }
        });


        imvProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragment profileFragment = new ProfileFragment();
                addSupportFragment(profileFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);

            }
        });



        replaceSupportFragment(new HomeFragment(), AppConstant.TRANSITION_TYPES.SLIDE);


    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }

    public void openDrawer() {
        drawer.openDrawer(GravityCompat.START);
    }

    public void closeDrawer() {
        drawer.closeDrawers();
    }



    @OnClick({R.id.llScreenTime,R.id.llNotifications,R.id.llHome,R.id.llAlerts,R.id.llMyProfile,R.id.llAbout,R.id.llSettings,R.id.llContentFiltering,R.id.llSignOut})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.llNotifications:
               // drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.llHome:
                HomeFragment homeFragment = new HomeFragment();
                addSupportFragment(homeFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);
                break;


            case R.id.llScreenTime:
                ScreenTimeFragment screenTimeFragment = new ScreenTimeFragment();
                addSupportFragment(screenTimeFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.llAlerts:
                AllAlertFragment allAlertFragment = new AllAlertFragment();
                addSupportFragment(allAlertFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.llMyProfile:
                ProfileFragment profileFragment = new ProfileFragment();
                addSupportFragment(profileFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.llAbout:
                AboutFragment aboutFragment = new AboutFragment();
                addSupportFragment(aboutFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.llSettings:
                SettingFragment settingFragment = new SettingFragment();
                addSupportFragment(settingFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.llContentFiltering:
                ContentFilteringFragment contentFilteringFragment = new ContentFilteringFragment();
                addSupportFragment(contentFilteringFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                drawer.closeDrawer(GravityCompat.START);
                break;

            case R.id.llSignOut:
                preferenceHelper.removeLoginPreference();
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;



            default:
                break;

        }
    }

    private void setAndBindTitleBar() {
        mTitleBar.setVisibility(View.VISIBLE);
    }


    public Fragment isFragmentPresent(String tag) {
        Fragment frag = getSupportFragmentManager().findFragmentByTag(tag);
        if (frag != null) {
            return frag;
        } else
            return null;
    }




}
