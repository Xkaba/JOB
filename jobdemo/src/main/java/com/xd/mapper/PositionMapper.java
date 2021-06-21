package com.xd.mapper;

import com.xd.pojo.AuditVi;
import com.xd.pojo.Position;
import com.xd.pojo.PositionVi;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PositionMapper {

    List<AuditVi> getPositionStu();

    List<PositionVi> getPositionList();

    List<PositionVi> getPositionByBid(int bid);

    int addPosition(Position position);

    int updatePosition(Position position);

    int deletePosition(int pid);

}
