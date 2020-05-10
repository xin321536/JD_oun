package com.example.jd_oun.home.presenter;

import com.example.jd_oun.base.BasePresenter;
import com.example.jd_oun.home.bean.NewsBean;
import com.example.jd_oun.home.contract.NewsFragmentContract;
import com.example.jd_oun.home.contract.RecommendContract;
import com.example.jd_oun.home.model.NewsModel;
import com.example.jd_oun.net.INetCallBack;

public class NewsPresenter extends BasePresenter<NewsFragmentContract.INewsView> implements RecommendContract.IRecommendPresenter {
    private NewsFragmentContract.INewsMode iNewsMode;

    @Override
    public void getColumList() {

    }

    public NewsPresenter() {

        iNewsMode = new NewsModel();

    }

    @Override
    public void getRecommendList(String id) {
        iNewsMode.getRecommendList(id,new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {

                mview.setRecommendList(newsBean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });


    }
}
