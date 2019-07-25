package xly.xyxy.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.web
 * @Author: 99847
 * @CreateTime: 2019-07-23 09:50
 * @Description: Servlet生命周期
 * 被创建： 执行init方法，只执行一次
 *      默认情况下，第一次访问时，servlet被创建
 *      创建时机利用<load-on-startup></load-on-startup>指定时机
 * 提供服务：执行service方法，执行多次
 * 被销毁：执行destory方法，只执行一次
 */
public class ServletDemo1 implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("hello,servlet!");

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
