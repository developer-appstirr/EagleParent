package com.example.eagle_parent.activities.LoginFlow;

import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.activities.BaseActivity;
import com.example.eagle_parent.activities.HomeActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.helpers.preference.BasePreferenceHelper;
import com.example.eagle_parent.models.User;

import butterknife.BindView;
import butterknife.OnClick;


public class RegisterActivity extends BaseActivity {

    @BindView(R.id.etFullName)
    EditText etFullName;

    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPhone)
    EditText etPhone;

    @BindView(R.id.etConfirmPassword)
    EditText etConfirmPassword;

    @BindView(R.id.etPassword)
    EditText etPassword;


    public BasePreferenceHelper preferenceHelper;

    @Override
    public int getMainLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onViewReady() {
        preferenceHelper = this.prefHelper;
    }

    @Override
    public int getFragmentFrameLayoutId() {
        return 0;
    }

    @Override
    public TitleBar getTitleBar() {
        return null;
    }

    @OnClick({R.id.btnCreate,R.id.txtSignIn})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnCreate:

                    if (validate()) {
                        Intent intent = new Intent(RegisterActivity.this, HomeActivity.class);
                        Utils.showToast(this,"Registered Successfully",AppConstant.TOAST_TYPES.SUCCESS);
                        User user = new User();
                        user.setEmailAddress(etEmail.toString());
                        user.setFullName(etFullName.toString());
                        user.setPhoneNumber(etPhone.toString());
                        preferenceHelper.setLoginStatus(true);
                        preferenceHelper.putUser(user);
                        startActivity(intent);
                        finish();

                }
                break;



            case R.id.txtSignIn:
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                break;

            default:


        }
    }

    public Boolean validate(){

        if (etFullName.getText().toString().isEmpty()){

            Utils.showToast(this,getString(R.string.fullName_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (etEmail.getText().toString().isEmpty()){

            Utils.showToast(this,getString(R.string.email_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {

            Utils.showToast(this,getString(R.string.email_is_not_valid), AppConstant.TOAST_TYPES.INFO);

            return false;
        }

        if (etPhone.getText().toString().isEmpty()){

            Utils.showToast(this,getString(R.string.phone_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }


        if (etPassword.getText().toString().isEmpty()){

            Utils.showToast(this,getString(R.string.password_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (etConfirmPassword.getText().toString().isEmpty()){

            Utils.showToast(this,getString(R.string.is_empty_confirm_password), AppConstant.TOAST_TYPES.INFO);

            return false;

        }


        if (!etPassword.getText().toString().equals(etConfirmPassword.getText().toString())){

            Utils.showToast(this,getString(R.string.is_confrim_password_match), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        return true;


    }


}