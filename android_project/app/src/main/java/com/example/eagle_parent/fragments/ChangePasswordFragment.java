package com.example.eagle_parent.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePasswordFragment extends BaseFragment{

    @BindView(R.id.etNewPassword)
    EditText etNewPassword;

    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;

    @BindView(R.id.etOldPassword)
    EditText etOldPassword;

    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Change Password");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });


    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_change_password;
    }

    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {

    }

    @Override
    public void onCustomBackPressed() {
        activityReference.onPageBack();

    }

    @OnClick({R.id.btnUpdate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnUpdate:
                if (validate()) {

                    Utils.showToast(activityReference,"Password has been changed successfully", AppConstant.TOAST_TYPES.SUCCESS);
                    HomeFragment homeFragment = new HomeFragment();
                    activityReference.addSupportFragment(homeFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                }
                break;


            default:
                break;
        }
    }


    public Boolean validate(){

        if (etOldPassword.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.is_empty_old_password), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (etNewPassword.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.is_empty_new_password), AppConstant.TOAST_TYPES.INFO);

            return false;

        }



        if (etConfirmPassword.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.is_empty_confirm_password), AppConstant.TOAST_TYPES.INFO);

            return false;

        }


        if (!etNewPassword.getText().toString().equals(etConfirmPassword.getText().toString())){

            Utils.showToast(activityReference,getString(R.string.is_confrim_password_match), AppConstant.TOAST_TYPES.INFO);

            return false;

        }


        return true;


    }
}
