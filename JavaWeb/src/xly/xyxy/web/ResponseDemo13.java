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
 * @CreateTime: 2019-07-25 13:03
 * @Description: 路径写法和动态目录
 * * 路径写法：
 * 				1. 路径分类
 * 					1. 相对路径：通过相对路径不可以确定唯一资源
 * 						* 如：./index.html
 * 						* 不以/开头，以.开头路径
 *
 * 						* 规则：找到当前资源和目标资源之间的相对位置关系
 * 							* ./：当前目录
 * 							* ../:后退一级目录
 * 					2. 绝对路径：通过绝对路径可以确定唯一资源
 * 						* 如：http://localhost/web/demo13         /web/demo13
 * 						* 以/开头的路径
 *
 * 						* 规则：判断定义的路径是给谁用的？判断请求将来从哪儿发出
 * 							* 给客户端浏览器使用：需要加虚拟目录(项目的访问路径)
 * 								* 建议虚拟目录动态获取：request.getContextPath()
 * 								* <a> , <form> 重定向...
 * 							* 给服务器使用：不需要加虚拟目录
 * 								* 转发路径
 * * 动态路径：
 *      String contextPath = req.getContextPath() 给客户端浏览器使用时，虚拟目录动态获取
 *
 */
@WebServlet("/demo13")
public class ResponseDemo13 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
