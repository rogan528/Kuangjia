package com.zhangbin.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.widget.Toast;

public class ToastUtils {
    private static ToastAdapter mAdapter;
    private static Toast mToast;
    private ToastUtils() {
        throw new UnsupportedOperationException("不能被实例化");
    }
/**
 * @description  系统短吐司
 * @param  context context对象
 * @param  message 内容
 * @return  系统时长,短吐司使用
 * @author 张彬
 * @time 2018/12/7 22:29
 */
    public static void showShortSystemToast(Context context, String message) {
        showToast(context, message, Toast.LENGTH_SHORT);
    }
    /**
     * @description  系统长吐司
     * @param  context context对象
     * @param  message  内容
     * @return  系统时长,长吐司使用
     * @author 张彬
     * @time 2018/12/7 22:30
     */
    public static void showLongSystemToast(Context context, String message) {
        showToast(context, message, Toast.LENGTH_LONG);
    }
    /**
     * @description  自定义时长,吐司
     * @param  context context对象
     * @param  message 内容
     * @param  duration 时长
     * @return  自定义时长.吐司使用
     * @author 张彬
     * @time 2018/12/7 22:29
     */
    public static void showDurationToast(Context context, String message,int duration) {
        showToast(context, message, duration);
    }
    /**
     * @description  通过ID资源，系统短吐司
     * @param  context context对象
     * @param  resId 资源ID:getResources().getString(R.string.xxxxxx);
     * @return  通过ID资源，系统短吐司
     * @author 张彬
     * @time 2018/12/7 22:32
     */
    public static void showShortByIdSystemToast(Context context,@StringRes int resId){
        showByIdDurationToast(context,resId,Toast.LENGTH_SHORT);
    }
    /**
     * @description  通过ID资源，系统长吐司
     * @param  context context对象
     * @param  resId 资源ID:getResources().getString(R.string.xxxxxx);
     * @return  通过ID资源，系统短吐司
     * @author 张彬
     * @time 2018/12/7 22:32
     */
    public static void showLongByIdSystemToast(Context context,@StringRes int resId){
        showByIdDurationToast(context,resId,Toast.LENGTH_SHORT);
    }
    /**
     * @description  通过ID资源，自定义时长吐司
     * @param  context context对象
     * @param  resId 资源ID:getResources().getString(R.string.xxxxxx);
     * @param  duration 时长
     * @return  自定义时间使用
     * @author 张彬
     * @time 2018/12/7 22:33
     */
    public static void showByIdDurationToast(Context context, @StringRes int resId, int duration){
        showToast(context,context.getResources().getText(resId),duration);
    }
    /**
     * @description 字符型自定义时长吐司
     * @param  context  context对象
     * @param  charSequence  字符型接口
     * @param  duration  时长
     * @return  字符型自定义时长吐司
     * @author 张彬
     * @time 2018/12/7 22:33
     */
    public static void showToast(Context context, CharSequence charSequence,int duration){
        boolean flag = (mAdapter == null || mAdapter.displayable());
        if (!flag)
            return;
        if (Looper.getMainLooper() == Looper.myLooper())
            obtainAndShowToast(context, charSequence, duration);
        else
            showToastOnUiThread(context, charSequence, duration);
    }
/**
 * @description 取消吐司
 * @return 取消吐司
 * @author 张彬
 * @time 2018/12/7 22:54
 */
    public static void cancelToast() {
        boolean cancelFlag = (mToast!=null && (mAdapter == null || mAdapter.cancellable()));
        if (!cancelFlag)
            return;
        mToast.cancel();
    }

    public interface ToastAdapter {
        boolean displayable();
        boolean cancellable();
    }

    public static void setToastAdapter(ToastAdapter adapter) {
        mAdapter = adapter;
    }

    private static void showToastOnUiThread(final Context context, final CharSequence charSequence, final int duration) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                obtainAndShowToast(context, charSequence, duration);
            }
        });
    }

    @SuppressLint("ShowToast")
    private static void obtainAndShowToast(final Context context, final CharSequence charSequence, final int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), charSequence, duration);
        } else {
            mToast.setText(charSequence);
            mToast.setDuration(duration);
        }
        mToast.show();
    }
}
