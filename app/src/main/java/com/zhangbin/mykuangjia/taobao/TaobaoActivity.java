package com.zhangbin.mykuangjia.taobao;

import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.LinearLayout;

import com.zhangbin.mykuangjia.R;
import com.zhangbin.mykuangjia.taobao.adapter.TaobaoAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class TaobaoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<HashMap<String,Object>> mapArrayList;
    private VirtualLayoutManager mVirtualLayoutManager;
    private Context mContext;
    private TaobaoAdapter linearLayoutAdapter;
    DelegateAdapter delegateAdapter;
    List<DelegateAdapter.Adapter> adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taobao);
        mContext = this;
        initView();
        initData();
        initAdapter();

    }



    private void initView() {
        mRecyclerView = findViewById(R.id.taobao_recycler_view);
        mVirtualLayoutManager = new VirtualLayoutManager(mContext);

    }
    /**
     * 添加数据
     */
    private void initData() {
        mapArrayList = new ArrayList<>();
        HashMap<String,Object> map;
        for (int i=0;i<100;i++){
            map = new HashMap<>();
            map.put("ItemTitle","第"+i+"行");
            map.put("ItemImage",R.mipmap.ic_launcher);
            mapArrayList.add(map);
        }
        adapters = new LinkedList<>();

    }
    private void initAdapter() {
        mRecyclerView.setLayoutManager(mVirtualLayoutManager);
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,10);
        linearLayoutShow();

    }

    /**
     * 线性布局
     */
    private void linearLayoutShow() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(4);
        linearLayoutHelper.setPadding(10,10,10,10);
        linearLayoutHelper.setMargin(20,20,20,20);
        linearLayoutHelper.setAspectRatio(6);
        //设置分割线
        linearLayoutHelper.setDividerHeight(10);
        //设置下边据
        linearLayoutHelper.setMarginBottom(10);
        //设置背景颜色
        //linearLayoutHelper.setBgColor();
        linearLayoutAdapter =new TaobaoAdapter(mapArrayList,mContext,20,linearLayoutHelper);


        adapters.add(linearLayoutAdapter);
        delegateAdapter = new DelegateAdapter(mVirtualLayoutManager);
        delegateAdapter.setAdapters(adapters);

        mRecyclerView.setAdapter(delegateAdapter);

    }


}
