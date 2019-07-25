package xly.xyxy.Download.utils;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.Download.utils
 * @Author: 99847
 * @CreateTime: 2019-07-25 01:56
 * @Description: 不同浏览器的编码
 */
public class DownLoadUtils {
    public static String getFileName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
//            IE浏览器
            filename = URLEncoder.encode(filename,"utf-8");
            filename = filename.replace("+" , " ");
        } else if (agent.contains("Firefox")) {
//            火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
//            其他浏览器
            filename = URLEncoder.encode(filename,"utf-8");
        }
        return filename;
    }
}
