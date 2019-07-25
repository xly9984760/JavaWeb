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
 * @CreateTime: 2019-07-24 17:31
 * @Description: request请求转发
 * 请求转发：一种服务器内部资源的跳转
 *      1. 步骤：
 *          1. 通过request对象获取请求转发对象 ：RequestDispatcher rd = req.getRequestDispatcher(String path)
 *          2. 使用RequestDispatcher对象的forward方法进行转发 rd.forword(req,resp)
 *      2. 特点:
 *          1. 浏览器地址栏路径没有发生变化
 *          2. 只能转发到当前服务器内部的资源
 *          3. 转发是一次请求
 */
@WebServlet("/demo7")
public class RequestDemo7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!(req.getAttribute("小孩子").equals("天真"))) {
            System.out.println("xxx");
            req.getRequestDispatcher("/demo8").forward(req, resp);
        } else {
//        接收/demo8的共享数据
            System.out.println(req.getAttribute("小孩子"));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        doGet(req, resp);
    }
}
