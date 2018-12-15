package com.lijwen.util;

import com.lijwen.Spider.mmonly.po.PicturePo;
import com.lijwen.Spider.mmonly.po.UrlPo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/12/16 0016
 * Time:上午 12:31
 */
public class JdbcHelper {


    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String DBurl = "jdbc:mysql://localhost:3306/seckill";
    private static final String user = "root";
    private static final String password = "root";
    private static PreparedStatement pstm = null;
    private static Connection conn = null;

    public static void main(String[] args) throws Exception {
        System.out.println(selectPicByUrl(""));
        // try {
        // Class.forName(driver);
        // conn = DriverManager.getConnection(DBurl, user, password);
        //
        // String sql = "select * from seckill ;";
        // pstm = conn.prepareStatement(sql);
        //
        // System.out.println("数据库连接成功");
        //
        // // for (Urldb url : selectUrldbByUrl("")) {
        // // System.out.println(url.getUrl());
        // // }
        //
        // // insertPicturebUrl("123333333333");
        // } catch (ClassNotFoundException | SQLException e) {
        // e.printStackTrace();
        // }
    }

    public static Connection getConnection() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(DBurl, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static List<UrlPo> selectUrldbByUrl(String url) throws SQLException {
        List<UrlPo> list = new ArrayList<UrlPo>();
        try {
            String sql = "select * from urldb ";
            if (!"".equals(url)) {
                sql = sql + " where url = '" + url + "'";
            }
            conn = getConnection();
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                UrlPo urlinfo = new UrlPo();
                urlinfo.setId(rs.getLong(1));
                urlinfo.setUrl(rs.getString(2));
                list.add(urlinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库查询异常");
        } finally {
            conn.close();
            pstm.close();
        }
        return list;
    }

    public static List<PicturePo> selectPicByUrl(String url) throws SQLException {
        List<PicturePo> list = new ArrayList<PicturePo>();
        try {
            String sql = "select * from url_pic ";
            if (!"".equals(url)) {
                sql = sql + " where url_name = '" + url + "'";
            }
            conn = getConnection();
            pstm = conn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                PicturePo pic = new PicturePo();
                pic.setId(rs.getLong(1));
                pic.setPicUrl(rs.getString(2));
                pic.setPicName(rs.getString(3));
                list.add(pic);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库查询异常");
        } finally {
            conn.close();
            pstm.close();
        }
        return list;
    }


    public static boolean existPicUrlByUrl(String url) throws SQLException {
        try {
            String sql = "select * from url_pic ";
            if (!"".equals(url)) {
                sql = sql + " where url = '" + url + "'";
            }
            conn = getConnection();
            pstm = conn.prepareStatement(sql);
            if (pstm.executeQuery(sql).getRow() > 0)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("数据库查询异常");
        } finally {
            conn.close();
            pstm.close();
        }
        return false;
    }

    public static void insertPictureUrl(PicturePo pic) throws SQLException {
        try {
            conn = getConnection();
            String sql = "insert into url_pic(url_name,url_addr) values (?,?);";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, pic.getPicUrl());
            pstm.setString(2, pic.getPicName());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            pstm.close();
        }
    }

    public static void insertHtmlUrl(UrlPo url) throws SQLException {
        try {
            String sql = "insert into urldb(url,url_type) values (?,?);";
            conn = getConnection();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, url.getUrl());
            pstm.setInt(2, url.getUrl_type());
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
            pstm.close();
        }
    }

    //public void insertFilePath(String fileName, String filePath, String url) throws SQLException {
    //    try {
    //        Class.forName(driver);
    //        conn = DriverManager.getConnection(DBurl, user, password);
    //        System.out.println("数据库连接成功");
    //
    //        String sql = "insert into spilder(filename,filepath,url) values (?,?,?);";
    //        pstm = conn.prepareStatement(sql);
    //        pstm.setString(1, fileName);
    //        pstm.setString(2, filePath);
    //        pstm.setString(3, url);
    //        pstm.executeUpdate();
    //
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    } finally {
    //        conn.close();
    //        pstm.close();
    //    }
    //}


}
