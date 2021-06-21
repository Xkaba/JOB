package com.xd.controller;

import com.xd.mapper.BussinessMapper;
import com.xd.pojo.Bussiness;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "企业")
@RestController
public class BussinessController {
    @Autowired
    private BussinessMapper bussinessMapper;

    @ApiOperation(value = "查看所有企业信息", httpMethod = "GET")
    @GetMapping("/getBussinessList")
    public List<Bussiness> getBussinessList() {
        List<Bussiness> bussinessList = bussinessMapper.getBussinessList();
        for (Bussiness bussiness : bussinessList) {
            System.out.println(bussiness);
        }
        return bussinessList;
    }

    @ApiOperation(value = "企业查看企业信息",httpMethod = "GET")
    @GetMapping("/getBussinessById")
    public Bussiness getBussinessById(int bid) {
        Bussiness bussiness = bussinessMapper.getBussinessById(bid);
        return bussiness;
    }

    @ApiOperation(value = "企业注册",httpMethod = "GET")
    @GetMapping("/addBussiness")
    public String addBussiness(Bussiness bussiness){
        bussinessMapper.addBussiness(bussiness);
        return "ok";
    }

    @ApiOperation(value = "更新企业信息",httpMethod = "GET")
    @GetMapping("/updateBussiness")
    public String updateBussiness(Bussiness bussiness) {
        bussinessMapper.updateBussiness(bussiness);
        return "ok";
    }

    @ApiOperation(value = "注销企业账号",httpMethod = "GET")
    @GetMapping("/deleteBussiness")
    public String deleteBussiness(int bid) {
        bussinessMapper.deleteBussiness(bid);
        return "ok";
    }

    @ApiOperation(value = "企业登录",httpMethod = "GET")
    @GetMapping("/bussinessLogin")
    public String bussinessLogin(int bid,String password){
        Bussiness bussiness1 = bussinessMapper.getBussinessById(bid);
        if(bussiness1!=null){
            List<Bussiness> bussinessList = bussinessMapper.getBussinessList();
            for (Bussiness bussiness:bussinessList) {
                if(bussiness.getBid()==bid && bussiness.getPassword().equals(password)) {
                    return "ok";
                }
            }
            return "密码错误";
        }
        return "账户不存在";
    }

}
