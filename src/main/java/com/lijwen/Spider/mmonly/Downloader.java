package com.lijwen.Spider.mmonly;

import com.lijwen.Spider.mmonly.po.PicturePo;
import com.lijwen.Spider.mmonly.po.UrlPo;
import com.lijwen.util.DownLoadTools;
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

    public static void main(String[] args) throws Exception {
//        List<UrlPo> urllist = JdbcHelper.selectUrldbByUrl("");
//        for(UrlPo urlpo: urllist){
//            analyPicHtml(urlpo.getUrl());
//        }
        addOtherPageByUrl();
        int beginPosition = 2500;
        int leaveFileCount = 0;
        List<PicturePo> piclist = JdbcHelper.selectPicByUrl("");

        System.out.println("预计下载图片：" + (piclist.size() - beginPosition));
        for (PicturePo picpo : piclist) {
            if (picpo.getId() > beginPosition) {
                beginPosition++;
                DownLoadTools.downloadFileByUrl(picpo.getPicUrl(), "g:/spilder/" + picpo.getPicName() + ".jpg");
                leaveFileCount = piclist.size() - beginPosition;
                if (leaveFileCount % 10 == 0) {
                    System.out.println("剩余[" + leaveFileCount + "]个文件下载");
                }
            }
        }
    }


    // 根据已知地址，增加翻页地址
    public static void addOtherPageByUrl() throws Exception {
        List<UrlPo> urllist = JdbcHelper.selectUrldbByUrl("");
        for (UrlPo url : urllist) {
            if (url.getId() > 400 && url.getId() < 420) {
                for (int i = 2; i < 10; i++) {
                    String new_url = url.getUrl().replace(".html", "_" + i + ".html");
                    try {
                        URL urladd = new URL(new_url);
                        urladd.openStream();
                        logger.info("当前地址可用");
                    } catch (Exception e) {
                        logger.error("无法加载当前地址");
                    }
                    analyPicHtml(new_url);
                }
            }
        }
    }

    // 分析指定url
    public static void analyPicHtml(String strUrl) {
        System.out.println("================ 当前解析URL：" + strUrl + " ================");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL(strUrl).openStream(), "gbk"));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("class=\"down-btn\"")) {
                    SpilderService.getPicByLine(line);
                }
            }
        } catch (MalformedURLException e) {
            logger.error("输入url异常");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
