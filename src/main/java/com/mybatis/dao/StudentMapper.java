package com.mybatis.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.mybatis.entity.Student;
import org.springframework.stereotype.Repository;

/**
 * mybatis访问接口
 * @author Cherry
 * 2020年5月28日
 */
@Repository
public interface StudentMapper {

    Student findOne(int uuid);
    
    int addStudent(Student Student);

    ArrayList<Student> findByClassId(int classId);

}
