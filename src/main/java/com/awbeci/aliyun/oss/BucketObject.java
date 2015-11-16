package com.awbeci.aliyun.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

import java.io.*;
import java.util.Properties;

public class BucketObject {
    OSSClient client = null;
    String accessKeyId = "";
    String accessKeySecret = "";
    String siteicon_endpoint = "";
    String bucketName = "";

    public BucketObject() throws IOException {

        Properties prop = new Properties();
        prop.load(BucketObject.class.getClassLoader().getResourceAsStream("aliyun-oss.properties"));

        accessKeyId = prop.getProperty("accessKeyId");
        accessKeySecret = prop.getProperty("accessKeySecret");
        siteicon_endpoint = prop.getProperty("siteicon_endpoint");
        bucketName = prop.getProperty("bucketName");
        // 初始化OSSClient
        client = new OSSClient(siteicon_endpoint, accessKeyId, accessKeySecret);
    }


    public void createBucket(String bucketName) {
        // 新建一个Bucket
        client.createBucket(bucketName);
    }

    public void putObject(String filename, String filePath) throws FileNotFoundException {

        // 获取指定文件的输入流
        File file = new File(filePath);
        InputStream content = new FileInputStream(file);

        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        meta.setContentLength(file.length());

        // 上传Object.
        PutObjectResult result = client.putObject(bucketName, filename, content, meta);

        // 打印ETag
        System.out.println(result.getETag());
    }
}
