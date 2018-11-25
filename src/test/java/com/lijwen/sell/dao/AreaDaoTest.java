package com.lijwen.sell.dao;

import com.lijwen.sell.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class) // 在pom.xml文件中引入的 spring-boot-starter-test
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> list = areaDao.queryArea();
        assertEquals(2, list.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑", area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(2);
        area.setCreateTime(new Date());
        int effectRow = areaDao.insertArea(area);
        System.out.println("执行影响行" + effectRow);
        assertEquals(1, effectRow);
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area = new Area();
        area.setAreaName("北苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectRow = areaDao.updateArea(area);
        assertEquals(1, effectRow);
    }

    @Test
    public void deleteArea() {
        int effectRow = areaDao.deleteArea(3);
        assertEquals(1, effectRow);
    }
}