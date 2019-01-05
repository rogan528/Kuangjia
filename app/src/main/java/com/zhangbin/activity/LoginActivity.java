package com.zhangbin.activity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.zhangbin.R;
import com.zhangbin.utils.ToastUtils;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText etZh;//账号
    private EditText etMm;//密码
    private TextView hintMm;//显示/隐藏密码
    private TextView tvLogin;//登录
    private Button tvRegister;//注册
    private TextView tvForget;//忘记密码
    private String strZh;//账号
    private String strMm;//密码
    private boolean isHaveZh;//是否输入账号
    private boolean isHaveMm;//是否输入密码
    private InputMethodManager imm;//键盘管理器
    private boolean isShowPwd;//是否显示密码
    private Toast mExitToast;//退出App提示
    private boolean mToExitYcard = false;//是否已点击两次返回按钮
    public static final String USER_ID = "userId";//用户ID
    public static final String USER_NAME = "userName";//用户ID
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        initView();
    }
    private void initView() {
        etZh = (EditText) findViewById(R.id.user_tel);//账号
        etMm = (EditText) findViewById(R.id.user_password);//密码
        hintMm = (TextView) findViewById(R.id.hint_pwd);//显示/隐藏密码
        hintMm.setOnClickListener(this);
        tvLogin = (TextView) findViewById(R.id.user_btn_login);//登录
        tvLogin.setOnClickListener(this);
        tvRegister = (Button) findViewById(R.id.tv_register);//注册
        tvRegister.setOnClickListener(this);
        tvForget = (TextView) findViewById(R.id.tv_forget_password);//忘记密码
        tvForget.setOnClickListener(this);

        etZh.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString().trim())) {
                    isHaveZh = true;
                    setBtnClick();
                } else {
                    isHaveZh = false;
                    setBtnEnClick();
                }
            }

        });

        etMm.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!TextUtils.isEmpty(s.toString().trim())) {
                    isHaveMm = true;
                    setBtnClick();
                } else {
                    isHaveMm = false;
                    setBtnEnClick();
                }
            }
        });
    }
    /**
     * 设置按钮不可点击样式
     */
    private void setBtnEnClick() {
        // 登录按钮
        tvLogin.setBackgroundResource(R.drawable.submit_btn_grey);
        tvLogin.setEnabled(false);
        tvLogin.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.btn_grey_tv_color));
    }

    /**
     * 设置按钮可点击样式
     */
    private void setBtnClick() {
        if (isHaveZh && isHaveMm) {
            // 登录按钮
            tvLogin.setBackgroundResource(R.drawable.submit_btn);
            tvLogin.setEnabled(true);
            tvLogin.setTextColor(ContextCompat.getColor(LoginActivity.this, R.color.common_white));
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.user_btn_login://登录
                signIn();
                //ToastUtils.showShortSystemToast(LoginActivity.this,"登录");
                break;
            case R.id.hint_pwd:// 显示/隐藏密码
                if (isShowPwd) {
                    isShowPwd = false;
                    hintMm.setBackgroundResource(R.drawable.hint_pwd);
                    etMm.setTransformationMethod(PasswordTransformationMethod
                            .getInstance());
                    etMm.setSelection(etMm.getText().toString().length());
                } else {
                    isShowPwd = true;
                    hintMm.setBackgroundResource(R.drawable.hint_no_pwd);
                    etMm.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());
                    etMm.setSelection(etMm.getText().toString().length());
                }
                break;
            case R.id.tv_register://注册
                ToastUtils.showShortSystemToast(LoginActivity.this,"注册");
                requestLogin();
                break;
            case R.id.tv_forget_password://忘记密码
                //requestLogin();
                break;
        }
    }
/**
 * 登录
 */
    private void signIn() {
        EMClient.getInstance().login(etZh.getText().toString().trim(), etMm.getText().toString().trim(), new EMCallBack() {
            @Override
            public void onSuccess() {
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }

            @Override
            public void onError(int i, String s) {
                Log.e("zhangbin123","登录失败"+i+","+s);
            }

            @Override
            public void onProgress(int i, String s) {

            }
        });
    }

    private void requestLogin() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    EMClient.getInstance().createAccount(etZh.getText().toString().trim(),etMm.getText().toString().trim());
                } catch (HyphenateException e) {
                    e.printStackTrace();
                    Log.e("zhangbin123","注册失败"+e.getErrorCode()+","+e.getMessage());
                }
            }
        }).start();
    }
}
