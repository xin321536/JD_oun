package com.example.jd_oun.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jd_oun.R;
import com.example.jd_oun.base.BaseActivity;
import com.example.jd_oun.login.bean.VerfiedBean;
import com.example.jd_oun.login.contract.LoginContract;
import com.example.jd_oun.login.presenter.LoginPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {


    private EditText phone_num;
    private EditText verfied;
    private TextView send_verfied_bug;
    private Button login;



    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void initView() {
          phone_num = findViewById(R.id.phone_num);
          verfied= findViewById(R.id.verified);
          send_verfied_bug= findViewById(R.id.send_verfied_bug);
          login= findViewById(R.id.login_but);
    }

    @Override
    public void initData() {

    }

  private   String edit_phone_num;
   private String edit_sms_code;

    @Override
    public void initLinstener() {

//        发送验证码
        send_verfied_bug.setOnClickListener(v->{
            String phonenum = phone_num.getText().toString();
            if( !TextUtils.isEmpty(phonenum) && isMobileNO(phonenum)){
                mPresenter.getVerified(phonenum,"4");
            }else Toast.makeText(LoginActivity.this, "手机号不对，去重新输入", Toast.LENGTH_SHORT).show();
        });

//登录
        login.setOnClickListener(v->{
            edit_phone_num = phone_num.getText().toString();
            edit_sms_code = verfied.getText().toString();
            if( !TextUtils.isEmpty(edit_phone_num) && isMobileNO(edit_phone_num)){
                if( !TextUtils.isEmpty(edit_sms_code)){
                    Pattern pattern = Pattern.compile("\\d{6}");
                    boolean matches = pattern.matcher(edit_sms_code).matches();
                    if(matches){
                        Log.e("TAG",edit_phone_num+"验证码值："+edit_sms_code);

                        mPresenter.checkSmsCode(edit_phone_num,edit_sms_code,"4");
                    }else Toast.makeText(LoginActivity.this, "验证码输入错误", Toast.LENGTH_SHORT).show();
                }else Toast.makeText(LoginActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
            }else Toast.makeText(LoginActivity.this, "手机号不对，去重新输入", Toast.LENGTH_SHORT).show();
        });
    }
    @Override
    public int getLayoutID() {
        return R.layout.activity_login;
    }
    @Override
    public void getVerified(VerfiedBean s) {
        if(s.getCode() ==1){
            Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "错误", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void getLoginResult(String string) {
    }

    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {

        if(verfiedBean.getCode() ==1){

            mPresenter.login(edit_phone_num,edit_sms_code);

        }else Toast.makeText(this, "验证码输入错误", Toast.LENGTH_SHORT).show();


    }

    /*
     * 验证手机号码
     */
    public static boolean isMobileNO(String mobiles){
        boolean flag = false;
        try{
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        }catch(Exception e){
            Log.e("TAG","手机号错误"+e.getMessage());
            flag = false;
        }
        return flag;
    }

    public void startRegister(View view) {
        Intent intent = new Intent(this, RegisterMSMCodeActivity.class);
        startActivity(intent);
    }
}
