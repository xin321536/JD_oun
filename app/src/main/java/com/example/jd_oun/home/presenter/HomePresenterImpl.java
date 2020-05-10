package com.example.jd_oun.home.presenter;

import com.example.jd_oun.base.BasePresenter;
import com.example.jd_oun.home.bean.User;
import com.example.jd_oun.home.contract.HomeContract;
import com.example.jd_oun.home.model.HomeModelImpl;
import com.example.jd_oun.home.view.HomeActivity;
import com.example.jd_oun.net.INetCallBack;

public class HomePresenterImpl extends BasePresenter<HomeActivity> implements HomeContract.IHomePresenter {

    private HomeContract.IHomeMode  iHomeMode;
//    private HomeContract.IHomeView iHomeView;

    public HomePresenterImpl() {
        iHomeMode = new HomeModelImpl(this);
    }
    @Override
    public void callHomeBannview(String string) {
//        P层中拿到数据
        mview.setBannView(string);
    }
    @Override
    public void getBannerView() {
        iHomeMode.getHomeBannview(new INetCallBack<User>() {
            @Override
            public void onSuccess(User user) {

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });
    }

    @Override
    public void getHomeTabList() {

    }

   /* @Override
    public void disAttachView() {
        iHomeMode = null;
        iHomeView = null;
    }*/
}
