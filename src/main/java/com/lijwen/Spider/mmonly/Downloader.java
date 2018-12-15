package com.lijwen.Spider.mmonly;

import com.lijwen.Spider.mmonly.po.UrlPo;
import com.lijwen.util.JdbcHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/16 0016
 * Time:上午 12:48
 */
public class Downloader {
    private final static Logger logger = LoggerFactory.getLogger(Downloader.class);
    // DownLoadTools.downloadFileByUrl(pic.getPicUrl(), "g:/spilder/" + pic.getPicName() + ".jpg");

    public static void main(String[] args) throws Exception {
        List<UrlPo> urllist = JdbcHelper.selectUrldbByUrl("");
//        for(UrlPo urlpo: urllist){
//            analyPicHtml(urlpo.getUrl());
//        }


        analyPicHtml(urllist.get(0).getUrl());
    }


    // 分析指定url
    public static void analyPicHtml(String strUrl) {
        System.out.println("================ 当前解析URL：" + strUrl + " ================");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL(strUrl).openStream(), "gbk"));
            String line;
            UrlPo urlObject = new UrlPo();
            urlObject.setUrl(strUrl);
            StringBuffer text = new StringBuffer();
            while ((line = in.readLine()) != null) {
                text = text.append(line + "\n");
            }
            System.out.println(text);
            SpilderService.getPicByHtmlText(text.toString());
        } catch (MalformedURLException e) {
            logger.error("输入url异常");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
