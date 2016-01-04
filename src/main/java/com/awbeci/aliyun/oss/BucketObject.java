package com.awbeci.aliyun.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import com.awbeci.controller.NavigationController;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.awbeci.util.*;

public class BucketObject {
    Logger log = LoggerFactory.getLogger(BucketObject.class);
    CatchFavicon catchFavicon = new CatchFavicon();
    MyProperties myProperties = new MyProperties();
    OSSClient client = null;
    String accessKeyId = "";
    String accessKeySecret = "";
    String siteicon_endpoint = "";
    String bucketName = "";

    public BucketObject(String properties) throws IOException {
        Properties prop = myProperties.getPropertiesByName(properties);
        accessKeyId = prop.getProperty("accessKeyId");
        accessKeySecret = prop.getProperty("accessKeySecret");
        siteicon_endpoint = prop.getProperty("siteicon_endpoint");
        bucketName = prop.getProperty("bucketName");
        // 初始化OSSClient
        client = new OSSClient(siteicon_endpoint, accessKeyId, accessKeySecret);
    }


    /**
     * 创建bucket
     * @param bucketName
     */
    public void createBucket(String bucketName) {
        // 新建一个Bucket
        client.createBucket(bucketName);
    }

    /**
     * 上传文件
     * @param folder   阿里云上该图片在Bucket所处的文件夹位置，不能以'/'开头
     * @param filename 文件名
     * @param urlStr   网上图片路径
     * @throws IOException
     */
    public boolean putObjectByUrl(String folder, String filename, String urlStr) throws IOException {
        try {
            InputStream content = catchFavicon.GetUrlFavicon(urlStr);
            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();

            // 必须设置ContentLength
            meta.setContentLength(content.available());

            // 上传Object.
            PutObjectResult result = client.putObject(bucketName, folder + filename, content, meta);
            log.info(result.getETag());
            return true;
        } catch (Exception e) {
            log.error("出错原因：" + e.getMessage());
            return false;
        }
    }

    /**
     * 根据路径上传图片
     * @param folder
     * @param filename
     * @return
     * @throws IOException
     */
    public boolean putObjectByFilePath(String folder, String filename, InputStream content) throws IOException {
        try {

            // 创建上传Object的Metadata
            ObjectMetadata meta = new ObjectMetadata();

            // 必须设置ContentLength
            meta.setContentLength(content.available());

            // 上传Object.
            PutObjectResult result = client.putObject(bucketName, folder + filename+".jpg", content, meta);
            log.info(result.getETag());
            return true;
        } catch (Exception e) {
            log.error("出错原因：" + e.getMessage());
            return false;
        }
    }

    /**
     * 删除文件
     * @param key
     */
    public void deleteObject(String key) {
        // 删除Object
        client.deleteObject(bucketName, key);
    }
}
