package com.zhangbin.adpter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;

/**
 * @Package: com.zhangbin.adpter
 * @ClassName: GuidePagerAdapter
 * @Description:
 * @Author: 张彬
 * @CreateDate: 2018-12-31 10:13
 */
public class GuidePagerAdapter extends PagerAdapter {
    private final Random random = new Random();
    private int mSize;
    private int [] iamgeIds;
    public GuidePagerAdapter(int [] iamgeIds) {
        mSize = iamgeIds.length;
        this.iamgeIds = iamgeIds;
    }

    @Override
    public int getCount() {
        return mSize;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
    @Override
    public void destroyItem(@NonNull ViewGroup view, int position, @NonNull Object object) {
        view.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup view, int position) {
        ImageView imageView = new ImageView(view.getContext());
        //imageView.setBackgroundColor(0xff000000 | random.nextInt(0x00ffffff));
        if (iamgeIds != null && iamgeIds.length >0) {
            imageView.setBackgroundResource(iamgeIds[position]);
        }
        view.addView(imageView, ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        return imageView;
    }
}
