import java.util.HashMap;
import java.util.List;

import com.mybatis.dao.ClassRoomMapper;
import com.mybatis.dao.StudentMapper;
import com.mybatis.entity.ClassRoom;
import com.mybatis.entity.Student;
import com.mybatis.typehandle.SexEnum;
import org.apache.ibatis.session.RowBounds;

import com.mybatis.dao.TeacherMapper;
import com.mybatis.entity.Teacher;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.spring.util.LoggerUtil;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 演示
 * @author Cherry
 * 2020年5月28日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-config.xml"})
public class SpringMybatisShow {
    @Autowired
    TeacherMapper mapper ;
    @Autowired
    StudentMapper mapper2;
    @Autowired
    ClassRoomMapper mapper3;
    
    Logger logger = LoggerUtil.getLog(SpringMybatisShow.class);
    @Test
    public void addTeacher(){
        Teacher t2 = new Teacher("上官琴",26, "Dance", "F",4500);
        mapper.addTeacher(t2);
        //生成的主键赋值给t2
        logger.info(t2.getUuid());
    }

    @Test
    @Transactional(propagation = Propagation.NEVER,isolation = Isolation.DEFAULT,timeout = 3)
    public void deleteTeacher(){
    mapper.deleteTeacher(19);
    }

    @Test
    public void updateTeacher(){
        Teacher t = new Teacher();
        t.setUuid(22);
        t.setName("尉迟洪");
        mapper.updateTeacher(t);
    }

    @Test
    public void findOne(){
        mapper.findOne(22);
    }

    @Test
    public void findTeachers(){
        HashMap<String, Object> map = new HashMap<>();
        //Mybatis分页类
        RowBounds row = new RowBounds(1,2);
        map.put("major","c");
        int i = mapper.findTeachers(map,row).size();
        logger.info(i);
    }

    @Test
    public void findTeacherField(){
        HashMap<String, Object> maps = new HashMap<>();
        mapper.findTeacherField(maps,3,1);
    }
    
    @Test
    public void findOneStu(){
        Student s = mapper2.findOne(4);
        logger.info(s);
    }

    @Test
    public void findStuByClass(){
        List<Student> s = mapper2.findByClassId(1);
        logger.info(s);
    }

    @Test
    public void findClassRoom(){
        ClassRoom s = mapper3.findByUuid(1);
        logger.info(s.getTeacher());
        logger.info("准备调用List,延时加载，调用时才执行SQL");
        logger.info(s.getList());
    }

    @Test
    public void addStu(){
        Student s = new Student();
        s.setName("祝龙");
        s.setSex(SexEnum.FEMAL);
        s.setClassUuid(2);
        mapper2.addStudent(s);
        logger.info(s);
    }
}
