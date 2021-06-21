package com.xd.controller;

import com.xd.mapper.AuditMapper;
import com.xd.pojo.Audit;
import com.xd.pojo.AuditBu;
import com.xd.pojo.AuditVi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "职位申请")
@RestController
public class AuditController {
    @Autowired
    private AuditMapper auditMapper;

    @ApiOperation(value = "企业查看所有职位申请",httpMethod = "GET")
    @GetMapping("/getAuditByBid")
    public List<AuditBu> getAuditByBid(int bid){
        List<AuditBu> auditByBid = auditMapper.getAuditByBid(bid);
        return auditByBid;
    }


    @ApiOperation(value = "学生根据学生账号查询职位申请",httpMethod = "GET")
    @GetMapping("/getAuditBySid")
    public List<AuditVi> getAuditBySid(int sid){
        List<AuditVi> auditList = auditMapper.getAuditBySid(sid);
        return auditList;
    }

    @ApiOperation(value = "申请职位",httpMethod = "GET")
    @GetMapping("/addAudit")
    public String addAudit(Audit audit){
        auditMapper.addAudit(audit);
        return "ok";
    }

    @ApiOperation(value = "取消职位申请",httpMethod = "GET")
    @GetMapping("deleteAudit")
    public String deleteAudit(Audit audit){
        auditMapper.deleteAudit(audit);
        return "ok";
    }

    @ApiOperation(value = "企业更新职位申请状态",httpMethod = "GET")
    @GetMapping("updateStatusBussiness")
    public String updateStatusBussiness(Audit audit){
        Audit auditByAid = auditMapper.getAuditByAid(audit);
        auditMapper.updateStatusBussiness(auditByAid);
        return "ok";
    }

}
