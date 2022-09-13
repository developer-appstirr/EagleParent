package com.example.eagle_parent.customViews;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.eagle_parent.R;


public class TitleBar extends FrameLayout {


    ImageView ivLeftNavigationIcon;
    ImageView ivRightNotificationIcon;
    ImageView ivRightCheckAllIcon;
    ImageView ivRightAddIcon;
    LinearLayout llBackLayout;
    public ImageView ivLeftBackIcon;
    TextView tvTitle;
    TextView tvLeftText;
    CoordinatorLayout headerLayout;
    public FrameLayout flBackGround;
    LinearLayout llAppLogoSection;

    private Context context;

    public TitleBar(Context context) {
        super(context);
        this.context = context;
        initLayout(context);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
        if (attrs != null)
            initAttrs(context, attrs);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initLayout(context);
        if (attrs != null)
            initAttrs(context, attrs);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
    }

    private void initLayout(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.titlebar, this);


        bindViews();
        resetViews();

    }


    public void resetViews() {

        headerLayout.setVisibility(GONE);
        llBackLayout.setVisibility(GONE);
        tvTitle.setVisibility(GONE);
        ivLeftBackIcon.setVisibility(GONE);
        ivLeftNavigationIcon.setVisibility(GONE);

        ivRightAddIcon.setVisibility(GONE);
        ivRightNotificationIcon.setVisibility(GONE);
        ivRightCheckAllIcon.setVisibility(GONE);

        tvTitle.setOnClickListener(null);
        llBackLayout.setOnClickListener(null);
        llAppLogoSection.setOnClickListener(null);

        ivRightAddIcon.setOnClickListener(null);
        ivRightCheckAllIcon.setOnClickListener(null);
        ivRightNotificationIcon.setOnClickListener(null);

    }

    private void bindViews() {

        ivRightNotificationIcon = (ImageView) this.findViewById(R.id.ivRightNotificationIcon);
        ivRightCheckAllIcon = (ImageView) this.findViewById(R.id.ivCheckAllIcon);
        ivRightAddIcon = (ImageView) this.findViewById(R.id.ivRightAddIcon);
        ivLeftNavigationIcon = (ImageView) this.findViewById(R.id.ivLeftNavigationIcon);
        headerLayout = (CoordinatorLayout) this.findViewById(R.id.headerLayout);
        flBackGround = (FrameLayout) this.findViewById(R.id.flBackGround);
        llBackLayout = (LinearLayout) this.findViewById(R.id.llBackLayout);
        tvTitle = (TextView) this.findViewById(R.id.tvTitle);
        llAppLogoSection = (LinearLayout) this.findViewById(R.id.llAppLogoSection);
        tvLeftText = (TextView) this.findViewById(R.id.tvLeftText);
        ivLeftBackIcon = (ImageView) this.findViewById(R.id.ivLeftBackIcon);
    }




    public void showHeaderView(){
        resetViews();
        headerLayout.setVisibility(View.VISIBLE);

    }


    public void hideHeaderView(){
        headerLayout.setVisibility(View.GONE);
    }

    public void showBackMenuView(){
        llBackLayout.setVisibility(View.VISIBLE);
    }

    public void showLeftNavigationIconAndListener(OnClickListener onClickListener) {

        ivLeftNavigationIcon.setVisibility(View.VISIBLE);
        ivLeftNavigationIcon.setOnClickListener(onClickListener);
//        AnimationHelpers.animate(Techniques.BounceInLeft, 500, ivLeftBackIcon);
    }


    public void showRightAddIconAndListener(OnClickListener onClickListener) {

        ivRightAddIcon.setVisibility(View.VISIBLE);
        ivRightAddIcon.setOnClickListener(onClickListener);
//        AnimationHelpers.animate(Techniques.BounceInLeft, 500, ivLeftBackIcon);
    }

    public void showRightCheckAllAndListener(OnClickListener onClickListener) {

        ivRightCheckAllIcon.setVisibility(View.VISIBLE);
        ivRightCheckAllIcon.setOnClickListener(onClickListener);
//        AnimationHelpers.animate(Techniques.BounceInLeft, 500, ivLeftBackIcon);
    }

    public void showRightNotificationAndListener(OnClickListener onClickListener) {

        ivRightNotificationIcon.setVisibility(View.VISIBLE);
        ivRightNotificationIcon.setOnClickListener(onClickListener);
//        AnimationHelpers.animate(Techniques.BounceInLeft, 500, ivLeftBackIcon);
    }


    public void showLeftIconAndListener(OnClickListener onClickListener) {

        showBackMenuView();

        ivLeftBackIcon.setVisibility(View.VISIBLE);
        ivLeftBackIcon.setOnClickListener(onClickListener);
//        AnimationHelpers.animate(Techniques.BounceInLeft, 500, ivLeftBackIcon);
    }




    public void showLeftIconAndListener(int iconResId, OnClickListener onClickListener) {
        ivLeftBackIcon.setVisibility(View.VISIBLE);
        ivLeftBackIcon.setImageResource(iconResId);
        ivLeftBackIcon.setOnClickListener(onClickListener);
//        AnimationHelpers.animate(Techniques.BounceInLeft, 500, ivLeftBackIcon);
    }




    public void setLeftTitleText(String text) {

        TypedValue typedValue = new TypedValue();
        Resources.Theme theme = getContext().getTheme();
        @ColorInt int color;
        if(text.equals(getContext().getString(R.string.app_name))){
          //  viewLeftSeperator.setVisibility(GONE);
            theme.resolveAttribute(R.attr.colorPrimary, typedValue, true);
        }
        else{
         //   viewLeftSeperator.setVisibility(View.VISIBLE);
            theme.resolveAttribute(R.color.black, typedValue, true);
        }

        color = typedValue.data;

        tvLeftText.setVisibility(View.VISIBLE);
        tvLeftText.setText(text);
        tvLeftText.setTextColor(color);
    }


    public void showHeaderTitle() {
        llAppLogoSection.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.VISIBLE);
    }

//    public void showHeaderTitle(int gravity) {
//        llAppLogoSection.setVisibility(View.VISIBLE);
//        tvTitle.setVisibility(View.VISIBLE);
//        llAppLogoSection.setGravity(gravity);
//
//        LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
//
//        if(gravity != Gravity.CENTER)
//            params.setMarginStart(35);
//        else
//            params.setMarginStart(0);
//
//        params.gravity = gravity;
//        llAppLogoSection.setLayoutParams(params);
//    }


    public void showHeaderTitle(String text) {
        llAppLogoSection.setVisibility(View.VISIBLE);
        tvTitle.setVisibility(View.VISIBLE);
        tvTitle.setText(text);
    }



}

