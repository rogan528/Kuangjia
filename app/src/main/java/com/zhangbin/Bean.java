package com.zhangbin;

import java.util.List;

class Bean {
    public String code;
    public String success;
    private List<Result> results;
    public Bean(){}
    class Result{

        public String userName;
        public String storeAddress;
    }
}
