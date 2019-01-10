package com.zhangbin.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zhangbin.utils.LogUtils;

public class NongMingBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String resultData = getResultData();
        String action = intent.getAction();
        LogUtils.d("zhangbin111","----NongMingBroadCastReceiver接收到的广播---"+action);
        switch (action){
            case "staticRegisterOrderBoradCast":
                LogUtils.d("zhangbin111","----农民接收到---"+resultData);
                break;
        }
    }
}
