package com.zhangbin.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zhangbin.utils.LogUtils;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        LogUtils.e("zhangbin111","----接收到的广播---"+action);
        switch (action){
            case "staticBroadCast":
                break;
            case "dynamicBroadCast":
                break;
        }
    }
}
