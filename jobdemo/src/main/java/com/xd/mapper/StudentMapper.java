package com.xd.mapper;


import com.xd.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    List<Student> getStudentList();

    Student getStudentById(int sid);

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(int sid);


}
