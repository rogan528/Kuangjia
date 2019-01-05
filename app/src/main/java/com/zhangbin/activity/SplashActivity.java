package com.zhangbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.zhangbin.utils.Constants;
import com.zhangbin.R;
import com.zhangbin.utils.SPUtils;


/**
 *
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initData();

    }

    /**
     * 初始化数据
     */
    private void initData() {
        boolean isFirstEnter = (Boolean) SPUtils.getInstance().getParam(SPUtils.XMLKeyName.FIRST_LOGIN,true);
        Intent intent;
        if (isFirstEnter){
            intent = new Intent(getApplicationContext(),GuideActivity.class);
        }else{
            intent = new Intent(getApplicationContext(),MainActivity.class);
        }
        startActivity(intent);
        finish();
    }

}
