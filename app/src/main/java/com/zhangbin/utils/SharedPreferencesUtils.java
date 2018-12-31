package com.zhangbin.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @Package: com.zhangbin.utils
 * @ClassName: SharedPreferencesUtils
 * @Description: xml存储工具类
 * @Author: 张彬
 * @CreateDate: 2018-12-31 9:55
 */
public class SharedPreferencesUtils {
    private SharedPreferencesUtils(){throw new UnsupportedOperationException("不能被实例化");}
    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     * @param context
     * @param xmlKeyName
     * @param object
     */
    public static void setParam(Context context ,ConstantsValue.XmlKeyName xmlKeyName, Object object){
        String FILE_NAME = ConstantsValue.XML_NAME;
        int XML_MODLE = ConstantsValue.XML_MODLE;
        String type = object.getClass().getSimpleName();
        String key = xmlKeyName.name();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, XML_MODLE);
        SharedPreferences.Editor editor = sp.edit();

        if("String".equals(type)){
            editor.putString(key, (String)object);
        } else if("Integer".equals(type)){
            editor.putInt(key, (Integer)object);
        } else if("Boolean".equals(type)){
            editor.putBoolean(key, (Boolean)object);
        } else if("Float".equals(type)){
            editor.putFloat(key, (Float)object);
        }
        else if("Long".equals(type)){
            editor.putLong(key, (Long)object);
        }
        editor.commit();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     * @param context
     * @param xmlKeyName
     * @param defaultObject
     * @return
     */
    public static Object getParam(Context context , ConstantsValue.XmlKeyName xmlKeyName, Object defaultObject){
        String FILE_NAME = ConstantsValue.XML_NAME;
        int XML_MODLE = ConstantsValue.XML_MODLE;
        String type = defaultObject.getClass().getSimpleName();
        String key = xmlKeyName.name();
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, XML_MODLE);

        if("String".equals(type)){
            return sp.getString(key, (String)defaultObject);
        } else if("Integer".equals(type)){
            return sp.getInt(key, (Integer)defaultObject);
        } else if("Boolean".equals(type)){
            return sp.getBoolean(key, (Boolean)defaultObject);
        } else if("Float".equals(type)){
            return sp.getFloat(key, (Float)defaultObject);
        } else if("Long".equals(type)){
            return sp.getLong(key, (Long)defaultObject);
        }
        return null;
    }

    /**
     * 清除所有数据
     * @param context
     */
    public static void clearAll(Context context) {
        String FILE_NAME = ConstantsValue.XML_NAME;
        int XML_MODLE = ConstantsValue.XML_MODLE;
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME,
                XML_MODLE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear().commit();
    }

    /**
     * 清除指定数据
     * @param context
     */
    public static void clearXmlKey(Context context,ConstantsValue.XmlKeyName xmlKeyName) {
        String FILE_NAME = ConstantsValue.XML_NAME;
        int XML_MODLE = ConstantsValue.XML_MODLE;
        SharedPreferences sp = context.getSharedPreferences(FILE_NAME, XML_MODLE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(xmlKeyName.name());
        editor.commit();
    }
}
