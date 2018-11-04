package com.lijwen.girl.controller;

import com.lijwen.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
//@Controller和 @ResponseBody 相当于 @RestController
@RestController
@RequestMapping("/hello")
public class HelloController {

//    @Value("${girl}")// 获取application.yml中的内容获取到
//    private String girl;

    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/{id}/say", method = RequestMethod.GET)
    public String say(@PathVariable("id") int id) {
//        return girlProperties.getCupSize();
        return "id :" + id;
    }

}
