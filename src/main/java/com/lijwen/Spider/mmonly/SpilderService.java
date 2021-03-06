package com.lijwen.Spider.mmonly;

import com.lijwen.Spider.mmonly.po.PicturePo;
import com.lijwen.Spider.mmonly.po.UrlPo;
import com.lijwen.util.JdbcHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/16 0016
 * Time:上午 12:46
 */
public class SpilderService {
    final static String picture_regex = "http://t1\\.hxzdhn\\.com/uploads/.+\\.jpg";
    final static String web_regex = "<a target=\"_blank\" href=\"http://www.mmonly.cc/mmtp/.+\\.html\"><img";
    final static String page_regex = "<span class=\"totalpage\">.+\\</span>\\)";
    private final static Logger logger = LoggerFactory.getLogger(SpilderService.class);

    /**
     * 获取明细画册的url地址
     *
     * @param line
     */
    public static void getHtmlByLine(String line, UrlPo url) throws Exception {
        Pattern web_pattern = Pattern.compile(web_regex);
        Matcher web_matcher = web_pattern.matcher(line);
        if (web_matcher.find()) {
            url.setUrl(web_matcher.group().replace("<a target=\"_blank\" href=\"", "").replace("\"><img", ""));
            url.setUrl_type(0);
            url.setDownloadflag(true);
            if(JdbcHelper.selectUrldbByUrl(url.getUrl()).size()==0) {
                JdbcHelper.insertHtmlUrl(url);
            }
        }
    }

    /**
     * 获取明细画册的图片地址信息
     *
     * @param line
     */
    public static void getPicByLine(String line) throws Exception {
        PicturePo pic = new PicturePo();
        // 获取图片地址
        Pattern pic_pattern = Pattern.compile(picture_regex);
        Matcher pic_matcher = pic_pattern.matcher(line);
        if (pic_matcher.find()) {
            pic.setPicUrl(pic_matcher.group());
            pic.setPicName(String.valueOf(System.currentTimeMillis()));
            //pic.setPicName(pic.getPicUrl().split("/")[pic.getPicUrl().split("/").length - 1]);
        } else {
            logger.error("未获取到图片地址信息");
        }
        if (JdbcHelper.selectPicByUrl(pic.getPicUrl()).size() == 0) {
            JdbcHelper.insertPictureUrl(pic);
        }
    }
}
