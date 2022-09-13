package com.example.eagle_parent.activities.LoginFlow;

import android.content.Intent;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.example.eagle_parent.activities.BaseActivity;
import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.activities.HomeActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.helpers.preference.BasePreferenceHelper;
import com.example.eagle_parent.models.User;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity {


    @BindView(R.id.etEmail)
    EditText etEmail;

    @BindView(R.id.etPassword)
    EditText etPassword;


    public BasePreferenceHelper preferenceHelper;

    @Override
    public int getMainLayoutId() {
        return R.layout.activity_login;
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

    @OnClick({R.id.btnSignIn,R.id.txtForgotPassword,R.id.txtRegister})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnSignIn:

                    if (validate()) {
                        Intent intentLogin = new Intent(LoginActivity.this, HomeActivity.class);
                        User user = new User();
                        user.setEmailAddress(etEmail.toString());
                        preferenceHelper.setLoginStatus(true);
                        preferenceHelper.putUser(user);
                        startActivity(intentLogin);
                        finish();

                }
                break;


            case R.id.txtForgotPassword:

                Intent intentForgetPassword = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intentForgetPassword);

                break;

            case R.id.txtRegister:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;

            default:


        }
    }

    public Boolean validate(){

        if (etEmail.getText().toString().isEmpty()){

            Utils.showToast(this,getString(R.string.email_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (etPassword.getText().toString().isEmpty()){

            Utils.showToast(this,getString(R.string.password_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {

            Utils.showToast(this,getString(R.string.email_is_not_valid), AppConstant.TOAST_TYPES.INFO);

            return false;
        }


        return true;


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (preferenceHelper.getLoginStatus()) {
            Intent intentLogin = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intentLogin);
        }
    }
}