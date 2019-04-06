package org.fh.shop.admin.mays.interception;

import org.fh.shop.admin.mays.model.po.user.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterception implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uriString = request.getRequestURI();
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");

        //stringObject.endsWith("") 测试字符串是否以指定字符串结尾
        if (uriString.startsWith("/api/") ||uriString.endsWith("login.action") || user!=null || uriString.endsWith("addUser.action") || uriString.endsWith("toaddUser.action")) {
            return true;
        }
        //获取项目根目录
        String path = request.getContextPath();
        //设置跳转路径
        //request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        response.sendRedirect(path+"/login.jsp");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
