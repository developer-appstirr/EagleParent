package com.example.eagle_parent.fragments;

import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentManager;

import com.example.eagle_parent.R;
import com.example.eagle_parent.Utils.Utils;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;
import com.example.eagle_parent.dialog.AppDialogs;
import com.example.eagle_parent.listners.ChooseImageInterface;
import com.example.eagle_parent.listners.DateListner;
import com.example.eagle_parent.listners.MediaTypePicker;
import com.example.eagle_parent.models.ChildModel;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


public class AddChildFragment extends BaseFragment implements MediaTypePicker, DateListner, AdapterView.OnItemSelectedListener {

    @BindView(R.id.imvProfile)
    CircleImageView imvProfile;
    private File imgGallery = null;

    @BindView(R.id.etFirstName)
    EditText etFirstName;

    @BindView(R.id.etLastName)
    EditText etLastName;

    @BindView(R.id.etDob)
    EditText etDob;


    String etGender;

    @BindView(R.id.spinnerGender)
    Spinner spinnerGender;


    @Override
    protected void setTitleBar(TitleBar titleBar) {
        titleBar.showHeaderView();
        titleBar.showHeaderTitle("Add Child");
        titleBar.showLeftIconAndListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                activityReference.onBackPressed();
            }
        });

    }

    @Override
    protected int getMainLayout() {
        return R.layout.fragment_add_child;
    }


    @Override
    protected void onFragmentViewReady(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState, View rootView) {



        ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(activityReference, R.array.gender, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);
        spinnerGender.setOnItemSelectedListener(AddChildFragment.this);
    }

    @Override
    public void onCustomBackPressed() {

        activityReference.onPageBack();

    }

    @OnClick({R.id.ivEditProfileImg,R.id.btnAddChild,R.id.etDob})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.btnAddChild:
                if(validate()) {
                    HomeFragment homeFragment = new HomeFragment();
                    ChildModel childModel = new ChildModel();
                    childModel.setFirstName(etFirstName.getText().toString().trim());
                    childModel.setLastName(etLastName.getText().toString().trim());
                    childModel.setDob(etDob.getText().toString().trim());
                    childModel.setGender(etGender);
                    if(imgGallery!=null){
                        childModel.setImage(imgGallery.getAbsolutePath());
                    }else{
                        childModel.setImage("https://image.flaticon.com/icons/png/512/163/163847.png");
                    }

                    activityReference.addSupportFragment(homeFragment, AppConstant.TRANSITION_TYPES.SLIDE);
                    homeFragment.setChildList(childModel);
                    Utils.showToast(activityReference, "Child Created", AppConstant.TOAST_TYPES.SUCCESS);

                }
                break;

            case R.id.ivEditProfileImg:
                AppDialogs dialogs = new AppDialogs();
                dialogs.showChooseImageDialog(activityReference, new ChooseImageInterface() {
                    @Override
                    public void chooseGalleryCallBack() {

                        activityReference.openImagePicker(AddChildFragment.this);
                    }


                    @Override
                    public void chooseCameraCallBack() {

                        activityReference.openCameraPicker(AddChildFragment.this);

                    }


                });
                break;

            case R.id.etDob:
                datePicker();
                break;


            default:
                break;

        }
    }

    public Boolean validate(){


        if (etFirstName.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.firstname_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (etLastName.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.lastName_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (etDob.getText().toString().isEmpty()){

            Utils.showToast(activityReference,getString(R.string.dob_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }

        if (etGender ==null){

            Utils.showToast(activityReference,getString(R.string.gender_is_empty), AppConstant.TOAST_TYPES.INFO);

            return false;

        }


//        if (etEmail.getText().toString().isEmpty()){
//
//            Utils.showToast(activityReference,getString(R.string.email_is_empty), AppConstant.TOAST_TYPES.INFO);
//
//            return false;
//
//        }
//
//        if (!Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString()).matches()) {
//
//            Utils.showToast(activityReference,getString(R.string.email_is_not_valid), AppConstant.TOAST_TYPES.INFO);
//
//            return false;
//        }


        return true;


    }

    @Override
    public void onPhotoClicked(ArrayList<File> file) {
        if(file.size() > 0) {
            imgGallery = file.get(0);
            imvProfile.setImageBitmap(BitmapFactory.decodeFile(imgGallery.getAbsolutePath()));
        }
    }

    @Override
    public void setDate(String date) {
        etDob.setText(date);
    }

    public void datePicker(){
        Utils.datePicker(getFragmentManager(),AddChildFragment.this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        etGender = parent.getItemAtPosition(position).toString();
        ((TextView) parent.getChildAt(0)).setTextSize(16);
        Typeface typeface = ResourcesCompat.getFont(activityReference, R.font.redhatdisplay_medium);
        ((TextView) parent.getChildAt(0)).setTypeface(typeface);
        ((TextView) parent.getChildAt(0)).setTextColor(activityReference.getResources().getColor(R.color.textHintColor));
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

