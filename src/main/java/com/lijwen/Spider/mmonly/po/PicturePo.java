package com.lijwen.Spider.mmonly.po;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/15 0015
 * Time:下午 10:25
 */
public class PicturePo {
    private Long id;
    private String picUrl;
    private String picName;
    private int picPage;
    private int picSize;
    private boolean downloadflag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPicPage() {
        return picPage;
    }

    public void setPicPage(int picPage) {
        this.picPage = picPage;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }

    public int getPicSize() {
        return picSize;
    }

    public void setPicSize(int picSize) {
        this.picSize = picSize;
    }

    public boolean isDownloadflag() {
        return downloadflag;
    }

    public void setDownloadflag(boolean downloadflag) {
        this.downloadflag = downloadflag;
    }

    @Override
    public String toString() {
        return "PicturePo{" +
                "id=" + id +
                ", picUrl='" + picUrl + '\'' +
                ", picName='" + picName + '\'' +
                ", picPage=" + picPage +
                ", picSize=" + picSize +
                ", downloadflag=" + downloadflag +
                '}';
    }
}
