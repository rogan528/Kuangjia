package com.zhangbin.mykuangjia.liandong.recyclerview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.zhangbin.mykuangjia.R;
import com.zhangbin.mykuangjia.liandong.recyclerview.bean.RightBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Author  : MinKin.
 * Date    : 2019/10/31
 * Version : 1.0
 * Desc    : 右测适配器
 */
public class RightAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /**
     * Item类型
     */
    public static final int TITLE = 1;
    public static final int CONTENT = 2;

    private Context mContext;
    private LayoutInflater mInflater;
    private List<RightBean> mDatas;

    public RightAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    public void addData(List<RightBean> datas) {
        mDatas = datas;
        notifyDataSetChanged();
    }

    public List<RightBean> getDatas() {
        return mDatas;
    }

    @Override
    public int getItemViewType(int position) {
        RightBean rightVo = mDatas.get(position);
        return rightVo.getItemType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case RightAdapter.TITLE:
                return new TitleViewHolder(mInflater.inflate(R.layout.recyclerview_item_right_title, parent, false));
            case RightAdapter.CONTENT:
                return new ContentViewHolder(mInflater.inflate(R.layout.recyclerview_item_right_content, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RightBean rightVo = mDatas.get(position);
        switch (getItemViewType(position)) {
            case RightAdapter.TITLE:
                TitleViewHolder titleViewHolder = (TitleViewHolder) holder;
                titleViewHolder.tvRightTitle.setText(rightVo.getTitle());
                break;
            case RightAdapter.CONTENT:
                ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
                contentViewHolder.tvRightContent.setText(rightVo.getTitle());
                /*Glide.with(mContext)
                        .load(rightVo.getImage())
                        .into(contentViewHolder.ivRightContent);*/
                contentViewHolder.ivRightContent.setImageResource(R.mipmap.ic_launcher);
                break;
        }
    }

    @Override
    public int getItemCount() {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        return mDatas.size();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    switch (mDatas.get(position).getItemType()) {
                        case RightAdapter.TITLE:
                            return 3;                //Title占3份
                        case RightAdapter.CONTENT:
                            return 1;                //Content占1份
                    }
                    return 1;
                }
            });
        }
    }

    static class TitleViewHolder extends RecyclerView.ViewHolder {

        TextView tvRightTitle;

        TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRightTitle = itemView.findViewById(R.id.tv_right_title);
        }
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {

        TextView tvRightContent;
        ImageView ivRightContent;

        ContentViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRightContent = itemView.findViewById(R.id.tv_right_content);
            ivRightContent = itemView.findViewById(R.id.iv_right_content);
        }
    }


}
