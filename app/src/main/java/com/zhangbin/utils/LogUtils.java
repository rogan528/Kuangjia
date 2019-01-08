package com.zhangbin.utils;

import android.util.Log;

public class LogUtils {
    private static boolean ISDEBUG = Constants.IS_DEBUG;
    public static void e(String tag,String msg){
        if (ISDEBUG){
            Log.e(tag,msg);
        }
    }
    public static void w(String tag,String msg){
        if (ISDEBUG){
            Log.w(tag,msg);
        }
    }
    public static void i(String tag,String msg){
        if (ISDEBUG){
            Log.i(tag,msg);
        }
    }
    public static void d(String tag,String msg){
        if (ISDEBUG){
            Log.d(tag,msg);
        }
    }
    public static void v(String tag,String msg){
        if (ISDEBUG){
            Log.v(tag,msg);
        }
    }
}
