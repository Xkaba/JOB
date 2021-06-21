package com.xd.service.impl;

import com.xd.mapper.StudentMapper;
import com.xd.pojo.Student;
import com.xd.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public boolean studentIsExist(int sid){
        Student student = studentMapper.getStudentById(sid);
        if(student==null) return false;
        else return true;
    }

    @Override
    public Student getStudentById(int sid){
        Student student = studentMapper.getStudentById(sid);
        return student;
    }

    @Override
    public List<Student> getStudentList() {
        List<Student> studentList = studentMapper.getStudentList();
        return studentList;
    }

    @Override
    public String addStudent(Student student) {
        studentMapper.addStudent(student);
        return "ok";
    }

    @Override
    public String updateStudent(Student student) {
        studentMapper.updateStudent(student);
        return "ok";
    }

    @Override
    public String deleteStudent(int sid) {
        studentMapper.deleteStudent(sid);
        return "ok";
    }

    @Override
    public boolean confirmStudent(int sid,String spassword){
        Student student = studentMapper.getStudentById(sid);
        boolean b = student.getSpassword().equals(spassword);
        return b;
    }
}
