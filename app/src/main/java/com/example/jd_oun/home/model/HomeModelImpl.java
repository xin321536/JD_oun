package com.example.jd_oun.home.model;

import com.example.jd_oun.base.BaseModel;
import com.example.jd_oun.home.contract.HomeContract;
import com.example.jd_oun.net.INetCallBack;

public class HomeModelImpl extends BaseModel implements HomeContract.IHomeMode {

    private HomeContract.IHomePresenter iHomePresenter;

    public HomeModelImpl(HomeContract.IHomePresenter iHomePresenter) {
        this.iHomePresenter = iHomePresenter;
    }

    @Override
    public <T> void getHomeBannview(INetCallBack<T> netCallBack) {
    }

    @Override
    public <T> void getHomeTabList(INetCallBack<T> iNetCallBack) {
    }
}
