package com.zhangbin.mykuangjia.taobao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.zhangbin.mykuangjia.R;

import java.util.ArrayList;
import java.util.HashMap;

public class TaobaoAdapter extends DelegateAdapter.Adapter<TaobaoAdapter.MainViewHolder> {
    private ArrayList<HashMap<String,Object>> mapArrayList;
    private Context mContext;
    private int count =0;
    LayoutHelper layoutHelper;

    public TaobaoAdapter(ArrayList<HashMap<String, Object>> mapArrayList, Context mContext, int count, LayoutHelper layoutHelper) {
        this.mapArrayList = mapArrayList;
        this.mContext = mContext;
        this.count = count;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    private OnItemClickListener onItemClickListener;
    //创建接口
    public interface OnItemClickListener{
        void onItemClickListener(int position);
    }
    //外界调用的方法
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(mContext).inflate(R.layout.taobao_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        final int layoutPosition = holder.getLayoutPosition ();
        //必须在itemView的点击事件里面判断
        holder.itemView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(onItemClickListener!=null){
                    onItemClickListener.onItemClickListener (layoutPosition);
                }
            }
        });
        holder.textView.setText((String) mapArrayList.get(position).get("ItemTitle"));
        holder.imageView.setImageResource((Integer) mapArrayList.get(position).get("ItemImage"));
    }
    @Override
    public int getItemCount() {
        return count;
    }
    public class MainViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;
        public ImageView imageView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.tv_item);
            imageView = itemView.findViewById(R.id.iv_item);
        }

        public TextView getTextView() {
            return textView;
        }

        public ImageView getImageView() {
            return imageView;
        }
    }
}
