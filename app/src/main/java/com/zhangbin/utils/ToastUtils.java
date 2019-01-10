package com.zhangbin.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * @Package: com.zhangbin.utils
 * @ClassName: ToastUtils
 * @Description: toast类
 * @Author: 张彬
 * @CreateDate: 2018/12/7
 */
public class ToastUtils {
    private static ToastAdapter mAdapter;
    private static Toast mToast;
    private ToastUtils() {
        throw new UnsupportedOperationException("不能被实例化");
    }
/**
 * @description  系统短吐司
 * @param  context context对象
 * @param  message 内容(R.string.xxxxxx也可以String)
 * @author 张彬
 * @time 2018/12/7 22:29
 */
    public static void showShortSystemToast(Context context, Object message) {
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showDurationToast(context, toastMessage, Toast.LENGTH_SHORT);
    }
    /**
     * @description  系统长吐司
     * @param  context context对象
     * @param  message  内容(R.string.xxxxxx也可以String)
     * @author 张彬
     * @time 2018/12/7 22:30
     */
    public static void showLongSystemToast(Context context, Object message) {
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showDurationToast(context, toastMessage, Toast.LENGTH_LONG);
    }
    /**
     * @description  自定义时长,吐司
     * @param  context context对象
     * @param  message 内容(R.string.xxxxxx也可以String)
     * @param  duration 时长
     * @author 张彬
     * @time 2018/12/7 22:29
     */
    public static void showDurationToast(Context context, Object message,int duration) {
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showToast(context, toastMessage, duration);
    }
    /**
     * @description 自定义位置的系统短吐司
     * @param context context对象
     * @param message 内容(R.string.xxxxxx也可以String)
     * @param gravity 位置(eg:int gavity = Gravity.CENTER| Gravity.BOTTOM)
     * @param xOffset  x方向偏移量,正数
     * @param yOffset  y方向偏移量,负数
     * @author 张彬
     * @time 2018-12-31 12:09
     */
    public static void showShortLocationToast(Context context,Object message,int gravity,int xOffset,int yOffset){
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showDurationLocationToast(context,toastMessage,gravity,xOffset,yOffset,Toast.LENGTH_SHORT);

    }
    /**
     * @description 自定义位置的系统长吐司
     * @param context context对象
     * @param message 内容(R.string.xxxxxx也可以String)
     * @param gravity 位置(eg:int gavity = Gravity.CENTER| Gravity.BOTTOM)
     * @param xOffset  x方向偏移量,正数
     * @param yOffset  y方向偏移量,负数
     * @author 张彬
     * @time 2018-12-31 12:09
     */
    public static void showLongLocationToast(Context context,Object message,int gravity,int xOffset,int yOffset){
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showDurationLocationToast(context,toastMessage,gravity,xOffset,yOffset,Toast.LENGTH_LONG);
    }
    /**
     * @description 自定义位置+自定义时长吐司
     * @param context context对象
     * @param message 内容(R.string.xxxxxx也可以String)
     * @param gravity 位置(eg:int gavity = Gravity.CENTER| Gravity.BOTTOM)
     * @param xOffset  x方向偏移量,正数
     * @param yOffset  y方向偏移量,负数
     * @param duration  自定义时长
     * @author 张彬
     * @time 2018-12-31 12:09
     */
    public static void showDurationLocationToast(Context context,Object message,int gravity,int xOffset,int yOffset,int duration){
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showLocationToast(context,toastMessage,gravity,xOffset,yOffset,0,0,duration);
    }
    /**
     * @description 自定义图片+文字 自定义位置的系统短吐司
     * @param context context对象
     * @param message 内容(R.string.xxxxxx也可以String)
     * @param gravity 位置(eg:int gavity = Gravity.CENTER| Gravity.BOTTOM)
     * @param xOffset  x方向偏移量,正数
     * @param yOffset  y方向偏移量,负数
     * @param imageResource  图片资源
     * @author 张彬
     * @time 2018-12-31 12:11
     */
    public static void showShortLocationImageToast(Context context,Object message,int gravity,int xOffset,int yOffset,int imageResource){
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showDurationLocationImageToast(context,toastMessage,gravity,xOffset,yOffset,imageResource,Toast.LENGTH_SHORT);
    }
    /**
     * @description 自定义图片+文字 自定义位置的系统长吐司
     * @param context context对象
     * @param message 内容(R.string.xxxxxx也可以String)
     * @param gravity 位置(eg:int gavity = Gravity.CENTER| Gravity.BOTTOM)
     * @param xOffset  x方向偏移量,正数
     * @param yOffset  y方向偏移量,负数
     * @param imageResource  图片资源
     * @author 张彬
     * @time 2018-12-31 12:12
     */
    public static void showLongLocationImageToast(Context context,Object message,int gravity,int xOffset,int yOffset,int imageResource){
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showDurationLocationImageToast(context,toastMessage,gravity,xOffset,yOffset,imageResource,Toast.LENGTH_LONG);
    }
    /**
     * @description 自定义图片+文字位置+自定义时长  吐司
     * @param context context对象
     * @param message 内容(R.string.xxxxxx也可以String)
     * @param gravity 位置(eg:int gavity = Gravity.CENTER| Gravity.BOTTOM)
     * @param xOffset  x方向偏移量,正数
     * @param yOffset  y方向偏移量,负数
     * @param imageResource  图片资源
     * @param duration  时长
     * @author 张彬
     * @time 2018-12-31 12:12
     */
    public static void showDurationLocationImageToast(Context context,Object message,int gravity,int xOffset,int yOffset,int imageResource,int duration){
        String type = message.getClass().getSimpleName();
        String toastMessage ="";
        if("String".equals(type)){
            toastMessage = (String) message;
        } else if("Integer".equals(type)){
            toastMessage = (String) context.getResources().getText((Integer) message);
        }
        showLocationToast(context,toastMessage,gravity,xOffset,yOffset,imageResource,0,duration);
    }
    private static void showLocationToast(Context context, CharSequence charSequence, int gravity, int xOffset, int yOffset, int imageResource, int layoutResource, int duration) {
        boolean flag = (mAdapter == null || mAdapter.displayable());
        if (!flag)
            return;
        xOffset = xOffset >0?xOffset:-xOffset;
        yOffset = yOffset <0?yOffset:-yOffset;
        if (Looper.getMainLooper() == Looper.myLooper())
            obtainLocationShowToast(context,charSequence,gravity,xOffset,yOffset,imageResource,layoutResource,duration);
        else
            showLocationToastOnUiThread(context,charSequence,gravity,xOffset,yOffset,imageResource,layoutResource,duration);
    }

