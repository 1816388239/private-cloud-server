package com.merrony.privatecloud.config;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.region.Region;

public class SingleCOSConfig {
    private final static COSClient instance;

    private final static String secretId = "AKID5SrzK15Otiqd5t5eXuH0GUSD90HMrzK7";
    private final static String secretKey = "cLBVSzCSJBoVy08tB094VPM6T9v0kb4z";
    public final static String APPID = "1251797322";

    private SingleCOSConfig() {
    }

    static {
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        Region region = new Region("ap-guangzhou");
        ClientConfig clientConfig = new ClientConfig(region);
        instance = new COSClient(cred, clientConfig);
    }

    public static COSClient getCOSClient() {
        return instance;
    }
}
