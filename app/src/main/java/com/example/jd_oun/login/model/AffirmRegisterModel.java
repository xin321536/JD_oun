package com.example.jd_oun.login.model;

import com.example.jd_oun.login.contract.AffirmContract;
import com.example.jd_oun.net.INetCallBack;

public class AffirmRegisterModel implements AffirmContract.IAffirmMode {
    @Override
    public <T> void register(String phoneNum, String password, String affirm_password, INetCallBack<T> iNetCallBack) {

    }
}
