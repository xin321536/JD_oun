package com.example.jd_oun.login.contract;

import com.example.jd_oun.base.BaseView;
import com.example.jd_oun.login.bean.VerfiedBean;
import com.example.jd_oun.net.INetCallBack;

public class RegisterMSMContract {

        public interface IRegisterMSMView extends BaseView {

//            逻辑判断在P层判断--为了简单一点，扔道Acitivty
            void getVerified(VerfiedBean s);

            void  getLoginResult(String string);

            void checkSmsCodeResult(VerfiedBean verfiedBean);

        }
        public interface IRegisterMSMMode{
            <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack);
            <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack);
        }
        public interface IRegisterMSMPresenter{
            void getVerified(String string, String type);

            void checkSmsCode(String phoneNum, String smsCode, String type);
        }
}
