package xly.xyxy.Download.servlet;

import xly.xyxy.Download.utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.Download.servlet
 * @Author: 99847
 * @CreateTime: 2019-07-25 02:06
 * @Description: 下载文件Servlet
 * ## 案例：
 * 	* 文件下载需求：
 * 		1. 页面显示超链接
 * 		2. 点击超链接后弹出下载提示框
 * 		3. 完成图片文件下载
 *
 *
 * 	* 分析：
 * 		1. 超链接指向的资源如果能够被浏览器解析，则在浏览器中展示，如果不能解析，则弹出下载提示框。不满足需求
 * 		2. 任何资源都必须弹出下载提示框
 * 		3. 使用响应头设置资源的打开方式：
 * 			* content-disposition:attachment;filename=xxx
 *
 *
 * 	* 步骤：
 * 		1. 定义页面，编辑超链接href属性，指向Servlet，传递资源名称filename
 * 		2. 定义Servlet
 * 			1. 获取文件名称
 * 			2. 使用字节输入流加载文件进内存
 * 			3. 指定response的响应头： content-disposition:attachment;filename=xxx
 * 			4. 将数据写出到response输出流
 *
 *
 * 	* 问题：
 * 		* 中文文件问题
 * 			* 解决思路：
 * 				1. 获取客户端使用的浏览器版本信息
 * 				2. 根据不同的版本信息，设置filename的编码方式不同
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        获取请求参数，文件名称
        String filename = req.getParameter("filename");
        //2.使用字节输入流加载文件进内存
        //2.1找到文件服务器路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/WEB-INF/classes/xly/xyxy/Download/img/" + filename);
        //2.2用字节流关联
        FileInputStream fis = new FileInputStream(realPath);

        //3.设置response的响应头
        //3.1设置响应头类型：content-type
        String mimeType = servletContext.getMimeType(filename);//获取文件的mime类型
        resp.setHeader("content-type",mimeType);
        //3.2设置响应头打开方式:content-disposition

        //解决中文文件名问题
        //1.获取user-agent请求头、
        String agent = req.getHeader("user-agent");
        //2.使用工具类方法编码文件名即可
        filename = DownLoadUtils.getFileName(agent, filename);

        resp.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流的数据写出到输出流中
        ServletOutputStream sos = resp.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }

        fis.close();
    }
}
