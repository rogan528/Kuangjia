package com.zhangbin.mykuangjia.taobao;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.ScrollFixLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.zhangbin.mykuangjia.R;
import com.zhangbin.mykuangjia.taobao.adapter.TaobaoAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaobaoActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList listItem;
    private Context mContext;
    private TaobaoAdapter linearLayoutAdapter,stickyLayoutAdapter,gridLayoutAdapter,scrollFixLayoutAdapter
            ,columnLayoutAdapter,singleLayoutAdapter,onePlusNLayoutAdapter,staggerGridLayoutAdapter;
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
        linearLayoutAdapter.setOnItemClickListener(new TaobaoAdapter.OnItemClickListener () {
            @Override
            public void onItemClickListener(int position) {
                Toast.makeText(mContext,"点击了第"+position+"个",Toast.LENGTH_LONG).show();
            }
        });

    }
    /**
     * 初始化控件
     */
    private void initView() {
        recyclerView = findViewById(R.id.my_recycler_view);
    }
    /**
     * 添加数据
     */
    private void initData() {
        listItem = new ArrayList<HashMap<String,Object>>();
        for (int i=0;i<100;i++){
            HashMap<String,Object> map = new HashMap<>();
            map.put("ItemTitle","第"+i+"行");
            map.put("ItemImage",R.mipmap.ic_launcher);
            listItem.add(map);
        }
    }

    /**
     * 适配器
     */
    private void initAdapter() {
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(mContext);
        recyclerView.setLayoutManager(virtualLayoutManager);
        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0,10);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        linearLayoutShow();
        stickyLayoutShow();
        gridLayoutShow();
        scrollFixLayoutShow();
        columnLayoutShow();
        singleLayoutShow();
        onePlusNLayoutShow();
        staggerGridLayoutShow();
        recyclerView.setAdapter(delegateAdapter);
    }




    /**
     * 
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
        linearLayoutAdapter =new TaobaoAdapter(listItem,mContext,20,linearLayoutHelper);
        delegateAdapter.addAdapter(linearLayoutAdapter);


    }

    /**
     * 定格布局
     */
    private void stickyLayoutShow() {
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        stickyLayoutHelper.setItemCount(1);
        stickyLayoutHelper.setAspectRatio(3);
        stickyLayoutHelper.setStickyStart(true);
        stickyLayoutAdapter = new TaobaoAdapter(listItem,mContext,1,stickyLayoutHelper){
            @Override
            public void onBindViewHolder(@NonNull TaobaoAdapter.MainViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (position ==0){
                    holder.textView.setText("我是定格控件");

                }

            }
        };

        delegateAdapter.addAdapter(stickyLayoutAdapter);
    }

    /**
     * 网格布局
     */
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
        gridLayoutAdapter = new TaobaoAdapter(listItem,this,20,gridLayoutHelper){
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

    /**
     * 固定布局
     */
    private void scrollFixLayoutShow() {
        //固定位置，x偏移量,y偏移量
        ScrollFixLayoutHelper scrollFixLayoutHelper = new ScrollFixLayoutHelper(ScrollFixLayoutHelper.BOTTOM_RIGHT,100,200);
        scrollFixLayoutHelper.setItemCount(1);
        scrollFixLayoutHelper.setPadding(10,10,10,10);
        scrollFixLayoutHelper.setMargin(20,20,20,20);
        scrollFixLayoutHelper.setBgColor(Color.GRAY);
        scrollFixLayoutHelper.setAspectRatio(6);
        scrollFixLayoutHelper.setShowType(ScrollFixLayoutHelper.SHOW_ON_ENTER);
        scrollFixLayoutAdapter= new TaobaoAdapter(listItem,mContext,1,scrollFixLayoutHelper){
            @Override
            public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (position ==0){
                    holder.textView.setText("固定布局");
                }
            }
        };
        delegateAdapter.addAdapter(scrollFixLayoutAdapter);
    }

    /**
     * 栅格栏布局
     */
    private void columnLayoutShow() {
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setPadding(10,10,10,10);
        columnLayoutHelper.setMargin(20,20,20,20);
        columnLayoutHelper.setAspectRatio(6);
        columnLayoutHelper.setWeights(new float[]{30,30,10,30});
        columnLayoutAdapter = new TaobaoAdapter(listItem,mContext,4,columnLayoutHelper){
            @Override
            public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (position ==0){
                    holder.textView.setText("栅格栏布局");
                    holder.itemView.setBackgroundColor(Color.RED);
                }else if (position ==1){
                    holder.itemView.setBackgroundColor(Color.YELLOW);
                }else {
                    holder.itemView.setBackgroundColor(Color.BLUE);
                }
            }
        };
        delegateAdapter.addAdapter(columnLayoutAdapter);
    }

    /**
     * 一格布局
     */
    private void singleLayoutShow(){
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        singleLayoutHelper.setPadding(10,10,10,10);
        singleLayoutHelper.setMargin(20,20,20,20);
        singleLayoutHelper.setAspectRatio(6);
        singleLayoutAdapter = new TaobaoAdapter(listItem,mContext,1,singleLayoutHelper){
            @Override
            public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (position ==0){
                    holder.textView.setText("一格布局");
                    holder.itemView.setBackgroundColor(Color.GRAY);
                }
            }
        };
        delegateAdapter.addAdapter(singleLayoutAdapter);
    }

    /**
     * 一拖N布局
     */
    private void onePlusNLayoutShow() {
        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper();
        //设置行比重
        onePlusNLayoutHelper.setColWeights(new float[]{40,60,30,30});
        //设置高比重
        onePlusNLayoutHelper.setRowWeight(50);
        onePlusNLayoutHelper.setPadding(10,10,10,10);
        onePlusNLayoutHelper.setMargin(20,20,20,20);
        //设置宽高比
        onePlusNLayoutHelper.setAspectRatio(3);
        onePlusNLayoutHelper.setItemCount(5);
        onePlusNLayoutAdapter = new TaobaoAdapter(listItem,mContext,4,onePlusNLayoutHelper){
            @Override
            public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                if (position ==0){
                    holder.itemView.setBackgroundColor(Color.RED);
                }else if (position ==1){
                    holder.itemView.setBackgroundColor(Color.BLUE);
                }else if(position ==2){
                    holder.itemView.setBackgroundColor(Color.BLACK);
                }else {
                    holder.itemView.setBackgroundColor(Color.GREEN);
                }

            }
        };
        delegateAdapter.addAdapter(onePlusNLayoutAdapter);

    }

    /**
     * 瀑布流布局
     */
    private void staggerGridLayoutShow() {
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper();
        staggeredGridLayoutHelper.setItemCount(20);
        staggeredGridLayoutHelper.setPadding(10,10,10,10);
        staggeredGridLayoutHelper.setMargin(20,20,20,20);
        staggeredGridLayoutHelper.setAspectRatio(3);
        //每行的个数
        staggeredGridLayoutHelper.setLane(3);
        //水平间距
        staggeredGridLayoutHelper.setHGap(20);
        staggeredGridLayoutHelper.setVGap(15);
        staggerGridLayoutAdapter = new TaobaoAdapter(listItem,mContext,20,staggeredGridLayoutHelper){
            @Override
            public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
                super.onBindViewHolder(holder, position);
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,150+position%5*20);
                holder.itemView.setLayoutParams(layoutParams);
                if (position >10){
                    holder.itemView.setBackgroundColor(0x66cc0000);
                }else if (position %2 ==0){
                    holder.itemView.setBackgroundColor(0xaa22ff22);
                }else {
                    holder.itemView.setBackgroundColor(0xccff22ff);
                }
            }
        };
        delegateAdapter.addAdapter(staggerGridLayoutAdapter);
    }
}
