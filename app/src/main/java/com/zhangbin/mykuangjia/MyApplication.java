package com.zhangbin.mykuangjia;

import android.app.Application;

import com.zhangbin.skin.SkinManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SkinManager.init(this);

    }
}
