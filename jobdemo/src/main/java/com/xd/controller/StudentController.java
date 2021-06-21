package com.xd.controller;

import com.xd.pojo.Student;
import com.xd.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "学生")
@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //获得所有学生信息
    @ApiOperation(value = "查看所有学生信息",httpMethod = "GET")
    @GetMapping("/getStudentList")
    public List<Student> getStudentList() {
        List<Student> studentList = studentService.getStudentList();
        return studentList;
    }

    //根据学生账号查询学生信息
    @ApiOperation(value = "根据id查看学生信息",httpMethod = "GET")
    @GetMapping("/getStudentById")
    public Student getStudentById(int sid) {
        Student student = studentService.getStudentById(sid);
        return student;
    }

    //学生注册
    @ApiOperation(value = "学生注册",httpMethod = "GET")
    @GetMapping("/addStudent")
    public String addStudent(Student student) {
        studentService.addStudent(student);
        return "ok";
    }

    //更新学生信息
    @ApiOperation(value = "更新学生信息",httpMethod = "GET")
    @GetMapping("/updateStudent")
    public String updateStudent(Student student) {
        studentService.updateStudent(student);
        return "ok";
    }

    //注销学生账号
    @ApiOperation(value = "注销学生账号",httpMethod = "GET")
    @GetMapping("/deleteStudent")
    public String deleteStudent(int sid) {
        studentService.deleteStudent(sid);
        return "ok";
    }

    //学生登录
    @ApiOperation(value = "学生登录",httpMethod = "GET")
    @GetMapping("/studentLogin")
    public String studentLogin(int sid,String spassword){
        boolean b = studentService.studentIsExist(sid);
        if(b==true){
           if(studentService.confirmStudent(sid,spassword)==false)
               return "密码错误";
           return "ok";
        }
        return "账户不存在";
    }

}
