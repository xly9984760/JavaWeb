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
 * @CreateTime: 2019-07-24 17:45
 * @Description: request共享数据
 * 3.共享数据
 *      域对象：一个有作用范围的对象，可以在作用范围内共享数据
 *      request域：代表一次请求的范围，一般用于请求转发的多个资源中共享数据
 *      方法：
 *          1. setAttribute(String name, Object args) :存储数据
 *          2. getAttribute(String name) : 通过键获取值
 *          3. removeAttribute(String name) : 移除某个数据
 */
@WebServlet("/demo8")
public class RequestDemo8 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取数据
        req.setAttribute("小孩子","天真");
        req.getRequestDispatcher("/demo7").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
