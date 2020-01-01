package com.zhangbin.mykuangjia.liandong.recyclerview.layoutmanager;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.zhangbin.mykuangjia.liandong.recyclerview.scroller.CenterSmoothScroller;


/**
 * Version : 1.0
 * Desc    : 重写布局管理器,自定义滚动位置
 */
public class CenterLayoutManager extends LinearLayoutManager {

    public CenterLayoutManager(Context context) {
        super(context);
    }

    public CenterLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public CenterLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        CenterSmoothScroller centerSmoothScroller = new CenterSmoothScroller(recyclerView.getContext());
        centerSmoothScroller.setTargetPosition(position);
        startSmoothScroll(centerSmoothScroller);
    }
}
