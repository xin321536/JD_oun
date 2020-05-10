package com.example.jd_oun.login.contract;

import com.example.jd_oun.base.BaseView;
import com.example.jd_oun.login.bean.VerfiedBean;
import com.example.jd_oun.net.INetCallBack;

public class LoginContract {

        public interface ILoginView extends BaseView {

            void getVerified(VerfiedBean s);

            void  getLoginResult(String string);

            void checkSmsCodeResult(VerfiedBean verfiedBean);

        }
        public interface ILoginMode{
           <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);

            <T> void login(String mobile, String smsCode, INetCallBack<T> iNetCallBack);
            <T> void checkSmsCode(String phoneNum, String smsCode, String type,INetCallBack<T> iNetCallBack);
        }
        public interface ILoginPresenter{
            void getVerified(String string,String type);
            void login(String mobile,String smsCode);
            void checkSmsCode(String phoneNum,String smsCode,String type);
        }
}
