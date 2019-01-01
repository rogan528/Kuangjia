package com.zhangbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.zhangbin.R;
import com.zhangbin.adpter.GuidePagerAdapter;
import com.zhangbin.utils.ConstantsValue;
import com.zhangbin.utils.SharedPreferencesUtils;

import me.relex.circleindicator.CircleIndicator;

/**
 * @Package: com.zhangbin
 * @ClassName: GuideActivity
 * @Description: 新手引导页面
 * @Author: 张彬
 * @CreateDate: 2018-12-31 10:02
 */
public class GuideActivity extends Activity {
    private int[] mIamgeIds;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        initView();
    }

    private void initData() {
        mIamgeIds = ConstantsValue.mGuideIamgeIds;
    }

    private void initView() {
        ViewPager viewpager = findViewById(R.id.viewpager);
        CircleIndicator indicator = findViewById(R.id.indicator);
        button = findViewById(R.id.btn_test);
        viewpager.setAdapter(new GuidePagerAdapter(mIamgeIds));
        indicator.setViewPager(viewpager);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == mIamgeIds.length-1){
                    button.setVisibility(View.VISIBLE);
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            SharedPreferencesUtils.setParam(getApplicationContext(), ConstantsValue.XmlKeyName.FIRST_LOGIN, false);
                            //跳到主页面
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                            finish();
                        }
                    });
                }

            }

            @Override
            public void onPageScrollStateChanged(int position) {

            }
        });
    }
}
