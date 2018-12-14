package com.zhangbin;

import android.app.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private RecyclerView mRecylerView ;
    private List<Bean> list;
    private HomeAdapter homeAdapter;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        homeAdapter = new HomeAdapter(this,list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecylerView.setLayoutManager(linearLayoutManager);
        mRecylerView.setAdapter(homeAdapter);

        homeAdapter.setItemClikListener(new HomeAdapter.OnItemClikListener() {
            @Override
            public void onItemClik(View view, int position) {
                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_LONG).show();
            }
        });
    }


    private void initData() {
        list = new ArrayList<Bean>();
        for (int i = 0; i < 50; i++) {
            //list.add();
            Bean bean = new Bean();

            bean.success = "成功数据";
            list.add(bean);


        }
        Log.e("zhangbin","----"+list.size());

    }

    private void initView() {
        mRecylerView = (RecyclerView)findViewById(R.id.id_recyleview);

    }
}
