package com.lijwen.Spider.mmonly;

import com.lijwen.Spider.mmonly.po.PicturePo;
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

        List<PicturePo> piclist = JdbcHelper.selectPicByUrl("");
        System.out.println("预计下载图片：" + piclist.size());
        for (PicturePo picpo : piclist) {
            DownLoadTools.downloadFileByUrl(picpo.getPicUrl(), "g:/spilder/" + picpo.getPicName() + ".jpg");
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
