package xly.xyxy.Login.servlet;

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
 * @Description: 成功页面
 */
@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getAttribute("user");
        if (user != null) {
            resp.setContentType("utf-8");
//        输出
            resp.getWriter().write("登录成功" + user.getUsername() + "欢迎您！");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
