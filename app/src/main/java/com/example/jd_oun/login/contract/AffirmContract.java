package com.example.jd_oun.login.contract;

import com.example.jd_oun.base.BaseView;
import com.example.jd_oun.login.bean.AffirmRegisterBean;
import com.example.jd_oun.net.INetCallBack;

/**
 * 注册获取短信验证码
 */
public class AffirmContract {

        public interface IAffirmView extends BaseView {

            void registerResult(AffirmRegisterBean registerBean);
        }
        public interface IAffirmMode{
            <T> void register(String phoneNum,String password,String affirm_password, INetCallBack<T> iNetCallBack);
        }
        public interface IAffirmPresenter{
            void register(String phoneNum,String password,String affirm_password);

        }
}
