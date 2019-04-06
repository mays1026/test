package org.fh.shop.admin.mays.web.action.area;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.area.AreaInfo;
import org.fh.shop.admin.mays.service.area.IAreaService;
import org.fh.shop.admin.mays.staticFinal.SystemStauts;
import org.fh.shop.admin.mays.util.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名: AreaController
 * 描述：
 *
 * @author
 * @create 2019-03-12 21:44
 **/
@Controller
@RequestMapping("/area/")
public class AreaController {

    @Resource
    private IAreaService areaService;

    /**
     * 加载 ztree
     * area列表
     * @return
     */
    @RequestMapping("initAreaList")
    @ResponseBody
    public ServiceResponse initAreaList() {
        List<AreaInfo> list = (List<AreaInfo>) CacheManager.getInstance().getObj(SystemStauts.AREALIST);
        if (list != null) {
            return ServiceResponse.success(list);
        }
        list = areaService.initAreaList();
        List<Map> listMap = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map map = new HashMap();
            AreaInfo areaInfo = list.get(i);
            map.put("id", areaInfo.getId());
            map.put("name", areaInfo.getAreaname());
            map.put("pId", areaInfo.getParentid());
            listMap.add(map);
        }
        CacheManager.getInstance().putObj(SystemStauts.AREALIST, listMap);
        return  ServiceResponse.success(list);
    }

    /**
     * 添加 area信息
     * @param areaInfo
     * @return
     */
    @RequestMapping("addAreaInfo")
    @ResponseBody
    public ServiceResponse addAreaInfo(AreaInfo areaInfo) {
        ServiceResponse serviceResponse = areaService.addAreaInfo(areaInfo);
        CacheManager.getInstance().remove(SystemStauts.AREALIST);
        return serviceResponse;
    }


    /**
     * 删除area信息
     * @param id
     * @return
     */
    @RequestMapping("deleteAreaById")
    @ResponseBody
    public ServiceResponse deleteAreaById(Integer id){
        ServiceResponse serviceResponse = areaService.deleteAreaById(id);
        CacheManager.getInstance().remove(SystemStauts.AREALIST);
        return serviceResponse;
    }

    /**
     * 修改信息
     * @param areaInfo
     * @return
     */
    @RequestMapping("updateAreaData")
    @ResponseBody
    public ServiceResponse updateAreaData(AreaInfo areaInfo){
        ServiceResponse serviceResponse = areaService.updateAreaData(areaInfo);
        CacheManager.getInstance().remove(SystemStauts.AREALIST);
        return serviceResponse;
    }
}
