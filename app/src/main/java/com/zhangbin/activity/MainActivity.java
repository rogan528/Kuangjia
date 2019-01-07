package com.zhangbin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.zhangbin.adpter.HomeAdapter;
import com.zhangbin.R;
import com.zhangbin.alipay.AlixDemo;
import com.zhangbin.bean.Bean;
import com.zhangbin.bean.BeautyBean;
import com.zhangbin.bean.TestBean;
import com.zhangbin.qq.BaseUiListener;
import com.zhangbin.utils.JsonListUtils;
import com.zhangbin.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity implements View.OnClickListener{
    private RecyclerView mRecylerView ;
    private Button btn ;
    private EditText editText;
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
                //Boolean b = SPUtils.getInstance().clearKey(SPUtils.XMLKeyName.FIRST_LOGIN);
                testData();
                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_LONG).show();

            }
        });
    }

    private void testData() {
        List<TestBean> list = new ArrayList<>();
        TestBean testBean1= new TestBean("test11", 1, 11, true);
        TestBean testBean2= new TestBean("test12", 2, 22, false);
        list.add(testBean1);
        list.add(testBean2);
        SPUtils.getInstance().setParam("test",list);
        String json1 = (String) SPUtils.getInstance().getParam("test","");
        List<TestBean> objects1 = JsonListUtils.jsonToList(json1,TestBean.class);
        Log.e("zhangbin111","---"+objects1.size());
        for (int i=0;i<objects1.size();i++){
            Log.e("zhangbin111","---1---"+objects1.get(i).name);
        }
        List<String> list2 = new ArrayList<>();
        list2.add("test21");
        list2.add("test22");
        SPUtils.getInstance().setParam("test2",list2);
        String json2 = (String) SPUtils.getInstance().getParam("test2","");
        List<String> objects2 = JsonListUtils.jsonToList(json2,String.class);
        Log.e("zhangbin111","---"+objects2.size());
        for (int i=0;i<objects2.size();i++){
            Log.e("zhangbin111","---2--"+objects2.get(i));
        }
        List<Bean> list3 = new ArrayList<>();
        Bean.TeamUserList test311 = new Bean.TeamUserList("311", "test311");
        Bean.TeamUserList test312 = new Bean.TeamUserList("312", "test312");
        List<Bean.TeamUserList> userList = new ArrayList<>();
        userList.add(test311);
        userList.add(test312);
        Bean.BeautyBean user1 = new Bean.BeautyBean("user1", 1);
        Bean.BeautyBean user2 = new Bean.BeautyBean("user2", 2);
        List<Bean.BeautyBean> beautyBeanListList = new ArrayList<>();
        beautyBeanListList.add(user1);
        beautyBeanListList.add(user2);
        Bean.Result result = new Bean.Result(userList, beautyBeanListList);
        Bean bean1 = new Bean("1", "成功", result);
        Bean bean2 = new Bean("2", "失败", result);
        list3.add(bean1);
        list3.add(bean2);
        SPUtils.getInstance().setParam("test3",list3);
        String json3 = (String) SPUtils.getInstance().getParam("test3","");
        List<Bean> objects3 = JsonListUtils.jsonToList(json3,Bean.class);
        for (int i=0;i<objects3.size();i++){
            Log.e("zhangbin111","---i--"+i+"----"+objects3.size());
            List<Bean.BeautyBean> beautyBeanList = objects3.get(i).result.beautyBeanList;
            for (int j = 0;j<beautyBeanList.size();j++) {
                Log.e("zhangbin111", "---3--" + beautyBeanList.get(j).name);
            }
        }

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
        editText = findViewById(R.id.ed_text);

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
        Intent intent = new Intent(this,AlixDemo.class);
        startActivity(intent);
    }

    private void clickBtn() {
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
