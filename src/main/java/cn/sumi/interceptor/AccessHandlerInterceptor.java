package cn.sumi.interceptor;

import cn.sumi.po.User;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 * 用户未登录直接访问/root路径一律不允许
 * Created by gonghf95 on 6/4/17.
 */
public class AccessHandlerInterceptor implements HandlerInterceptor {

    Logger logger = Logger.getLogger(AccessHandlerInterceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        User usr = (User) httpServletRequest.getAttribute("usr");
        if (usr == null) {//用户没有登录成功，访问路径越界，重定向到登录页面
            logger.info(httpServletRequest.getRemoteHost()+" 正在请求敏感路径...");
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
