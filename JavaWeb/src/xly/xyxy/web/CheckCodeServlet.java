package xly.xyxy.web;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.web
 * @Author: 99847
 * @CreateTime: 2019-07-25 17:39
 * @Description: 验证码
 */
@WebServlet("/check")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;
//        创建图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
//        美化图片
        Graphics graphics = image.getGraphics();
//        填充颜色
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);
//        画边框
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0,0,width-1,height-1);
//        写验证码
        Random random = new Random();
        for (int i = 1; i <= 4; i++) {
            int i1 = random.nextInt(52);
            char c = (char) (i1 + 64);
            graphics.drawString(c+"",width/5*i,height/2);
        }
//        画干扰线
        graphics.setColor(Color.blue);
//        随机生成坐标点
        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);
            int h1 = random.nextInt(height);
            int h2 = random.nextInt(height);

            graphics.drawLine(x1, x2, h1, h2);
        }
//        将图片输出到页面上展示
        ImageIO.write(image,"jpg",resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
