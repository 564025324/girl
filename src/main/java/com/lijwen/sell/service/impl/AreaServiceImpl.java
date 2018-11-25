package com.lijwen.sell.service.impl;

import com.lijwen.sell.dao.AreaDao;
import com.lijwen.sell.entity.Area;
import com.lijwen.sell.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/23 0023
 * Time:下午 10:27
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        int a = 1 / 0;
        return areaDao.queryAreaById(areaId);
    }

    @Transactional // 当抛出RuntimeException的时候事务就会回滚，查资料确认一下是不是Transactional默认RuntimeException的时候事务回滚
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectRow = areaDao.insertArea(area);
                if (effectRow > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息失败:" + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            area.setLastEditTime(new Date());
            try {
                int effectRow = areaDao.updateArea(area);
                if (effectRow > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("更新区域信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectRow = areaDao.deleteArea(areaId);
                if (effectRow > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("删除区域信息失败：" + e.toString());
            }
        } else {
            throw new RuntimeException("区域Id不能为空！");
        }
    }
}
