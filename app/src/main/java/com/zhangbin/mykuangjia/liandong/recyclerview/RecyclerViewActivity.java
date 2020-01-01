package com.zhangbin.mykuangjia.liandong.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.zhangbin.mykuangjia.R;
import com.zhangbin.mykuangjia.liandong.recyclerview.adapter.LeftAdapter;
import com.zhangbin.mykuangjia.liandong.recyclerview.adapter.RightAdapter;
import com.zhangbin.mykuangjia.liandong.recyclerview.bean.LeftBean;
import com.zhangbin.mykuangjia.liandong.recyclerview.bean.RightBean;
import com.zhangbin.mykuangjia.liandong.recyclerview.datautils.DataUtil;
import com.zhangbin.mykuangjia.liandong.recyclerview.layoutmanager.CenterLayoutManager;

import org.json.JSONException;

import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mRvLeft, mRvRight;

    private LeftAdapter mLeftAdapter;
    private RightAdapter mRightAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        initLeftData();
        initRightData();
        initListener();
    }
    private void initView() {
        mRvLeft = findViewById(R.id.rv_left);
        mRvRight = findViewById(R.id.rv_right);
    }

    /**
     * 初始化左侧数据
     */
    private void initLeftData() {
        try {
            List<LeftBean> leftData = DataUtil.getLeftData(this);
            mLeftAdapter = new LeftAdapter(this);
            mRvLeft.setLayoutManager(new CenterLayoutManager(this));
            mRvLeft.setAdapter(mLeftAdapter);
            mLeftAdapter.addData(leftData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化右侧数据
     */
    private void initRightData() {
        try {
            List<RightBean> rightData = DataUtil.getRightData(this);
            mRightAdapter = new RightAdapter(this);
            mRvRight.setLayoutManager(new GridLayoutManager(this, 3));
            mRvRight.setAdapter(mRightAdapter);
            mRightAdapter.addData(rightData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    private void initListener() {
        mLeftAdapter.setOnItemClickListener(new LeftAdapter.OnItemClickListener() {

            @Override
            public void onItemClick(View v, int position) {
                //左侧滑动到中间
                mRvLeft.smoothScrollToPosition(position);
                //左侧刷新状态
                mLeftAdapter.notifyGlobal(position);
                //右侧滑动到相应位置
                GridLayoutManager layoutManager = (GridLayoutManager) mRvRight.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.scrollToPositionWithOffset(DataUtil.getTitlePosSa().get(position), 0);
                }

            }
        });

        mRvRight.addOnScrollListener(new RecyclerView.OnScrollListener() {

            int firstVisibleItemPosition;

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //左侧滑动到中间,等滑动停止再操作,防止卡顿
                    int position = mRightAdapter.getDatas().get(firstVisibleItemPosition).getFakePosition();
                    mRvLeft.smoothScrollToPosition(position);
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                GridLayoutManager layoutManager = (GridLayoutManager) mRvRight.getLayoutManager();
                if (layoutManager != null) {
                    //左侧刷新状态
                    firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition();
                    int position = mRightAdapter.getDatas().get(firstVisibleItemPosition).getFakePosition();
                    mLeftAdapter.notifyGlobal(position);
                }
            }
        });
    }
}
