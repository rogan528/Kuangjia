package com.zhangbin.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.zhangbin.R;
import com.zhangbin.test.FinalReceiver;
import com.zhangbin.utils.ConstantsValue;
import com.zhangbin.utils.DialogUtils;
import com.zhangbin.utils.LogUtils;
import com.zhangbin.utils.SPUtils;
/**
 *
 */
public class SplashActivity extends Activity {
    private long splashTime = ConstantsValue.mGuideHandlerTime;
    private Handler mHandler;
    private  int MSG_STOP_SPLASH = 1;
    private MyInnerBroadcastReceiver myInnerBroadcastReceiver;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initData();
        mHandler.sendEmptyMessageDelayed(MSG_STOP_SPLASH, splashTime);
        //TODO 测试静态无序广播
        staticBroadCast(SplashActivity.this);
        dynamicRegisterBoradCastReceiver(SplashActivity.this);
        //TODO 测试有序广播
        staticRegisterOrderBoradCastReceiver(SplashActivity.this);
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
        myInnerBroadcastReceiver = new MyInnerBroadcastReceiver();
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction("dynamicBroadCast");
        context.registerReceiver(myInnerBroadcastReceiver, myIntentFilter);

        Intent intent = new Intent("dynamicBroadCast");
        intent.putExtra("test","testValue");
        context.sendBroadcast(intent);
    }
    public void  staticRegisterOrderBoradCastReceiver(Context context){
        Intent intent = new Intent("staticRegisterOrderBoradCast");
        intent.putExtra("test","testValue");
        intent.setPackage(context.getPackageName());
        context.sendOrderedBroadcast(intent, null, new FinalReceiver(), null, 1, "习大大给每个村民发了1000斤大米", null);
    }
    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myInnerBroadcastReceiver);
    }

    class MyInnerBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            LogUtils.d("zhangbin111","----MyInnerBroadcastReceiver接收到的广播---"+action);
            switch (action){
                case "dynamicBroadCast":
                    String testValue = intent.getStringExtra("test");
                    LogUtils.d("zhangbin111","--testValue--"+testValue);
                    break;
            }
        }
    }
}
