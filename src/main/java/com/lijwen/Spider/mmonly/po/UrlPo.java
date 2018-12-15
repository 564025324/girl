package com.lijwen.Spider.mmonly.po;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/15 0015
 * Time:下午 10:22
 */
public class UrlPo {
    private Long Id;
    private String url;
    private boolean downloadflag;
    private int url_type; // 0主页，1明细画册
    private int pages;
    private String pic_type;

    public UrlPo() {
        this.url = "";
        this.downloadflag = false;
        this.url_type = 0;
        this.pages = 0;
    }

    public UrlPo(String url, int pages) {
        this.url = url;
        this.downloadflag = false;
        this.url_type = 1;
        this.pages = pages;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDownloadflag() {
        return downloadflag;
    }

    public void setDownloadflag(boolean downloadflag) {
        this.downloadflag = downloadflag;
    }

    public int getUrl_type() {
        return url_type;
    }

    public void setUrl_type(int url_type) {
        this.url_type = url_type;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getPic_type() {
        return pic_type;
    }

    public void setPic_type(String pic_type) {
        this.pic_type = pic_type;
    }

    @Override
    public String toString() {
        return "UrlPo{" +
                "Id=" + Id +
                ", url='" + url + '\'' +
                ", downloadflag=" + downloadflag +
                ", url_type=" + url_type +
                ", pages=" + pages +
                ", pic_type='" + pic_type + '\'' +
                '}';
    }
}
