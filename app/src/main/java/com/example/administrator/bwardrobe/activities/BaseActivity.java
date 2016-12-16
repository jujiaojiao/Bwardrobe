package com.example.administrator.bwardrobe.activities;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.bwardrobe.Model.BaseModel;
import com.example.administrator.bwardrobe.Presenter.BasePresenter;
import com.example.administrator.bwardrobe.utils.LoadginDialog;
import com.example.administrator.bwardrobe.utils.Tutil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/16.
 *      封装思路：将其共性封装在基类中，特性子类各自实现
 *
 */

public abstract class BaseActivity<P extends BasePresenter,M extends BaseModel> extends AppCompatActivity {
    public P mPresenter;
    public M mModel;
    public Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);//绑定布局文件
        mContext = this;
        mPresenter = Tutil.getT(this, 0);
        mModel= Tutil.getT(this,1);
        if(mPresenter!=null){
            mPresenter.context=this;
        }
        this.initPresenter();
        this.initView();
    }

    /** ------------------------子类实现----------------------------------------*/

    //获取布局文件
    public abstract int getLayoutId();
    //初始化View
    public abstract void initView();
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();



    /** ------------------------每个子类均可调用----------------------------------*/
    public void startProgressDialog() {
        LoadginDialog.showDialogForLoading(this);
    }
    /**
     * 开启加载进度条
     *
     * @param msg
     */
    public void startProgressDialog(String msg) {
        LoadginDialog.showDialogForLoading(this, msg, true);
    }
    /**
     * 停止加载进度条
     */
    public void stopProgressDialog() {
        LoadginDialog.cancelDialogForLoading();
    }
}
