package com.zhangbin.bean;

import java.util.List;

public class Bean {
    public String code;
    public String success;
    public Result result;
    class Result{
        public List<TeamUserList> userList;
        public List<BeautyBean> beautyBeanList;//瀑布流
    }
    public static class TeamUserList{
        public String userId;
        public String userName;
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
