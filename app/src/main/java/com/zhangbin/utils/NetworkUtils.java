package com.zhangbin.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;

/**
 * @Package: com.zhangbin.utils
 * @ClassName: NetworkUtils
 * @Description: 网络状态的工具类
 * @Author: 张彬
 * @CreateDate: 2018/12/5
 * @UpdateDate: 2018/12/5
 * @UpdateRemark: 更新说明
 */
public class NetworkUtils {
    /**
     * @param context
     * @return WiFi是否打开状态.返回打开
     * @description WiFi是否打开，true是打开.但是不一定连接
     * @author 张彬
     * @time 2018/12/6 0:16
     */
    public static boolean isWiFiOpen(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        int wifiStatus = wifiManager.getWifiState();
        //3是打开状态
        if (wifiStatus == WifiManager.WIFI_STATE_ENABLED)
            return true;
        else
            return false;
    }

    /**
     * @param context
     * @return 网络是否连接,连接了不一定可以上网，有的需要认证
     * @description 网络是否连接, true是连接.但是不一定可以上网，有的需要认证
     * @author 张彬
     * @time 2018/12/6 0:13
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
  /**
   * @description 判断是否是WiFi连接
   * @param
   * @return  WiFi是否连接,true是连接.但是不一定可以上网，有些需要认证
   * @author 张彬
   * @time 2018/12/7 21:46
   */
    public static boolean isWiFiConnected(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && (networkInfo.getType() == ConnectivityManager.TYPE_WIFI));
    }
    /**
     * @return 网络是否可以上网，true可以上网。
     * @description 网络即使开启也不一定可以上网，移动网络或者wifi可以上网，都返回0
     * @author 张彬
     * @time 2018/12/6 0:20
     */
    public static boolean isNetworkOnline() {
        Runtime runtime = Runtime.getRuntime();
        try {
            Process ipProcess = runtime.exec("ping -c 3 www.baidu.com");
            int exitValue = ipProcess.waitFor();
            return (exitValue == 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
/**
 * @description 获得运行商的名称，如中国移动
 * @param  context
 * @return 网络运营商名称
 * @author 张彬
 * @time 2018/12/6 0:40
 */
    public static String getNetworkOperatorName(Context context) {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm != null ? tm.getNetworkOperatorName() : null;
    }
}
