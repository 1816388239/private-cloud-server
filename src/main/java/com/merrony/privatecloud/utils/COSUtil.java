package com.merrony.privatecloud.utils;

import com.merrony.privatecloud.config.SingleCOSConfig;
import com.merrony.privatecloud.model.User;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.CannedAccessControlList;
import com.qcloud.cos.model.CreateBucketRequest;

import javax.servlet.http.HttpServletRequest;

public class COSUtil {
    private static COSClient cosClient = SingleCOSConfig.getCOSClient();

    public static Bucket createBucket (HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("loginUser");
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(user.getBucketName());
        // 设置 bucket 的权限为 PublicRead(公有读私有写), 其他可选有私有读写, 公有读写
        createBucketRequest.setCannedAcl(CannedAccessControlList.PublicRead);
        try{
            return cosClient.createBucket(createBucketRequest);
        } catch (CosServiceException serverException) {
            serverException.printStackTrace();
        } catch (CosClientException clientException) {
            clientException.printStackTrace();
        }
        return null;
    }
}
