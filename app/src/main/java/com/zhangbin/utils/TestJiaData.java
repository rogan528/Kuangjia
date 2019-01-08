package com.zhangbin.utils;

import android.util.Log;
import com.zhangbin.bean.Bean;
import com.zhangbin.bean.TestBean;
import java.util.ArrayList;
import java.util.List;
public class TestJiaData {


    /**
     *  测试在SP中存储list的方法
     */
    public static void testSPinputList(){
        List<TestBean> list = new ArrayList<>();
        TestBean testBean1= new TestBean("test11", 1, 11, true);
        TestBean testBean2= new TestBean("test12", 2, 22, false);
        list.add(testBean1);
        list.add(testBean2);
        SPUtils.getInstance().setParam("test",list);
        String json1 = (String) SPUtils.getInstance().getParam("test","");
        List<TestBean> objects1 = JsonListUtils.jsonToList(json1,TestBean.class);
        Log.e("zhangbin111","---"+objects1.size());
        for (int i=0;i<objects1.size();i++){
            Log.e("zhangbin111","---1---"+objects1.get(i).name);
        }
        List<String> list2 = new ArrayList<>();
        list2.add("test21");
        list2.add("test22");
        SPUtils.getInstance().setParam("test2",list2);
        String json2 = (String) SPUtils.getInstance().getParam("test2","");
        List<String> objects2 = JsonListUtils.jsonToList(json2,String.class);
        Log.e("zhangbin111","---"+objects2.size());
        for (int i=0;i<objects2.size();i++){
            Log.e("zhangbin111","---2--"+objects2.get(i));
        }
        List<Bean> list3 = new ArrayList<>();
        Bean.TeamUserList test311 = new Bean.TeamUserList("311", "test311");
        Bean.TeamUserList test312 = new Bean.TeamUserList("312", "test312");
        List<Bean.TeamUserList> userList = new ArrayList<>();
        userList.add(test311);
        userList.add(test312);
        Bean.BeautyBean user1 = new Bean.BeautyBean("user1", 1);
        Bean.BeautyBean user2 = new Bean.BeautyBean("user2", 2);
        List<Bean.BeautyBean> beautyBeanListList = new ArrayList<>();
        beautyBeanListList.add(user1);
        beautyBeanListList.add(user2);
        Bean.Result result = new Bean.Result(userList, beautyBeanListList);
        Bean bean1 = new Bean("1", "成功", result);
        Bean bean2 = new Bean("2", "失败", result);
        list3.add(bean1);
        list3.add(bean2);
        SPUtils.getInstance().setParam("test3",list3);
        String json3 = (String) SPUtils.getInstance().getParam("test3","");
        List<Bean> objects3 = JsonListUtils.jsonToList(json3,Bean.class);
        for (int i=0;i<objects3.size();i++){
            Log.e("zhangbin111","---i--"+i+"----"+objects3.size());
            List<Bean.BeautyBean> beautyBeanList = objects3.get(i).result.beautyBeanList;
            for (int j = 0;j<beautyBeanList.size();j++) {
                Log.e("zhangbin111", "---3--" + beautyBeanList.get(j).name);
            }
        }
    }
}
