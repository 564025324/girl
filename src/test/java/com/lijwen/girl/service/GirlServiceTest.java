package com.lijwen.girl.service;

import com.lijwen.girl.domail.Girl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/11 0011
 * Time:下午 5:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest // 表示将启用整个springboot的工程
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

    @Test
    public void findOneTest() {
        Girl girl = girlService.findOne(10);
        Assert.assertEquals(new Integer(32), girl.getAge());
    }
}
