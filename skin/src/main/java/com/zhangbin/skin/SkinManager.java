package com.zhangbin.skin;

import android.app.Application;
import android.view.LayoutInflater;

public class SkinManager {
    private Application application;
    private static SkinManager instance;
    private SkinManager(Application application) {
        this.application = application;
        application.registerActivityLifecycleCallbacks(new SkinActivityLifecle);
    }
    public static void init(Application application){
        synchronized (SkinManager.class){
            if (null ==  instance){
                instance = new SkinManager(application);
            }
        }
    }
}
