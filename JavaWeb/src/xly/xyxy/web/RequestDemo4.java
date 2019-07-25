package xly.xyxy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.web
 * @Author: 99847
 * @CreateTime: 2019-07-24 09:15
 * @Description: request功能
 * 1. 获取请求行数据
 *      GET /web/demo1 HTTP/1.1
 *      方法：
 *          1. 获取请求方式 ：GET
 *              String getMethod()
 *          2. 获取虚拟目录 ：/web
 *          `   String getContextPath()
 *          3. 获取Servlet路径 ：/demo1
 *              String getServletPath()
 *          4. 获取get方式请求参数： name = zhangsan
 *              String getQueryString()
 *          5. 请求请求URI ：/web/demo1
 *              String getRequestURI(); /web/demo1
 *              StringBuffer GetRequestURL(); http://localhost/web/demo1
 *
 *              URL:统一资源定位符 http://localhost/web/demo1
 *              URI:统一资源标识符 /web/demo1
 *          6. 获取协议及版本 ： HTTP/1.1
 *              String getProtocol()
 *          7. 获取客户机的ip地址
 *              String getRemoteAddr()
 *
 */
@WebServlet("/demo4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        1. 获取请求方式 ：GET
          String method = req.getMethod();
//        2. 获取虚拟目录 ：/web
          String  contextPath = req.getContextPath();
//        3. 获取Servlet路径 ：/demo1
          String servletPath = req.getServletPath();
//        4. 获取get方式请求参数： name = zhangsan
          String QueryString = req.getQueryString();
//        5. 请求请求URI ：/web/demo1
        String requestURI = req.getRequestURI();
        StringBuffer requestURL = req.getRequestURL();
//        6. 获取协议及版本 ： HTTP/1.1
        String protocol = req.getProtocol();
//        7. 获取客户机的ip地址
        String remoteaddr = req.getRemoteAddr();
        System.out.println(method + contextPath + servletPath + QueryString
                + requestURI + requestURL + remoteaddr + protocol);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
