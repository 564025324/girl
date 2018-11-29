package com.lijwen.douyin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * 根据提供的抖音ID获取所有的视频
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/27 0027
 * Time:下午 11:52
 */
public class DownloadUrl {
    String URL_ID = null;
    int count = 0;

    public static void main(String[] args) {
        DownloadUrl dl = new DownloadUrl();
        String ID = "80602533314";
        try {
            dl.DownHtml("https://www.douyin.com/share/user/" + ID + "/?share_type=link");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void DownHtml(String url) throws Exception {
        ArrayList<String> alURL = new ArrayList<String>(); // 视频id集合
        ArrayList<String> alMP4 = new ArrayList<>(); // 视频下载URL集合
        System.setProperty("webdriver.chrome.driver", "F:/chromedriver/chromedriver.exe");
        // 实例化一个浏览器对象
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Thread.sleep(8000); // 休眠等待页面加载
        List<WebElement> elements = driver.findElements(By.cssSelector("li.item,goWork")); // 获取到每个视频的模块
        System.out.println(elements.size());
        // 获得每个URL的id
        for (WebElement we : elements) {
            String ids = we.getAttribute("data-id"); // 获取模块的data-id的属性值
            if ("6626641234972642573".equals(ids)) {
                alURL.add("https://www.iesdouyin.com/share/video/" + ids);
                alURL.add("https://www.iesdouyin.com/share/video/6626641234972642573/?region=CN&mid=6619918290338712328&titleType=title&u_code=el3i9d7c&timestamp=1543337208&utm_campaign=client_share&app=aweme&utm_medium=ios&tt_from=copy&utm_source=copy&iid=52451121805");
            }

        }
        driver.get("http://douyin.iiilab.com/");// 打开可以将每个视频连接转化成可以下载的连接的页面
        Thread.sleep(8000); // 休眠等待页面加载
        // 获取可以下载的url
        for (int i = 0; i < alURL.size(); i++) {
            driver.findElement(By.cssSelector("input.form-control.link-input")).clear();// 清空这个输入框
            driver.findElement(By.cssSelector("input.form-control.link-input")).sendKeys(alURL.get(i));// 将需要转换的链接放入该输入框中
            driver.findElement(By.cssSelector("button.btn.btn-default")).click();// 点击解析
            Thread.sleep(4000);
            alMP4.add(driver.findElement(By.cssSelector("a.btn.btn-success")).getAttribute("href")); // 获取解析后的连接
        }
        driver.close();
        // 下载
        for (int i = 0; i < alMP4.size(); i++) {
            DownloadFile df = new DownloadFile();
            df.run(alMP4.get(i));
        }

    }
}
