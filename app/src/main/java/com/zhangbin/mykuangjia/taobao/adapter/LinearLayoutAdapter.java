package com.zhangbin.mykuangjia.taobao.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;

public class LinearLayoutAdapter  extends DelegateAdapter.Adapter{
    @Override
    public LayoutHelper onCreateLayoutHelper() {
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper();
        linearLayoutHelper.setItemCount(4);
        linearLayoutHelper.setPadding(10,10,10,10);
        linearLayoutHelper.setMargin(20,20,20,20);
        linearLayoutHelper.setAspectRatio(6);
        //设置分割线
        linearLayoutHelper.setDividerHeight(10);
        //设置下边据
        linearLayoutHelper.setMarginBottom(10);
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
