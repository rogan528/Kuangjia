package com.zhangbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.zhangbin.utils.Constants;
import com.zhangbin.R;
import com.zhangbin.adpter.GuidePagerAdapter;
import com.zhangbin.utils.SPUtils;

import me.relex.circleindicator.CircleIndicator;

/**
 * @Package: com.zhangbin
 * @Description: 新手引导页面
 * @Author: 张彬
 * @CreateDate: 2018-12-31 10:02
 */
public class GuideActivity extends Activity {
    private int[] mIamgeIds;
    private ViewPager viewpager;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        initView();
    }

    private void initData() {
        mIamgeIds = Constants.mGuideIamgeIds;
    }

    private void initView() {
        viewpager = findViewById(R.id.viewpager);
        CircleIndicator indicator = findViewById(R.id.indicator);
        button = findViewById(R.id.btn_test);
        viewpager.setAdapter(new GuidePagerAdapter(mIamgeIds));
        indicator.setViewPager(viewpager);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == mIamgeIds.length-1){
                    button.setVisibility(View.VISIBLE);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Boolean b =SPUtils.getInstance().setParam( SPUtils.XMLKeyName.FIRST_LOGIN, false);
                            SPUtils.getInstance().setParam("is_login", false);
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            finish();
                        }
                    });
                }else {
                    button.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }
}