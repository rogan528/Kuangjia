package com.zhangbin;

import android.app.Application;
import android.content.Context;
import android.app.ActivityManager;
import android.content.pm.PackageManager;
import android.util.Log;

import com.hyphenate.chat.EMClient;
import com.hyphenate.chat.EMOptions;

import java.util.Iterator;
import java.util.List;
public class MyApplication extends Application {
    private static Context applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    public static Context getContext() {
        return applicationContext;
    }
}
