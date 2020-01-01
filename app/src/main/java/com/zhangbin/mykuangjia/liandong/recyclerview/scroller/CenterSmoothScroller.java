package com.zhangbin.mykuangjia.liandong.recyclerview.scroller;

import android.content.Context;
import android.util.DisplayMetrics;

import androidx.recyclerview.widget.LinearSmoothScroller;

/**
 * Version : 1.0
 * Desc    : 滚动相关类
 */
public class CenterSmoothScroller extends LinearSmoothScroller {

    private static final float MILLISECONDS_PER_INCH = 80f;

    public CenterSmoothScroller(Context context) {
        super(context);
    }

    /**
     * 计算滚动速度
     *
     * @param displayMetrics
     * @return 滑过1px所需时间ms
     */
    @Override
    protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return MILLISECONDS_PER_INCH / displayMetrics.densityDpi;
    }

    /**
     * RecyclerView的中心点和item的中心点的相差
     * @param viewStart
     * @param viewEnd
     * @param boxStart
     * @param boxEnd
     * @param snapPreference
     * @return item需要移动的距离
     */
    @Override
    public int calculateDtToFit(int viewStart, int viewEnd, int boxStart, int boxEnd, int snapPreference) {
        return (boxStart + (boxEnd - boxStart) / 2) - (viewStart + (viewEnd - viewStart) / 2);
    }
}
