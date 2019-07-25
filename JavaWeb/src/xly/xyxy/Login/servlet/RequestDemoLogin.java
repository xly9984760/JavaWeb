package xly.xyxy.Login.servlet;

import org.apache.commons.beanutils.BeanUtils;
import xly.xyxy.Login.Dao.UserDao;
import xly.xyxy.Login.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.web
 * @Author: 99847
 * @CreateTime: 2019-07-24 19:22
 * @Description: 登录案例
 * BeanUtils工具类，简化数据封装
 * 			* 用于封装JavaBean的
 * 			1. JavaBean：标准的Java类
 * 				1. 要求：
 * 					1. 类必须被public修饰
 * 					2. 必须提供空参的构造器
 * 					3. 成员变量必须使用private修饰
 * 					4. 提供公共setter和getter方法
 * 				2. 功能：封装数据
 *
 *
 * 			2. 概念：
 * 				成员变量：
 * 				属性：setter和getter方法截取后的产物
 * 					例如：getUsername() --> Username--> username
 *
 *
 * 			3. 方法：
 * 				1. setProperty()
 * 				2. getProperty()
 * 				3. populate(Object obj , Map map):将map集合的键值对信息，封装到对应的JavaBean对象中
 */
@WebServlet("/register")
public class RequestDemoLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("utf-8");
//        String username = req.getParameter("username");
//        String password = req.getParameter("password");
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        Map<String, String[]> map = req.getParameterMap();
        User loginUser = new User();
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        UserDao dao = null;
        try {
            dao = new UserDao();
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = dao.login(loginUser);
        if (user == null) {
            req.getRequestDispatcher("/fails").forward(req,resp);
        } else {
            req.setAttribute("user",user.getUsername());
            req.getRequestDispatcher("/success").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        doGet(req,resp);

    }
}
