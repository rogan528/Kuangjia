package com.zhangbin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.zhangbin.utils.SharedPreferencesUtils;

import me.relex.circleindicator.CircleIndicator;


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
        boolean isFirstEnter = (Boolean) SharedPreferencesUtils.getParam(SplashActivity.this,"first_login",true);
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
