package com.xlistviewdemo;

import android.app.Application;

import cn.finalteam.okhttpfinal.OkHttpFinal;
import cn.finalteam.okhttpfinal.OkHttpFinalConfiguration;

/**
 * Created by guojiadong
 * on 2017/4/7.
 */

public class BaseAplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化OKhttp
        OkHttpFinalConfiguration.Builder builder = new OkHttpFinalConfiguration.Builder();
        OkHttpFinal.getInstance().init(builder.build());
    }
}
