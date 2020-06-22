package com.mybatis.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.mybatis.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * mybatis访问接口
 * @author Cherry
 * 2020年5月28日
 */
@Repository
public interface TeacherMapper {
    /**
     * JavaBean方式传递参数
     * @param teacher
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,timeout = 3)
    int addTeacher(Teacher teacher);

    /**
     * 注解方式传递参数
     * @param uuid
     * @return
     */
    int deleteTeacher(@Param("uuid") int uuid);

    /**
     * JavaBean方式传递参数
     * @param teacher
     * @return
     */
    int updateTeacher(Teacher teacher);

    Teacher findOne(int uuid);

    /**
     * map方式传递参数
     * @param maps
     * @param rowBounds MyBatis 会自动识别它,据此进行分页,它只能运用于一些小数据量的查询。
     * @return
     */
    ArrayList<Teacher> findTeachers(@Param("maps") HashMap<String,Object> maps, RowBounds rowBounds);

    /**
     * 混合方式传递参数,无需声明parameterType
     * @param maps
     * @param limit
     * @param start
     * @return
     */
    ArrayList<HashMap<String,Object>> findTeacherField(@Param("maps") HashMap<String,Object> maps,@Param("limit") int limit,@Param("start") int start);

    /**
     * 出入数组参数
     * @param ids
     * @return
     */
    ArrayList<Teacher> findTeachersByIds(int[] ids);
}
