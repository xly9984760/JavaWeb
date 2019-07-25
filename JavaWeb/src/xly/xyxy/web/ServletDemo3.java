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
 * @CreateTime: 2019-07-23 20:26
 * @Description: HTTPServlet抽象类
 * 体系：Servlet --接口
 *          ||
 *       GenericServlet --抽象类(将Servlet接口中的其他方法做了默认空实现，只将service方法作为抽象)
 *         ||
 *       HttpServlet --抽象类(对http协议的一种封装，简化操作，
 *                          service对doGet和doPost进行的封装，
 *                          所以只要复写doGet和doPost)
 */
@WebServlet("/demo3")
public class ServletDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost...");
    }
}
