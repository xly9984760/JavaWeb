package xly.xyxy.Login.Dao;


import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import xly.xyxy.Login.domain.User;
import xly.xyxy.Login.utils.JDBCUtils;

/**
 * @BelongsProject: web
 * @BelongsPackage: xly.xyxy.Login.Dao
 * @Author: 99847
 * @CreateTime: 2019-07-24 20:55
 * @Description: 操作数据库中user表的类
 */
public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    public User login(User user) {
        try {
            User login = template.queryForObject("select * from user where username=? and password=?",
                        new BeanPropertyRowMapper<User>(User.class),user.getUsername(),user.getPassword());
            return login;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
