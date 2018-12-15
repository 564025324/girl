package com.lijwen.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/15 0015
 * Time:下午 10:00
 */
public class DownLoadTools {

    public static void downloadFileByUrl(String fileUrl, String fileLocal) throws Exception {
        URL url = null;
        try {
            url = new URL(fileUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(6000);
        int code = urlCon.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            throw new Exception("文件读取失败");
        }
        //读文件流
        DataInputStream in = new DataInputStream(urlCon.getInputStream());
        DataOutputStream out = new DataOutputStream(new FileOutputStream(fileLocal));
        byte[] buffer = new byte[2048];
        int count = 0;
        while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
        if (out != null) {
            out.close();
        }
        if (in != null) {
            in.close();
        }
    }


    public static void main(String[] args) {
    }
}
