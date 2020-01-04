package com.zhangbin.mykuangjia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.zhangbin.mykuangjia.liandong.recyclerview.RecyclerViewActivity;
import com.zhangbin.mykuangjia.taobao.TaobaoActivity;

public class MainActivity extends AppCompatActivity {
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        Log.e("zhangbin","MainActivity onCreate");
        findViewById(R.id.btn_taobao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, TaobaoActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_shuangrecycleview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("zhangbin","MainActivity onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("zhangbin","MainActivity onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("zhangbin","MainActivity onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("zhangbin","MainActivity onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        Log.e("zhangbin","MainActivity onSaveInstanceState");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("zhangbin","MainActivity onDestroy");
    }
}
