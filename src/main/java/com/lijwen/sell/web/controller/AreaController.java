package com.lijwen.sell.web.controller;

import com.lijwen.sell.entity.Area;
import com.lijwen.sell.service.impl.AreaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By IntelliJ IDEA
 * Users：Lijingwen
 * Date:2018/11/23 0023
 * Time:下午 11:41
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {

    @Autowired
    private AreaServiceImpl areaService;

    /**
     * 查询当前所有的area列表
     *
     * @return
     */
    @RequestMapping(value = "listarea", method = RequestMethod.GET)
    private Map<String, Object> listArea() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("areaList", areaService.queryArea());
        return modelMap;
    }

    /**
     * 根据areaid查询area信息
     *
     * @param areaId
     * @return
     */
    @RequestMapping(value = "getareabyid", method = RequestMethod.GET)
    private Map<String, Object> getAreaById(Integer areaId) {
        Map<String, Object> modelMap = new HashMap<>();
        Area area = areaService.queryAreaById(areaId);
        modelMap.put("area", area);
        return modelMap;
    }

    /**
     * 添加一个区域信息
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    private Map<String, Object> addArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.addArea(area));
        return modelMap;
    }

    /**
     * 修改区域信息
     *
     * @param area
     * @return
     */
    @RequestMapping(value = "/modifyarea", method = RequestMethod.POST)
    private Map<String, Object> modifyArea(@RequestBody Area area) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.modifyArea(area));
        return modelMap;
    }

    /**
     * 根据areaid删除一个区域信息
     *
     * @param areaid
     * @return
     */
    @RequestMapping(value = "/removearea", method = RequestMethod.GET)
    private Map<String, Object> removeArea(Integer areaid) {
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.deleteArea(areaid));
        return modelMap;
    }


}
