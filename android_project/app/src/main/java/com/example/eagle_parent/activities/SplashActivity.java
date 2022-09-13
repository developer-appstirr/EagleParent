package com.example.eagle_parent.activities;


import android.os.Handler;

import com.example.eagle_parent.R;

import com.example.eagle_parent.activities.LoginFlow.LoginActivity;
import com.example.eagle_parent.constant.AppConstant;
import com.example.eagle_parent.customViews.TitleBar;


public class SplashActivity extends BaseActivity {
    @Override
    public int getMainLayoutId() {
        return R.layout.activity_splash_screen;
    }

    @Override
    protected void onViewReady() {


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               // glowAnimation();
                launchTimerAndTask();
            }
        }, AppConstant.MIN_TIME_INTERVAL_FOR_SPLASH);

    }

    @Override
    public int getFragmentFrameLayoutId() {
        return 0;
    }

    @Override
    public TitleBar getTitleBar() {
        return null;
    }


    private void launchTimerAndTask() {

        changeActivity(LoginActivity.class, true);

    }


   /* private void glowAnimation() {

        int animationSpeed = 1500;

        // AnimationHelpers.animateWithCompletionListener(Techniques.FadeIn, animationSpeed, 0, ivLogo, null);
        AnimationHelpers.animateWithCompletionListener(Techniques.FadeIn, animationSpeed, 0, tvAppTitle, null);
        AnimationHelpers.animateWithCompletionListener(Techniques.FadeIn, animationSpeed, 0, tvAppDesc, new YoYo.AnimatorCallback() {
            @Override
            public void call(Animator animator) {
                launchTimerAndTask();
            }
        });
    }
*/
}
