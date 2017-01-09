package com.example.administrator.bwardrobe.activities;

import android.app.Activity;
import android.content.Intent;

import com.example.administrator.bwardrobe.R;

public class MainActivity extends BaseActivity{
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initPresenter() {

    }
    public static void showAction(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.push_right_in,
                0);
    }
}
