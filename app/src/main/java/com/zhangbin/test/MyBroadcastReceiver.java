package com.zhangbin.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.zhangbin.utils.LogUtils;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String resultData = getResultData();
        String action = intent.getAction();
        LogUtils.d("zhangbin111","----MyBroadcastReceiver接收到的广播---"+action);
        switch (action){
            case "staticBroadCast":
                break;
            case "staticRegisterOrderBoradCast":
                //终止广播
                //abortBroadcast();
                //修改数据 (扣留大米)
                setResultData("习大大给每个村民发了500斤大米");
                break;
        }
    }
}
