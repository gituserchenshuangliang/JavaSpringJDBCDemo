import com.spring.config.AppConfig;
import com.spring.entity.Role;
import com.spring.util.LoggerUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @description:
 * @author: Cherry
 * @time: 2020/6/8 9:33
 */
public class Show {
    @Test
    public void show1(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

        JdbcTemplate jdbc = app.getBean(JdbcTemplate.class);

        String sql = "select * from role where id = 1;";

        Role role = jdbc.queryForObject(sql,(set,i) -> {
           Role r = new Role();
           r.setId(set.getInt("id"));
           r.setName(set.getString("role_name"));
           r.setNote(set.getString("note"));
           return r;
        });
        LoggerUtil.getLog(Show.class).info(role);
    }

    @Test
    public void show2(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

        JdbcTemplate jdbc = app.getBean(JdbcTemplate.class);

        String sql = "delete from role where id = 7;";

        jdbc.update(sql);
    }

    /**
     * 编程式事务
     * 手动管理数据库事务
     */
    @Test
    public void show3(){
        ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

        JdbcTemplate jdbc = app.getBean(JdbcTemplate.class);

        TransactionDefinition td = new DefaultTransactionDefinition();

        PlatformTransactionManager pt = app.getBean(PlatformTransactionManager.class);

        TransactionStatus status = pt.getTransaction(td);

        String sql = "delete from role where id = 7;";

        try {
            jdbc.update(sql);
            pt.commit(status);
        }catch (Exception e){
            pt.rollback(status);
        }

    }
}
