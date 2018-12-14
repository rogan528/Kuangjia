package com.zhangbin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Bean> lists;
    private Context context;

    public HomeAdapter(Context context, List<Bean> lists) {
        this.context = context;
        this.lists = lists;
    }

    //创建View,被LayoutManager所用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //数据的绑定
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(lists.get(position).success);
        if(mOnItemClikListener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClikListener.onItemClik(holder.itemView,pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }
    //自定义ViewHolder,包含item的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
    public interface OnItemClikListener{
        void onItemClik(View view,int position);

    }
    private OnItemClikListener mOnItemClikListener;
    //对外设置item点击暴露的方法
    public void setItemClikListener(OnItemClikListener mOnItemClikListener ){
        this.mOnItemClikListener=mOnItemClikListener;
    }
}