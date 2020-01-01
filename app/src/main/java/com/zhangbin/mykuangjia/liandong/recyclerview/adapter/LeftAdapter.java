package com.zhangbin.mykuangjia.liandong.recyclerview.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.zhangbin.mykuangjia.R;
import com.zhangbin.mykuangjia.liandong.recyclerview.bean.LeftBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Version : 1.0
 * Desc    : 左侧适配器
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private LayoutInflater mInflater;
    private List<LeftBean> mDatas;

    public LeftAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    /**
     * 初始化添加数据
     */
    public void addData(List<LeftBean> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    /**
     * 全局刷新
     */
    public void notifyGlobal(int position){
        for (int i = 0; i < mDatas.size(); i++) {
            if (i == position) {
                mDatas.get(i).setSelected(true);
            } else {
                mDatas.get(i).setSelected(false);
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LeftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(mInflater.inflate(R.layout.recyclerview_item_left, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LeftAdapter.ViewHolder holder, int position) {
        LeftBean leftVo = mDatas.get(position);
        if (leftVo.isSelected()) {
            Drawable indicator = ContextCompat.getDrawable(mContext, R.drawable.shape_indicator);
            if (indicator != null) {
                indicator.setBounds(0, 0, indicator.getIntrinsicWidth(), indicator.getIntrinsicHeight());
                holder.tvLeft.setCompoundDrawables(indicator, null, null, null);
            }
            holder.tvLeft.setBackgroundColor(Color.parseColor("#FFF9F9F9"));
        } else {
            holder.tvLeft.setCompoundDrawables(null, null, null, null);
            holder.tvLeft.setBackgroundColor(Color.parseColor("#FFFFFFFF"));
        }
        holder.tvLeft.setText(leftVo.getTitle());
        holder.tvLeft.setTag(position);
        holder.tvLeft.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        return mDatas.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(v, (Integer) v.getTag());
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvLeft;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvLeft = itemView.findViewById(R.id.tv_left);
        }
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }
}
