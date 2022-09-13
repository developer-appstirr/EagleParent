package com.example.eagle_parent.activities.LoginFlow;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.activities.BaseActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.helpers.preference.BasePreferenceHelper;
import butterknife.BindView;
import butterknife.OnClick;


public class ResetVerifyActivity extends BaseActivity {


    @BindView(R.id.linePinFiledCode)
    EditText linePinFiledCode;

    public BasePreferenceHelper preferenceHelper;

    @Override
    public int getMainLayoutId() {
        return R.layout.activity_forget_verify_password;
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

    @OnClick({R.id.btnNext,R.id.ivBack})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btnNext:

                if (!linePinFiledCode.getText().toString().isEmpty()){

                    Intent changePasswordIntent = new Intent(ResetVerifyActivity.this, ChangePasswordActivity.class);
                    startActivity(changePasswordIntent);



                }else {

                    Utils.showToast(ResetVerifyActivity.this,"Code should not be empty!",AppConstant.TOAST_TYPES.INFO);

                }

                break;

            case R.id.ivBack:
                    onPageBack();
                break;

            default:


        }
    }






}