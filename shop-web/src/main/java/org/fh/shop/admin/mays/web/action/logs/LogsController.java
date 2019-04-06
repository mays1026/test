package org.fh.shop.admin.mays.web.action.logs;

import org.fh.shop.admin.mays.model.logs.LogsInfo;
import org.fh.shop.admin.mays.service.logs.ILogsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/logs")
public class LogsController {

    @Resource
    private ILogsService logsService;

    @RequestMapping("tologsMangerPage")
    public String tologsMangerPage(){
        return "logs/logsList";
    }


    /**
     * 日志查询
     */
    @RequestMapping("findLogsList")
    @ResponseBody
    public Map findLogsList(LogsInfo logsInfo){
        Long count = logsService.countListSize(logsInfo);
        List<LogsInfo> list = logsService.findLogsList(logsInfo);
        Map map = new HashMap();
        map.put("draw", logsInfo.getDraw());
        map.put("recordsTotal", list.size());
        map.put("recordsFiltered", count);
        map.put("data", list);
        return map;
    }

}
