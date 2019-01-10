package com.zhangbin.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.zhangbin.utils.LogUtils;
import com.zhangbin.utils.ToastUtils;

/**
 * 最终的receiver 不需要再清单文件里面配置
 * 相当于广播的监听
 * @author 张彬
 *
 */
public class FinalReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		String resultData = getResultData();
        LogUtils.d("zhangbin111","----监察部经查---"+resultData);
		
		
	}

}
