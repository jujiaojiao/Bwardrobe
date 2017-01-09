package com.example.administrator.bwardrobe.activities;

import android.animation.Animator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.administrator.bwardrobe.R;

public class StartActivity extends AppCompatActivity implements Animator.AnimatorListener {
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        image = (ImageView) findViewById(R.id.startimage);
        image.animate().setDuration(3000).setListener(this).start();
    }
    @Override
    public void onAnimationStart(Animator animation) {

    }

    @Override
    public void onAnimationEnd(Animator animation) {
        MainActivity.showAction(this);
        this.overridePendingTransition(0,R.anim.push_right_out);
        this.finish();
    }

    @Override
    public void onAnimationCancel(Animator animation) {

    }

    @Override
    public void onAnimationRepeat(Animator animation) {

    }
}
