package com.example.jd_oun.net;

import com.example.jd_oun.net.HttpUrlConnetionUtils;
import com.example.jd_oun.net.INetWork;

public class NetWorkFactory {
    private static int NET_TYPE = 1;

    public INetWork network;

    public INetWork getNetWork() {
        if (NET_TYPE == 1) {
            network = RetrofitUtils.getInstance();
        } else {
            network = HttpUrlConnetionUtils.getInstance();
        }
        return network;
    }

    private static NetWorkFactory netWorkFactory;

    public static NetWorkFactory getInstance() {
        if (netWorkFactory == null) {
            synchronized (RetrofitUtils.class) {
                if (netWorkFactory == null) {
                    netWorkFactory = new NetWorkFactory();
                }
            }
        }
        return netWorkFactory;
    }

}
