package com.zhangbin.alipay;

public class PartnerConfig {
    // 合作商户ID。用签约支付宝账号登录ms.alipay.com后，在账户信息页面获取。
    public static final String PARTNER = "2018122862711338";
    // 商户收款的支付宝账号
    public static final String SELLER = "18765215785";
    // 商户（RSA）私钥
    public static final String RSA_PRIVATE = "MIIEowIBAAKCAQEAvXuB5BsbErWY1VZLzuuKC0bUEyMEFFQsm9pGBT7gPwzgKXvI\n" +
            "976Z3oD/OR8fw9pmGdxtEw0Xyew+TQZ7e9dEtoCb2yMju1C4RmFHwhoD6fHSgtGu\n" +
            "q3LYZNT7ent4kipNRplBTK/hX5HSHac3wWLp7sjFKJIeamTqHL1kYLPUsBK6Uasa\n" +
            "avGqqs6GAiWLnsdBzLaEiJ3dlc7MdEzqZqp8+4UpDr1lBlTJmR2McEMPCOtWnh7J\n" +
            "CN4Vnx3p78OgLeG11l7lOrCwDK7RprQQzgLU3Hlt13QPInrWsywjus+HzIFIGyYZ\n" +
            "z2sBu2ejkxjjqS3XdLYX7o6QmDBc1LIx+R+zlQIDAQABAoIBAE/GWAF5iARwgFAR\n" +
            "bQlJEW19/HuyGl2UstNLKn+64R6qhRXyD8J+dLnBBbM+71i98o6gxytmL8XLuM8l\n" +
            "E4goMb3El9nDCaArc+ntuxB1c4BjV4XMUgXM7F5HbTk8Ep83QCGhFGT9B538/sGN\n" +
            "TWQWCPeHf7p9CmEw63/+HOy5yan2/xQtkbM8ornu/5OgXzQHilmbs1v0DJNWuB5S\n" +
            "QLHgy/fRKiLJlzbTNyDq5Op/Nq/FJIN4jbTFYW1Cr0P7s/YeoZpaO0O5+j5VGIG3\n" +
            "tNFcMkAYS75bNeqj0Sooh3axnRH4LhSlPvU0cVsUFN80YptOVt8mMamjULkZkZTZ\n" +
            "LzrC8QECgYEA3ldgpO0lwPyO9unLbeRAOlVbu3j4D92t9KQLZblrPpRX83/EWILF\n" +
            "qH3E8WdUYIajidar3Faly27UftDBkEUMwRkDh2Gwx0/tXBF011STqx1PnSyIy3zi\n" +
            "tVUmxRHETVctmkOQNDscQT3tnj628goCa/iX7icp96B5BfP/+7t1xrkCgYEA2iq3\n" +
            "Xahqsp6SKB8bXshYSGblF/cCukczz/khr2RFRqLhL293lTs98mGeLIn4ZONBmXv9\n" +
            "apsIgYkYY2oFehuTyiAwMKn3imUtUXJcCYP29dL1J4XRBfx+tdW6r1l3HaBBDFv4\n" +
            "lPLphe54UGoLYaEXNesJTHF4GL25w46UCfdtZb0CgYAdyKCmlynmhy5zfvAEQX4l\n" +
            "Ekgefd7k6TIjQlJQhx0Jnf+GG8hmfuYRYv+dwtS3tXF0xm/xLR46eRc4AajcNZO2\n" +
            "zi391aVDnb5TBfeb3LWHR37htBSDBbCsz8JIxc+A+LugHYrUpFJtnukUuJvzIkoe\n" +
            "woc/nLlvdWyg0oWo5/yn6QKBgQDUV10viFuJTLN+33/5SdA7cAKsx5tdCS5Rzu7N\n" +
            "Ui/nJ2M7kyd2FToe7opQWV1tfI99vuORXiHySih1olyAU9UNlzSwOM4ZYo6wRjl0\n" +
            "fX/iFZjNBf7C79W4T7UrNE2uhSqqx91zw9YsqEVsJzq6pFr9/KyJPauhkQ/8WYqX\n" +
            "BL7ylQKBgFcUWlYs4Y4te9Q6uxWuNsYOcQwJgjfD4HxyoQuDTmjXcFdgHXjSQqbK\n" +
            "+ZfY8/hgoAaPVrTUWX+AoVzhwn2wqbsBOSPCUxLqBrZq2K84BTbnhLTGD7xBF9es\n" +
            "tGujCJRoFIpIAU/rt2I+GloNNx7JwHjNtm3wpUXlvouaI28yEWor";
    // 支付宝（RSA）公钥 用签约支付宝账号登录ms.alipay.com后，在密钥管理页面获取。
    public static final String RSA_ALIPAY_PUBLIC = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvXuB5BsbErWY1VZLzuuKC0bUEyMEFFQsm9pGBT7gPwzgKXvI976Z3oD/OR8fw9pmGdxtEw0Xyew+TQZ7e9dEtoCb2yMju1C4RmFHwhoD6fHSgtGuq3LYZNT7ent4kipNRplBTK/hX5HSHac3wWLp7sjFKJIeamTqHL1kYLPUsBK6UasaavGqqs6GAiWLnsdBzLaEiJ3dlc7MdEzqZqp8+4UpDr1lBlTJmR2McEMPCOtWnh7JCN4Vnx3p78OgLeG11l7lOrCwDK7RprQQzgLU3Hlt13QPInrWsywjus+HzIFIGyYZz2sBu2ejkxjjqS3XdLYX7o6QmDBc1LIx+R+zlQIDAQAB";
    // 支付宝安全支付服务apk的名称，必须与assets目录下的apk名称一致
    public static final String ALIPAY_PLUGIN_NAME = "alipay_plugin223_0309.apk";
}
