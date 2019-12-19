package com.zhangbin.mykuangjia.taobao;

import android.content.Context;
import android.os.Bundle;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.GridView;
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
    private TaobaoAdapter linearLayoutAdapter,stickyLayoutAdapter,gridLayoutAdapter;
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
        //adapters = new LinkedList<>();

    }
    private void initAdapter() {
        mRecyclerView.setLayoutManager(mVirtualLayoutManager);
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        mRecyclerView.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,10);
        delegateAdapter = new DelegateAdapter(mVirtualLayoutManager);
        linearLayoutShow();
        stickyLayoutShow();
        gridLayoutShow();
        mRecyclerView.setAdapter(delegateAdapter);

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


        //adapters.add(linearLayoutAdapter);

        //delegateAdapter.setAdapters(adapters);
        delegateAdapter.addAdapter(linearLayoutAdapter);


    }

    private void stickyLayoutShow() {
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelper.setItemCount(1);
        stickyLayoutHelper.setAspectRatio(3);
        stickyLayoutHelper.setStickyStart(true);
        stickyLayoutAdapter = new TaobaoAdapter(mapArrayList,mContext,20,stickyLayoutHelper){
            @Override
            public void onBindViewHolder(@NonNull TaobaoAdapter.MainViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (position ==0){
                    holder.textView.setText("Stick");

                }

            }
        };

        delegateAdapter.addAdapter(stickyLayoutAdapter);
    }
    private void gridLayoutShow() {
        //--------------网格布局-------------------->
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(3);
        gridLayoutHelper.setAspectRatio(6);
        //设置权重 就是一行中多个控件的比例  注意 加起来要等于100
        gridLayoutHelper.setWeights(new float[]{50,20,30});
        //设置垂直边距
        gridLayoutHelper.setVGap(20);
        //设置水平边距
        gridLayoutHelper.setHGap(20);
        //设置是否自动填充空白区域
        gridLayoutHelper.setAutoExpand(true);
        gridLayoutAdapter = new TaobaoAdapter(mapArrayList,this,20,gridLayoutHelper){
            @Override
            public void onBindViewHolder(@NonNull TaobaoAdapter.MainViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                //为了展示效果 将布局的不同位置的item进行背景颜色设置
                if(position<2){
                    holder.itemView.setBackgroundColor(0x66cc0000 + (position-6)*128);
                }else if(position%2 == 0){
                    holder.itemView.setBackgroundColor(0xaa22ff22);
                }else{
                    holder.itemView.setBackgroundColor(0xccff22ff);
                }
                if(position == 0){
                    holder.textView.setText("Grid");
                }
            }
        };
        delegateAdapter.addAdapter(gridLayoutAdapter);

    }
}
