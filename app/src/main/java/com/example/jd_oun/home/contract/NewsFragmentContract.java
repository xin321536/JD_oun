package com.example.jd_oun.home.contract;

import com.example.jd_oun.base.BaseView;
import com.example.jd_oun.home.bean.NewsBean;
import com.example.jd_oun.net.INetCallBack;

public class NewsFragmentContract {


    public interface INewsView extends BaseView {
        void  setRecommendList(NewsBean newsBean);
    }
    public interface INewsMode{
        <T> void getRecommendList(String tabID, INetCallBack<T> iNetCallBack);
    }
    public interface INewsPresenter{
        void getRecommend(String string);
    }
}
