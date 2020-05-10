package com.example.jd_oun.home.presenter;


import com.example.jd_oun.base.BasePresenter;
import com.example.jd_oun.home.bean.ColunmBean;
import com.example.jd_oun.home.bean.NewsBean;
import com.example.jd_oun.home.contract.RecommendContract;
import com.example.jd_oun.home.model.RecommendModel;
import com.example.jd_oun.net.INetCallBack;

public class RecommendPresenter extends BasePresenter<RecommendContract.IRecommendView> implements RecommendContract.IRecommendPresenter {


    RecommendContract.IRecommendMode iRecommendMode;

    public RecommendPresenter() {
        iRecommendMode = new RecommendModel();
    }

    @Override
    public void getColumList() {

        iRecommendMode.getColumList(new INetCallBack<ColunmBean>() {
            @Override
            public void onSuccess(ColunmBean remBean) {

                mview.setColumList(remBean);

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }

    @Override
    public void getRecommendList(String id) {

        iRecommendMode.getRecommendList(id,new INetCallBack<NewsBean>() {
            @Override
            public void onSuccess(NewsBean remBean) {

               mview.setRecommendList(remBean);

            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }
}
