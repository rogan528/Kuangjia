package com.zhangbin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.zhangbin.MyApplication;

/**
 * @Package: com.zhangbin.utils
 * @ClassName: SharedPreferencesUtils
 * @Description: xml存储工具类
 * @Author: 张彬
 * @CreateDate: 2018-12-31 9:55
 */
public class SPUtils {
    /**
     * 保存在手机里面的文件名
     */
    private static final String DEFAULT_FILE_NAME = "share_date";
    private static final int XML_DEFAULT_MODE = Context.MODE_PRIVATE;
    private static SharedPreferences mSharedPreferences;
    private static SPUtils mSPUtils;
    private static SharedPreferences.Editor mEditor;
    public enum XMLKeyName {
        FIRST_LOGIN
    }

    /**
     * @param fileName
     * @param xmlMode
     */
    private SPUtils(String fileName, int xmlMode){
        mSharedPreferences = MyApplication.getContext().getSharedPreferences(fileName, xmlMode);
        mEditor = mSharedPreferences.edit();
    }

    /**
     * @return 默认xml文件名称,默认private模式
     */
    public synchronized static SPUtils getInstance(){
        return getInstance(DEFAULT_FILE_NAME);
    }

    /**
     * @param fileName xml文件名称
     * @return 给出的文件名称,默认模式
     */
    public synchronized static SPUtils getInstance(@NonNull String fileName){
        return getInstance(fileName,XML_DEFAULT_MODE);
    }

    /**
     * @param fileName  xml文件名称
     * @param xmlMode   文件存储模式
     * @return  初始化对象
     */
    public synchronized static SPUtils getInstance(@NonNull String fileName, @NonNull int xmlMode){
        if (mSPUtils == null){
            mSPUtils = new SPUtils(fileName,xmlMode);
        }
        return  mSPUtils;

    }
    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     * @param xmlKeyName
     * @param value 存储的值
     * @return true/false
     */
    public boolean setParam(Object xmlKeyName, Object value){
        String type = value.getClass().getSimpleName();
        String key ="";
        Class enumCheck = xmlKeyName.getClass();
        if ("String".equals(enumCheck.getSimpleName())){
             key = (String) xmlKeyName;
        }else if(enumCheck.isEnum()){
            key = xmlKeyName.toString();
        }
        if("String".equals(type)){
            mEditor.putString(key, (String)value);
        } else if("Integer".equals(type)){
            mEditor.putInt(key, (Integer)value);
        } else if("Boolean".equals(type)){
            mEditor.putBoolean(key, (Boolean)value);
        } else if("Float".equals(type)){
            mEditor.putFloat(key, (Float)value);
        } else if("Long".equals(type)){
            mEditor.putLong(key, (Long)value);
        }else if("ArrayList".equals(type)){
            Gson gson = new Gson();
            String datas = gson.toJson(value);
            mEditor.putString(key, datas);
        }

        return mEditor.commit();
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     * @param xmlKeyName
     * @param defaultValue
     * @return
     */
    public Object getParam(Object xmlKeyName, Object defaultValue){
        String type = defaultValue.getClass().getSimpleName();
        String key ="";
        Class enumCheck = xmlKeyName.getClass();
        if ("String".equals(xmlKeyName.getClass().getSimpleName())){
            key = (String) xmlKeyName;
        }else if(enumCheck.isEnum()){
            key = xmlKeyName.toString();
        }
        if("String".equals(type)){
            return mSharedPreferences.getString(key, (String)defaultValue);
        } else if("Integer".equals(type)){
            return mSharedPreferences.getInt(key, (Integer)defaultValue);
        } else if("Boolean".equals(type)){
            return mSharedPreferences.getBoolean(key, (Boolean)defaultValue);
        } else if("Float".equals(type)){
            return mSharedPreferences.getFloat(key, (Float)defaultValue);
        } else if("Long".equals(type)){
            return mSharedPreferences.getLong(key, (Long)defaultValue);
        }else if("ArrayList".equals(type)){
            return mSharedPreferences.getString(key, (String)defaultValue);
        }
        return null;
    }

    /**
     * 清除所有数据
     * @return true成功
     */
    public boolean  clearAll() {
        mEditor.clear();
        return mEditor.commit();
    }

    /**
     * 清除指定数据
     * @param xmlKeyName xml的key
     * @return true成功
     */
    public boolean clearKey(Object xmlKeyName) {
        Class enumCheck = xmlKeyName.getClass();
        String key ="";
        if ("String".equals(enumCheck.getSimpleName())){
            key = (String) xmlKeyName;
        }else if(enumCheck.isEnum()){
            key = xmlKeyName.toString();
        }
        mEditor.remove(key);
        return mEditor.commit();
    }
}
