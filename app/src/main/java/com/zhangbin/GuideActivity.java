package com.zhangbin;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.widget.Toast;

import com.zhangbin.adpter.GuidePagerAdapter;
import com.zhangbin.utils.ToastUtils;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initData();
        initView();
    }

    private void initData() {
        mIamgeIds = new int[]{R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};
    }

    private void initView() {
        ViewPager viewpager = findViewById(R.id.viewpager);
        CircleIndicator indicator = findViewById(R.id.indicator);
        viewpager.setAdapter(new GuidePagerAdapter(mIamgeIds));
        indicator.setViewPager(viewpager);
        viewpager.setCurrentItem(0);
        int gravity = Gravity.CENTER;
        //ToastUtils.showLongLocationImageToast(this,"22222",gravity,0,0,R.drawable.icon);
    }
}
