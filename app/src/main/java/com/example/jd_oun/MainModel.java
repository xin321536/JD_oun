package com.example.jd_oun;

import android.util.Log;

import com.example.jd_oun.MainContract;
import com.example.jd_oun.base.BaseModel;
import com.example.jd_oun.net.INetCallBack;
import com.example.jd_oun.net.NetWorkFactory;
import com.example.jd_oun.net.ParamsUtils;
import com.example.jd_oun.net.api.URLConstants;

import java.util.HashMap;

public class MainModel  extends BaseModel implements MainContract.IMainMode {



    public MainModel() {
    }

    @Override
    public <T> void getRecommendList(INetCallBack<T> netCallBack) {

        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("start","0");
        commonParams.put("number","0");
        commonParams.put("point_time ","0");

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }

        NetWorkFactory.getInstance().getNetWork().get(URLConstants.VEDIO_LIST,commonParams ,netCallBack);
    }
}
