package com.lijwen.sell.service;

import com.lijwen.sell.entity.Area;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/23 0023
 * Time:下午 10:25
 */
@Service
public interface AreaService {
    /**
     * 获取所有区域列表
     *
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据Id列出具体区域信息
     *
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     *
     * @param area
     * @return
     */
    boolean addArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
