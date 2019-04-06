package org.fh.shop.admin.mays.web.action.dept;

import org.fh.shop.admin.mays.common.ServiceResponse;
import org.fh.shop.admin.mays.model.po.dept.DeptInfo;
import org.fh.shop.admin.mays.service.dept.IDeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类名: DeptController
 * 描述：
 *
 * @author
 * @create 2019-03-03 14:26
 **/
@Controller
@RequestMapping("/dept/")
public class DeptController {

    @Resource
    private IDeptService deptService;

    /**
     * 跳转到查询页面
     *
     * @return
     */
    @RequestMapping("todeptList")
    public String todeptList() {
        return "dept/deptList";
    }


    /**
     * ajax 查询方法
     */
    @RequestMapping("findDeptList")
    @ResponseBody
    public Map<String, Object> findDeptList(DeptInfo deptInfo) {
        Long count = deptService.countDeptList(deptInfo);
        List<DeptInfo> list = deptService.findDeptList(deptInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("draw", deptInfo.getDraw());
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", count);
        map.put("data", list);
        return map;
    }


    /**
     * 初始化 ztree List<Map>
     *
     * @return
     */
    @RequestMapping("initDeptList")
    @ResponseBody
    public List<Map> initDeptList() {
        List<DeptInfo> list = deptService.initDeptList();
        List<Map> listMap = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map map = new HashMap();
            DeptInfo deptInfo = list.get(i);
            map.put("id", deptInfo.getId());
            map.put("name", deptInfo.getIndustryTitle());
            map.put("pId", deptInfo.getPid());
            map.put("remark", deptInfo.getRemark());
            listMap.add(map);
        }
        return listMap;
    }


    /**
     * 添加节点
     *
     * @param deptInfo
     */
    @RequestMapping("addDeptInfo")
    @ResponseBody
    public ServiceResponse addDeptInfo(DeptInfo deptInfo) {
        deptService.addDeptInfo(deptInfo);
        return ServiceResponse.success(deptInfo.getId());
    }


    /**
     * 删除节点
     * @param ids
     * @return
     */
    @RequestMapping("deleteDeptInfo")
    @ResponseBody
    public ServiceResponse deleteDeptInfo(@RequestParam("ids[]") List<Integer> ids) {
        return deptService.deleteDeptInfo(ids);
    }

    /**
     * 修改
     * @param deptInfo
     * @return
     */
    @RequestMapping("updateDeptInfo")
    @ResponseBody
    public ServiceResponse updateDeptInfo(DeptInfo deptInfo) {
        deptService.updateDeptInfo(deptInfo);
        return ServiceResponse.success();
    }

}
