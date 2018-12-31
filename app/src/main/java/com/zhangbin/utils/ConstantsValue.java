package com.zhangbin.utils;

import com.zhangbin.R;

public class ConstantsValue {
    private ConstantsValue() {
        throw new UnsupportedOperationException("不能被实例化");
    }
    public final static String server_url = "https://msp.alipay.com/x.htm";
    public final static int[] mGuideIamgeIds =new int[]{R.mipmap.guide_1,R.mipmap.guide_2,R.mipmap.guide_3};
    public enum XmlKeyName{
        FIRST_LOGIN

    }
}
