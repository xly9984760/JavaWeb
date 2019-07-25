package xly.xyxy.Login.test;

import org.junit.Test;
import xly.xyxy.Login.Dao.UserDao;
import xly.xyxy.Login.domain.User;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.Login.test
 * @Author: 99847
 * @CreateTime: 2019-07-24 21:05
 * @Description: user测试
 */
public class UserTest {
    @Test
    public void testLogin() {
        User loginUser = new  User();
        loginUser.setUsername("小明");
        loginUser.setPassword("123456");

        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
