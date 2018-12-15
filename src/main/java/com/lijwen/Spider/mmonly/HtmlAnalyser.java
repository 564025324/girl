package com.lijwen.Spider.mmonly;

import com.lijwen.Spider.mmonly.po.UrlPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网页分析器
 * <p>
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/15 0015
 * Time:下午 9:10
 */
public class HtmlAnalyser {

    private final static Logger logger = LoggerFactory.getLogger(HtmlAnalyser.class);

    // 分析指定url
    public static void analyHtml(String strUrl) {
        System.out.println("================ 当前解析URL：" + strUrl + " ================");
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new URL(strUrl).openStream(), "gbk"));
            String line;
            UrlPo urlObject = new UrlPo();
            urlObject.setUrl(strUrl);
            while ((line = in.readLine()) != null) {
                analyseReadLine(line, urlObject);
            }
        } catch (MalformedURLException e) {
            logger.error("输入url异常");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 解析每一行，获取明细画册的url地址
     *
     * @param line
     */
    public static void analyseReadLine(String line, UrlPo url) throws Exception {
        SpilderService.getHtmlByLine(line, url);
    }

    public static void collectMailHtml() {
        for (int i = 1; i <= 830; i++) {
            if (i == 1) {
                analyHtml("http://www.mmonly.cc/mmtp/");
            }
            analyHtml("http://www.mmonly.cc/mmtp/list_9_" + i + ".html");
        }
    }

    public static void main(String[] args) {
//        collectMailHtml();
    }
}
