package com.zhangbin;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {
    private static Context applicationContext;
    private static MyApplication application;
    public static Context getContext() {
        return applicationContext;
    }
    public static MyApplication getApplication() {
        return application;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        application = this;
    }
}
