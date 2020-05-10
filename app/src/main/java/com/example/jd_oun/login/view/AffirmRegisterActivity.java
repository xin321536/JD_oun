package com.example.jd_oun.login.view;

import android.widget.Button;
import android.widget.EditText;

import com.example.jd_oun.R;
import com.example.jd_oun.base.BaseActivity;
import com.example.jd_oun.login.bean.AffirmRegisterBean;
import com.example.jd_oun.login.contract.AffirmContract;
import com.example.jd_oun.login.presenter.AffirmRegisterPresenter;

public class AffirmRegisterActivity extends BaseActivity<AffirmRegisterPresenter> implements AffirmContract.IAffirmView {

    private EditText affreg_passward;
    private EditText affreg_affirmpassword;
    private Button arrirm_regbug;

    @Override
    protected AffirmRegisterPresenter initPresenter() {
        return new AffirmRegisterPresenter();
    }

    @Override
    public void initView() {

          affreg_passward = findViewById(R.id.affreg_passward);
          affreg_affirmpassword = findViewById(R.id.affreg_affirmpassword);
          arrirm_regbug  = findViewById(R.id.arrirm_regbug);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initLinstener() {
        arrirm_regbug.setOnClickListener(v -> {

        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_affirm_register;
    }

    @Override
    public void registerResult(AffirmRegisterBean registerBean) {

    }
}
