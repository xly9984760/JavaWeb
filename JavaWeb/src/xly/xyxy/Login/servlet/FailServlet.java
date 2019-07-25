package xly.xyxy.Login.servlet;

import org.junit.Test;
import sun.security.jgss.HttpCaller;
import xly.xyxy.Login.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.Login.servlet
 * @Author: 99847
 * @CreateTime: 2019-07-25 08:59
 * @Description: 失败页面
 */
@WebServlet("/fails")
public class FailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
//        输出
        resp.getWriter().write("登录失败!账号或密码错误");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
