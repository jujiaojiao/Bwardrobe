package com.example.administrator.bwardrobe.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.administrator.bwardrobe.R;
import com.example.administrator.bwardrobe.fragment.HeadFragment;

import butterknife.BindView;

public class MainActivity extends BaseActivity{
    @BindView(R.id.group_main)
    RadioGroup group;
    private HeadFragment headFragment;
    private Fragment lastFragment;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        headFragment = new HeadFragment();
        changeFragment(headFragment);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

            }
        });
    }

    @Override
    public void initPresenter() {

    }
    //fragment切换
    private void changeFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        if (!fragment.isAdded()) {
            if (lastFragment != null) {
                fragmentTransaction.hide(lastFragment);
            }
            fragmentTransaction.add(R.id.activity_main,fragment).commit();
        }else{
            fragmentTransaction.hide(lastFragment).show(fragment).commit();
        }
    }
}
