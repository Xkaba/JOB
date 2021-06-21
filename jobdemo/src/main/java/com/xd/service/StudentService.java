package com.xd.service;

import com.xd.pojo.Student;

import java.util.List;

public interface StudentService {

    public boolean studentIsExist(int sid);

    public Student getStudentById(int sid);

    public List<Student> getStudentList();

    public String addStudent(Student student);

    public String updateStudent(Student student);

    public String deleteStudent(int sid);

    public boolean confirmStudent(int sid,String spassword);
}
