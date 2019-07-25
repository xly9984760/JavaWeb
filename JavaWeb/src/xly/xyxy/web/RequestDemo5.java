package xly.xyxy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.web
 * @Author: 99847
 * @CreateTime: 2019-07-24 11:24
 * @Description: request请求头
 * 2.获取请求头数据
 *      *String getHeader(String name):通过请求头名称获取请求头的值
 *      Enumeration<String> getHeaderNames(): 获取所有请求头名称
 */
@WebServlet("/demo5")
public class RequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = req.getHeader(name);
            System.out.println(name + ": " + value);
        }
//        获取请求头数据：user-agent
        String agent = req.getHeader("user-agent");
        if (agent.contains("Chrome")) {
            System.out.println("谷歌");
        } else if (agent.contains("Firefox")) {
            System.out.println("火狐");
        }
//        获取请求头数据：referer
        String referer = req.getHeader("referer");
        System.out.println(referer);
//        防盗链
        if (referer != null ) {
            if (referer.contains("/web")) {
//                System.out.println("正常");
                ;
            } else {
//                盗链
                System.out.println("请来我们正版网站！");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        post方法演示，获取请求体
        BufferedReader reader = req.getReader();
        String line = null;
        while ((line = reader.readLine()) != null ) {
            System.out.println(line);
        }
    }
}
