package com.xd.controller;

import com.xd.mapper.AuditMapper;
import com.xd.mapper.PositionMapper;
import com.xd.pojo.AuditVi;
import com.xd.pojo.Position;
import com.xd.pojo.PositionVi;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "职位")
@RestController
public class PositionController {
    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private AuditMapper auditMapper;

    @ApiOperation(value = "企业查看已发布职位",httpMethod = "GET")
    @GetMapping("/getPositionByBid")
    public List<PositionVi> getPositionByBid(int bid){
        List<PositionVi> positionList = positionMapper.getPositionByBid(bid);
        return positionList;
    }

    @ApiOperation(value = "管理员查看所有职位",httpMethod = "GET")
    @GetMapping("/getPositionList")
    public List<PositionVi> getPositionList(){
        List<PositionVi> positionList = positionMapper.getPositionList();
        return positionList;
    }

    @ApiOperation(value = "学生查看所有职位",httpMethod = "GET")
    @GetMapping("/getPositionStu")
    public List<AuditVi> getPositionStu(int sid){
        List<AuditVi> positionStu = positionMapper.getPositionStu();
        List<AuditVi> auditBySid = auditMapper.getAuditBySid(sid);
        for (AuditVi auditVi:positionStu) {
            for(AuditVi auditVi1:auditBySid){
                if(auditVi1.getPid()==auditVi.getPid()){
                    auditVi.setStatus(auditVi1.getStatus());
                }
            }
        }
        return positionStu;
    }

    @ApiOperation(value = "发布职位",httpMethod = "GET")
    @GetMapping("/addPosition")
    public String addPosition(Position position){
        positionMapper.addPosition(position);
        return "ok";
    }

    @ApiOperation(value = "修改职位信息",httpMethod = "GET")
    @GetMapping("/updatePosition")
    public String updatePosition(Position position){
        positionMapper.updatePosition(position);
        return "ok";
    }

    @ApiOperation(value = "删除职位",httpMethod = "GET")
    @GetMapping("/deletePosition")
    public String deletePositon(int pid){
        positionMapper.deletePosition(pid);
        return "ok";
    }

}
