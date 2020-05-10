package com.example.jd_oun;

import com.example.jd_oun.base.BaseView;
import com.example.jd_oun.net.INetCallBack;

public class MainContract {

        public interface IMainView extends BaseView {

        }

        public interface IMainMode{
          <T>  void getRecommendList(INetCallBack<T> netCallBack);
        }

        public interface IMainPresenter{

            void getRecommendList();
        }
}
