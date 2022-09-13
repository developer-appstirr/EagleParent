package com.example.eagle_parent.fragments;

import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.googlecode.mp4parser.authoring.Edit;

import butterknife.BindView;
import butterknife.OnClick;


public class SendDeviceEmailFragment extends BaseFragment {


    @BindView(R.id.etEmail)
    EditText etEmail;

    String tag;

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


    public void setTag(String tag){
        this.tag = tag;
    }
    @Override
    protected int getMainLayout() {
        return R.layout.fragment_send_device_link;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {


    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }


    @OnClick({R.id.btnSend})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.btnSend:
                    if(validate()){
                        if(tag.equals("ios")){
                            Utils.showToast(activityReference,"Child IOS app link sended to the " + etEmail.getText().toString().trim(),AppConstant.TOAST_TYPES.SUCCESS);
                            HomeFragment homeFragment = new HomeFragment();
                            activityReference.addSupportFragment(homeFragment, AppConstant.TRANSITION_TYPES.SLIDE);

                        }else {
                            Utils.showToast(activityReference,"Child Android app link sended to the " + etEmail.getText().toString().trim(),AppConstant.TOAST_TYPES.SUCCESS);
                            HomeFragment homeFragment = new HomeFragment();
                            activityReference.addSupportFragment(homeFragment, AppConstant.TRANSITION_TYPES.SLIDE);

                        }
                    }
                break;

            default:
                break;

        }
    }

    public Boolean validate(){



        if (etEmail.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.email_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }


        if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {

            Utils.showToast(activityReference,getString(R.string.email_is_not_valid), AppConstant.TOAST_TYPES.INFO);

            return false;
        }


        return true;


    }

}

