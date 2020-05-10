package com.example.jd_oun.login.presenter;


import com.example.jd_oun.base.BasePresenter;
import com.example.jd_oun.login.contract.AffirmContract;
import com.example.jd_oun.login.model.AffirmRegisterModel;

public class AffirmRegisterPresenter extends BasePresenter<AffirmContract.IAffirmView> implements AffirmContract.IAffirmPresenter {

    private AffirmContract.IAffirmMode iAffirmMode;
    public AffirmRegisterPresenter() {

        iAffirmMode = new AffirmRegisterModel();

    }

    @Override
    public void register(String phoneNum, String password, String affirm_password) {

    }
}
