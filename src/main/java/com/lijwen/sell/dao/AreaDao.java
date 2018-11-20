package com.lijwen.sell.dao;

import com.lijwen.sell.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 获取所有区域列表
     *
     * @return
     */
    List<AreaDao> queryArea();

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
    int insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     *
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);
}
