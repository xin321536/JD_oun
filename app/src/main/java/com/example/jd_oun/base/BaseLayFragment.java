package com.example.jd_oun.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseLayFragment<T extends BasePresenter> extends Fragment implements BaseView {

    private boolean IS_VIEW_CREATED = false;

    public boolean IS_DATA_LOAD = false;

    protected T mPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lazyLoad();
    }

    @Override
    public void onResume() {
        super.onResume();
        isCurrentVisibleToUser(true);
    }


    @Override
    public void onPause() {
        super.onPause();
        isCurrentVisibleToUser(false);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        lazyLoad();
        Log.e("TAG","当前Fragment是否是可见状态");
        isCurrentVisibleToUser(isVisibleToUser);
    }

    private void lazyLoad(){
       if( getUserVisibleHint()  && IS_VIEW_CREATED  && !IS_DATA_LOAD){
           initData();
           IS_DATA_LOAD = true;
       }else{
       }
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  LayoutInflater.from(container.getContext()).inflate(getLayoutID(),container,false);
        IS_VIEW_CREATED = true;

        mPresenter =  initPresenter();
        if(null != mPresenter ){
            mPresenter.AttachView(this);
        }
        initView(view);
        initLinstener();
        return view;
    }

    protected abstract T initPresenter();

    protected abstract void initLinstener();

    protected abstract void initData();

    protected abstract void initView(View view);

    public abstract  int getLayoutID();

    public abstract  void isCurrentVisibleToUser(boolean isVisible);

}
