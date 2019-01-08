package com.zhangbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.zhangbin.R;
import com.zhangbin.utils.Constants;
import com.zhangbin.utils.SPUtils;
/**
 *
 */
public class SplashActivity extends Activity {
    private long splashTime = Constants.mGuideHandlerTime;
    private Handler mHandler;
    private  int MSG_STOP_SPLASH = 1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initData();
        mHandler.sendEmptyMessageDelayed(MSG_STOP_SPLASH, splashTime);

    }

    /**
     * 初始化数据
     */
    private void initData() {
        mHandler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                if (msg.what == MSG_STOP_SPLASH) {
                    boolean isFirstEnter = (Boolean) SPUtils.getInstance().getParam(SPUtils.XMLKeyName.FIRST_LOGIN,true);
                    Intent intent;
                    if (isFirstEnter){
                        intent = new Intent(getApplicationContext(),GuideActivity.class);
                    }else{
                        intent = new Intent(getApplicationContext(),LoginActivity.class);
                    }
                    startActivity(intent);
                    finish();
                }
                super.handleMessage(msg);
            }
        };

    }

}
