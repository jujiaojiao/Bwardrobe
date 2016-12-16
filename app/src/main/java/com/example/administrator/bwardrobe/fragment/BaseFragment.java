package com.example.administrator.bwardrobe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.bwardrobe.Model.BaseModel;
import com.example.administrator.bwardrobe.Presenter.BasePresenter;
import com.example.administrator.bwardrobe.utils.LoadginDialog;
import com.example.administrator.bwardrobe.utils.Tutil;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/16.
 *
 */

public abstract class BaseFragment<P extends BasePresenter,M extends BaseModel> extends Fragment {
    protected View rootView;
    private P mPresenter;
    private M mModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView==null)
            rootView = inflater.inflate(getLayoutResource(),container,false);
        ButterKnife.bind(this,rootView);
        mPresenter = Tutil.getT(this, 0);
        mModel= Tutil.getT(this,1);
        if(mPresenter!=null){
            mPresenter.context=this.getActivity();
        }
        initView();
        initPresenter();
        return rootView;
    }
    //子Fragment的布局文件直接在这个方法里返回
    protected abstract int getLayoutResource();
    //简单页面无需mvp就不用管此方法即可,完美兼容各种实际场景的变通
    public abstract void initPresenter();
    //初始化view等功能，当oncreateView使用即可
    protected abstract void initView();
    public void startProgressDialog() {
        LoadginDialog.showDialogForLoading(getActivity());
    }
    /**
     * 开启加载进度条
     *
     * @param msg
     */
    public void startProgressDialog(String msg) {
        LoadginDialog.showDialogForLoading(getActivity(), msg, true);
    }
    /**
     * 停止加载进度条
     */
    public void stopProgressDialog() {
        LoadginDialog.cancelDialogForLoading();
    }
}
