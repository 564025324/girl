package com.lijwen.douyin;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 根据视频下载链接 下载视频 后缀为 .mp4 等
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/28 0028
 * Time:上午 12:29
 */
public class DownloadFile {
    public static void main(String[] args) {
        DownloadFile df = new DownloadFile();
//        df.run("http://v6-dy.ixigua.com/video/m/2209b2dbcc67c524dc488cd312a665f3fed116102de40000174ef1d6aff2/?AWSAccessKeyId=qh0h9TdcEMoS2oPj7aKX&Expires=1543341735&Signature=XOVwhff5GJ6%2FakACGXUD5kAtq9M%3D&rc=ajN0NWp3NjY7aTMzaWkzM0ApQHRAbzVENTUzNzQzNDg1NDs0OzNAKXUpQGczdylAZmxkamV6aGhkZjs0QF81L2M2Y19yb18tLTMtL3NzLW8jbyMuMDQuMS0uLS0tLS0vLi4vaTpiLW8jOmAtbyNtbCtiK2p0OiMvLl4%3D");
        df.run("http://5b0988e595225.cdn.sohucs.com/images/20170906/58cdb24be3624488ad3e8d3d00b4585f.jpeg");

    }

    public void downLoadFromUrl(String urlStr, String fileName, String savePath) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(3000);
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream inputStream = conn.getInputStream();
        byte[] getData = readInputStream(inputStream);
        java.io.File saveDir = new java.io.File(savePath);
        if (!saveDir.exists()) {
            saveDir.mkdir();
        }
        java.io.File file = new java.io.File(saveDir + java.io.File.separator + fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos != null) {
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    /**
     * 程序入口
     *
     * @param urlStr
     */
    public void run(String urlStr) {
        long imageTitile = System.currentTimeMillis();
        String fileName = imageTitile + "." + "mp4";
        String savePath = "G:\\douyinVidio";
        try {
            downLoadFromUrl(urlStr, fileName, savePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
