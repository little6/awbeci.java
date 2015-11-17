package com.awbeci.aliyun.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

    public void putObject(String filename, String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3 * 1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//todo:有可能图片为空，这点要考虑
        InputStream content = conn.getInputStream();
        // 创建上传Object的Metadata
        ObjectMetadata meta = new ObjectMetadata();

        // 必须设置ContentLength
        meta.setContentLength(content.available());

        // 上传Object.
        PutObjectResult result = client.putObject(bucketName, filename, content, meta);

        // 打印ETag
        System.out.println(result.getETag());
    }
}
