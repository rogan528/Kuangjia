package com.zhangbin.utils;

import android.content.Context;
import android.util.TypedValue;
/**
 * @Package: com.zhangbin.utils
 * @ClassName: DensityUtils
 * @Description: 单位转换类
 * @Author: 张彬
 * @CreateDate: 2018/12/7
 * @UpdateDate: 2018/12/7
 * @UpdateRemark: 更新说明
 */
public class DensityUtils {

    /**
     * @description px转dp
     * @param  pxValue
     * @return dp
     * @author 张彬
     * @time 2018/12/7 22:02
     * scale 720*1280   2
     * scale 1080*1920   3
     */
    public static float px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
/**
 * @description px转sp
 * @param  pxValue
 * @return sp
 * @author 张彬
 * @time 2018/12/7 22:12
 */
    public static float px2sp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }
    /**
     * @description  dp转px
     * @param  dpValue
     * @return  px
     * @author 张彬
     * @time 2018/12/7 21:57
     *
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
                spVal, context.getResources().getDisplayMetrics());
    }

}
