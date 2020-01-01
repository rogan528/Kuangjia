package com.zhangbin.mykuangjia.liandong.recyclerview.datautils;

import android.content.Context;
import android.util.SparseIntArray;


import com.zhangbin.mykuangjia.liandong.recyclerview.adapter.RightAdapter;
import com.zhangbin.mykuangjia.liandong.recyclerview.bean.LeftBean;
import com.zhangbin.mykuangjia.liandong.recyclerview.bean.RightBean;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Version : 1.0
 * Desc    : 模拟数据封装
 */
public class DataUtil {

    /**
     * 记录右侧Title真实索引位置
     */
    private static SparseIntArray sTitlePosSa = new SparseIntArray();

    /**
     * 获取右测Title位置索引集合
     */
    public static SparseIntArray getTitlePosSa() {
        return sTitlePosSa;
    }

    /**
     * 获取左边数据
     */
    public static List<LeftBean> getLeftData(Context context) throws JSONException {
        String json = getAssets(context, "datas.json");
        if (json != null) {
            JSONArray ja = new JSONArray(json);
            List<LeftBean> datas = new ArrayList<>();
            for (int i = 0; i < ja.length(); i++) {
                JSONObject jo = ja.getJSONObject(i);
                int id = jo.getInt("id");
                String title = jo.getString("title");
                if (i == 0) {
                    datas.add(new LeftBean(id, title, true));
                } else {
                    datas.add(new LeftBean(id, title));
                }
            }
            return datas;
        }
        return null;
    }

    /**
     * 获取右测数据
     */
    public static List<RightBean> getRightData(Context context) throws JSONException {
        String json = getAssets(context, "datas.json");
        if (json != null) {
            JSONArray ja = new JSONArray(json);
            List<RightBean> datas = new ArrayList<>();
            for (int i = 0; i < ja.length(); i++) {

                JSONObject jo = ja.getJSONObject(i);
                int id = jo.getInt("id");
                String title = jo.getString("title");
                datas.add(createTitle(id, title, i));

                JSONArray contentJa = jo.getJSONArray("content");
                for (int j = 0; j < contentJa.length(); j++) {
                    JSONObject contentJo = contentJa.getJSONObject(j);
                    int contentId = contentJo.getInt("id");
                    String contentTitle = contentJo.getString("title");
                    String contentImage = contentJo.getString("image");
                    datas.add(createContent(contentId, contentTitle, contentImage, i));
                }
            }

            saveRightTitleRealPosition(datas);

            return datas;
        }
        return null;
    }

    /**
     * 记录右侧Title真实位置
     */
    private static void saveRightTitleRealPosition(List<RightBean> datas) {
        if (datas != null) {
            int key = 0;
            for (int i = 0; i < datas.size(); i++) {
                if (datas.get(i).getItemType() == RightAdapter.TITLE) {
                    sTitlePosSa.put(key, i);
                    key++;
                }
            }
        }
    }

    /**
     * 创建一个右测标题数据
     */
    private static RightBean createTitle(int id, String title, int fakePosition) {
        RightBean rightVo = new RightBean();
        rightVo.setId(id);
        rightVo.setTitle("-- " + title + " --");
        rightVo.setItemType(RightAdapter.TITLE);
        rightVo.setFakePosition(fakePosition);
        return rightVo;
    }

    /**
     * 创建一个右测内容数据
     */
    private static RightBean createContent(int id, String title, String image, int fakePosition) {
        RightBean rightVo = new RightBean();
        rightVo.setId(id);
        rightVo.setTitle(title);
        rightVo.setImage(image);
        rightVo.setItemType(RightAdapter.CONTENT);
        rightVo.setFakePosition(fakePosition);      //这里加上是为了扩大响应范围
        return rightVo;
    }

    /**
     * 读取Assets目录文件
     */
    private static String getAssets(Context context, String fileName) {
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            isr = new InputStreamReader(context.getApplicationContext().getAssets().open(fileName));
            br = new BufferedReader(isr);
            String line;
            String result = "";
            while ((line = br.readLine()) != null) {
                result += line;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (isr != null) {
                    isr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
