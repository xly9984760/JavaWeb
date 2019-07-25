package xly.xyxy.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.web
 * @Author: 99847
 * @CreateTime: 2019-07-24 16:38
 * @Description: request其他功能
 *      1.获取请求参数通用方式
 *         *1. String getParameter(String name) 根据参数名称获取参数值
 *          2. String[] getParameterValues(String name)： 根据参数名称获取参数值，多用于复选框
 *          3. Enumeration<String> getParameterNames() 获取所有的参数名称
 *         *4. Map<String,String[]> getParameterMap() 获取所有参数的Map集合
 *         *中文乱码问题：
 *              get方法Tomcat已经解决了乱码问题
 *              post方法:会乱码
 *                  解决：在获取参数前，设置request的编码request.setCharacterEncoding("utf-8")
 */
@WebServlet("/demo6")
public class RequestDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      post方法解决乱码问题  req.setCharacterEncoding("utf-8");
        req.setCharacterEncoding("utf-8");
//      根据参数名称获取参数值
        String username = req.getParameter("username");
        System.out.println(username);
//      获取所有的参数名称
        Enumeration<String> parameterNames = req.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String s = parameterNames.nextElement();
            System.out.println("参数：" + s + "  参数值：" +req.getParameter(s));
        }
//      根据参数名称获取参数值，多用于复选框
        String[] hobby = req.getParameterValues("hobby");
        for (String i : hobby) {
            System.out.println(i);
        }
//      获取所有参数的Map集合
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> keyset = parameterMap.keySet();
        for (String i : keyset) {
            String[] values = parameterMap.get(i);
            for (String value : values) {
                System.out.print(value + " ");
            }
        }

    }
}
