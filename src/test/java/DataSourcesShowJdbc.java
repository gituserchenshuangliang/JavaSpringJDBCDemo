import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.spring.entity.Role;
import com.spring.util.LoggerUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Dscreption:数据库操作测试
 * Cherry
 * 2020/6/7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-config.xml"})
public class DataSourcesShowJdbc {
    @Autowired
    JdbcTemplate jdbcTemplate;
    Logger logger = LoggerUtil.getLog(DataSourcesShowJdbc.class);
    @Test
    public void showSelect(){
        String sql = "Select * from role where id = "+1;
        Role role = jdbcTemplate.queryForObject(sql, (set,x) -> {
            Role r = new Role();
            r.setId(set.getInt("id"));
            r.setName(set.getString("role_name"));
            r.setNote(set.getString("note"));
            return r;
        });
        logger.info(role);

        String sql2 = "Select * from role";
        List<Role> list = jdbcTemplate.query(sql2,(set,i) -> {
            Role r = new Role();
            r.setId(set.getInt("id"));
            r.setName(set.getString("role_name"));
            r.setNote(set.getString("note"));
            return r;
        });
        logger.info(list);
    }

    @Test
    public void showAdd(){
        String sql = "Insert into role(id,role_name,note) values(?,?,?);";
        int i = jdbcTemplate.update(sql,4,"剑士","用剑刺");
        logger.info("update:" + i);
    }

    @Test
    public void showDel(){
        String sql = "delete from role where id = ? ;";
        int i = jdbcTemplate.update(sql,4);
        logger.info("update:" + i);
    }
    @Test
    public void showExcute(){
       Role role = jdbcTemplate.execute((ConnectionCallback<Role>) (conn) -> {
           String sql = "select * from role where id = ?";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1,3);
           ResultSet rs = ps.executeQuery();
           Role r = new Role();
           while (rs.next()){
               r.setId(rs.getInt("id"));
               r.setName(rs.getString("role_name"));
               r.setNote(rs.getString("note"));
           }
           return r;
       });
       logger.info(role);
    }

}
