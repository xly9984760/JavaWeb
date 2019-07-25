package xly.xyxy.web;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.web
 * @Author: 99847
 * @CreateTime: 2019-07-25 13:05
 * @Description: 服务器输出到浏览器
 * 2. 服务器输出字符数据到浏览器
 * 			* 步骤：
 * 				1. 获取字符输出流
 * 				2. 输出数据
 *
 * 			* 注意：
 * 				* 乱码问题：
 * 					1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
 * 					2. 设置该流的默认编码
 * 					3. 告诉浏览器响应体使用的编码
 *
 * 					//简单的形式，设置编码，是在获取流之前设置
 *         			response.setContentType("text/html;charset=utf-8");
 * 		3. 服务器输出字节数据到浏览器
 * 			* 步骤：
 * 				1. 获取字节输出流
 * 				2. 输出数据
 *
 * 		4. 验证码
 * 			1. 本质：图片
 * 			2. 目的：防止恶意表单注册
 */
@WebServlet("/demo14")
public class ResponseDemo14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        1.字符输出流
////        解决乱码问题
//        resp.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = resp.getWriter(); 获取的流的默认编码是ISO-8859-1,浏览器是GB2312
////        writer.write("response");
////        浏览器会自动解析html标签
//        writer.write("<h1>广州美的</h1>");
//        2.字节输出流  一般用于图片
        resp.setContentType("text/html;charset=utf-8");
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write("小样".getBytes("utf-8"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
