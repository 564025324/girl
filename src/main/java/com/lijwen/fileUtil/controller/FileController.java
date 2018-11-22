package com.lijwen.fileUtil.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/21 0021
 * Time:上午 11:13
 */
@RestController
@RequestMapping(value = "/file")
public class FileController {

    @RequestMapping(value = "/hello")
    public String index() {
        return "Welcome " + FileController.class;
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public String file(HttpServletRequest request, HttpServletResponse response) {
        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());
                String fileNames = file.getOriginalFilename();
                int split = fileNames.lastIndexOf(".");
                System.out.println("filename:" + fileNames);
                //存储文件
                System.out.println("文件名:" + fileNames.substring(0, split));
                System.out.println("文件格式:" + fileNames.substring(split + 1));
                //文件内容 file.getBytes()
                System.out.println("文件内容:" + file.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