    /**
     * @description 字符型自定义时长吐司
     * @param  context  context对象
     * @param  charSequence  字符型接口
     * @param  duration  时长
     * @author 张彬
     * @time 2018/12/7 22:33
     */
    private static void showToast(Context context, CharSequence charSequence,int duration){
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
    private static void showToastOnUiThread(final Context context, final CharSequence charSequence, final int duration) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                obtainAndShowToast(context, charSequence, duration);
            }
        });
    }


    @SuppressLint("ShowToast")
    private static void obtainLocationShowToast(final Context context, final CharSequence charSequence,final int gravity,final int xOffset,final int yOffset,final int imageResource,final int layoutResource,final int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), charSequence, duration);
            mToast.setText(charSequence);
            mToast.setGravity(gravity, xOffset, yOffset);
            LinearLayout layout = (LinearLayout) mToast.getView();
            ImageView image = new ImageView(context.getApplicationContext());
           image.setImageResource(imageResource);
           layout.addView(image, 0);
           //TODO Toast自定义布局暂时先不写了
            mToast.setDuration(duration);
        } else {
            mToast.setText(charSequence);
            mToast.setGravity(gravity, xOffset, yOffset);
            mToast.setDuration(duration);
        }
        mToast.show();
    }
    private static void showLocationToastOnUiThread(final Context context, final CharSequence charSequence,
    final int gravity, final int xOffset, final int yOffset, final int imageResource,
        final int layoutResource, final int duration) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                obtainLocationShowToast(context,charSequence,gravity,xOffset,yOffset,imageResource,layoutResource,duration);
            }
        });
    }
}
