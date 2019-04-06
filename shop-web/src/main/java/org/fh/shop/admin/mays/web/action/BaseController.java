package org.fh.shop.admin.mays.web.action;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 类名: BaseController
 * 描述：
 *
 * @author
 * @create 2019-02-19 14:11
 **/

public class BaseController {
    /**
     * 获得项目的绝对路径
     * @param request
     * @return
     */
    public String getFileRealPath(HttpServletRequest request) {
        return request.getServletContext().getRealPath("/");
    }


    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Map<String, Object> map = new HashMap();
            map.put("zxc", 1);
            list.add(map);
        }

        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            Set set = map.keySet();
            for (Object o : set) {
                System.out.println(o);
            }
        }

    }

}
