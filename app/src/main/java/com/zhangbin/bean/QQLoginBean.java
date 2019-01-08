package com.zhangbin.bean;

public class QQLoginBean {

    /**
     * ret : 0
     * openid : 7F54115B2D03375E38CDC28D86CB379F
     * access_token : 6CDC0D9322F266387A61EA5AE1F4CB26
     * pay_token : 4AF33E7AAFF30B93ADA067B46910B9E7
     * expires_in : 7776000
     * pf : desktop_m_qq-10000144-android-2002-
     * pfkey : e228ca140f1176d8b791905bee239986
     * msg :
     * login_cost : 43
     * query_authority_cost : 197
     * authority_cost : 89581
     * expires_time : 1554698968273
     */

    public int ret;
    public String openid;
    public String access_token;
    public String pay_token;
    public int expires_in;
    public String pf;
    public String pfkey;
    public String msg;
    public int login_cost;
    public int query_authority_cost;
    public int authority_cost;
    public long expires_time;

    public QQLoginBean(int ret, String openid, String access_token, String pay_token, int expires_in, String pf, String pfkey, String msg, int login_cost, int query_authority_cost, int authority_cost, long expires_time) {
        this.ret = ret;
        this.openid = openid;
        this.access_token = access_token;
        this.pay_token = pay_token;
        this.expires_in = expires_in;
        this.pf = pf;
        this.pfkey = pfkey;
        this.msg = msg;
        this.login_cost = login_cost;
        this.query_authority_cost = query_authority_cost;
        this.authority_cost = authority_cost;
        this.expires_time = expires_time;
    }
}
