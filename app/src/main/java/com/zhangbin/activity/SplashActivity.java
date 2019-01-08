package com.zhangbin.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.zhangbin.R;
import com.zhangbin.test.MyBroadcastReceiver;
import com.zhangbin.test.TestJiaData;
import com.zhangbin.utils.Constants;
import com.zhangbin.utils.SPUtils;
/**
 *
 */
public class SplashActivity extends Activity {
    private long splashTime = Constants.mGuideHandlerTime;
    private Handler mHandler;
    private  int MSG_STOP_SPLASH = 1;
    private MyBroadcastReceiver myBroadcastReceiver;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initData();
        mHandler.sendEmptyMessageDelayed(MSG_STOP_SPLASH, splashTime);
        //TODO 测试静态广播
        staticBroadCast(SplashActivity.this);
        dynamicRegisterBoradCastReceiver(SplashActivity.this);
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
    public void  staticBroadCast(Context context) {
        Intent intent = new Intent("staticBroadCast");
        intent.setPackage(context.getPackageName());//此行必须添加,否则8.0会出现接收不到
        context.sendBroadcast(intent);
    }
    public void  dynamicRegisterBoradCastReceiver(Context context){
        myBroadcastReceiver = new MyBroadcastReceiver();
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction("dynamicBroadCast");
        context.registerReceiver(myBroadcastReceiver, myIntentFilter);
        Intent intent = new Intent("dynamicBroadCast");
        context.sendBroadcast(intent);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myBroadcastReceiver);
    }
}
