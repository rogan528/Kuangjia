package com.zhangbin.bean;

import java.util.List;

public class Bean {
    public String code;
    public String success;
    public Result result;
    public Bean(String code, String success, Result result) {
        this.code = code;
        this.success = success;
        this.result = result;
    }
    public static class Result{
        public Result(List<TeamUserList> userList, List<BeautyBean> beautyBeanList) {
            this.userList = userList;
            this.beautyBeanList = beautyBeanList;
        }

        public List<TeamUserList> userList;
        public List<BeautyBean> beautyBeanList;//瀑布流
    }
    public static class TeamUserList{
        public String userId;
        public String userName;

        public TeamUserList(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }
    }
    public static  class BeautyBean {
        public String name;
        public int imageId;
        public BeautyBean(String name, int imageId) {
            this.name = name;
            this.imageId = imageId;
        }
    }
}
