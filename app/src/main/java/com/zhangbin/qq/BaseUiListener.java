package com.zhangbin.qq;

import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import com.zhangbin.activity.LoginActivity;
import com.zhangbin.activity.MainActivity;
import com.zhangbin.bean.QQLoginBean;
import com.zhangbin.utils.LogUtils;

public class BaseUiListener implements IUiListener {

    @Override
    public void onComplete(Object o) {

    }

    @Override
    public void onError(UiError uiError) {

    }

    @Override
    public void onCancel() {
        LogUtils.d("zhangbin111","111");
    }
}
