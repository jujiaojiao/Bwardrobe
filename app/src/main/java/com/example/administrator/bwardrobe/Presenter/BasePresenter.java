package com.example.administrator.bwardrobe.Presenter;

import android.content.Context;

/**
 * Created by Administrator on 2016/12/16.
 */

public abstract class BasePresenter<V ,M> {
    public V mView;
    public M mModel;
    public Context context;
    public void setVM(V v,M m){
        this.mView = v;
        this.mModel = m;
        this.onstart();
    }
    public void onstart(){

    }
}
