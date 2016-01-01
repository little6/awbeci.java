package com.awbeci.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CatchFavicon {
    Logger log = LoggerFactory.getLogger(CatchFavicon.class);

    /**
     * 获取网络路径文件流，如：www.awbeci.com/a.jpg
     * @param urlStr
     * @return
     * @throws IOException
     */
    public InputStream GetUrlFavicon(String urlStr) throws IOException {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置超时间为3秒
            conn.setConnectTimeout(5 * 1000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            InputStream content = conn.getInputStream();
            return content;
        } catch (Exception e) {
            log.error("获取图片出错:" + e.getMessage());
            return null;
        }
    }

    /**
     * 获取本地文件流：如：c://awbeci/a.jpg
     * @param filePath
     * @return
     * @throws IOException
     */
    public InputStream GetFilePathStream(String filePath) throws IOException {
        try {
            // 获取指定文件的输入流
            File file = new File(filePath);
            InputStream content = new FileInputStream(file);
            return content;
        } catch (Exception e) {
            log.error("获取图片出错:" + e.getMessage());
            return null;
        }
    }

    /**
     *
     * @param url
     * @return
     */
    public static String getFileNameFromUrl(String url){
        String name = new Long(System.currentTimeMillis()).toString() + ".X";
        int index = url.lastIndexOf("/");
        if(index > 0){
            name = url.substring(index + 1);
            if(name.trim().length()>0){
                return name;
            }
        }
        return name;
    }
}
