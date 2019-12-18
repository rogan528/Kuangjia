package com.zhangbin.mykuangjia.taobao;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import com.zhangbin.mykuangjia.R;

public class TaobaoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taobao);
        initView();
        initData();

    }

    /**
     * 添加数据
     */
    private void initData() {

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.taobao_recycler_view);
    }

}
