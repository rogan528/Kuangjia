package com.zhangbin.activity;

import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.zhangbin.adpter.HomeAdapter;
import com.zhangbin.R;
import com.zhangbin.alipay.AlixDemo;
import com.zhangbin.bean.BeautyBean;
import com.zhangbin.qq.BaseUiListener;
import com.zhangbin.utils.ToastUtils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener{
    private RecyclerView mRecylerView ;
    private Button btn ;
    private List<BeautyBean> list;
    private HomeAdapter homeAdapter;
    private Tencent mTencent;

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
        /*LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);*/
        StaggeredGridLayoutManager recyclerViewLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecylerView.setLayoutManager(recyclerViewLayoutManager);
        mRecylerView.setAdapter(homeAdapter);
        homeAdapter.setItemClikListener(new HomeAdapter.OnItemClikListener() {
            @Override
            public void onItemClik(View view, int position) {
                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_LONG).show();
            }
        });
    }


    private void initData() {
        list = new ArrayList<BeautyBean>();
        BeautyBean bean;
            bean = new BeautyBean("美女" + 1, R.mipmap.meinv1);
            list.add(bean);
            bean = new BeautyBean("美女" + 2, R.mipmap.meinv2);
            list.add(bean);
            bean = new BeautyBean("美女" + 3, R.mipmap.meinv3);
            list.add(bean);
            bean = new BeautyBean("美女" + 4, R.mipmap.meinv4);
            list.add(bean);
        Log.e("zhangbin","----"+list.size());
        btn.setOnClickListener(this);

    }

    private void initView() {
        mRecylerView = (RecyclerView)findViewById(R.id.id_recyleview);
        btn = (Button)findViewById(R.id.btn_login);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                //clickBtn();
                Test();
                break;
        }
    }

    private void Test() {
        String s = "http://www.badidu.com/aa.html?";
        ToastUtils.showShortSystemToast(this,s.substring(25,29));
        Intent intent = new Intent(this,AlixDemo.class);
        startActivity(intent);
    }

    private void clickBtn() {
        ToastUtils.showLongSystemToast(this,"11111");
        login();
    }
    public void login()
    {
        mTencent = Tencent.createInstance("222222", this.getApplicationContext());
        if (!mTencent.isSessionValid())
        {
            mTencent.login(this, "all", listener);
        }
    }
    IUiListener listener = new BaseUiListener(){
        @Override
        public void onComplete(Object o) {
            super.onComplete(o);
        }
    };
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mTencent.onActivityResult(requestCode, resultCode, data);
    }
}
