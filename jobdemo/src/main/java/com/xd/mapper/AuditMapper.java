package com.xd.mapper;

import com.xd.pojo.Audit;
import com.xd.pojo.AuditBu;
import com.xd.pojo.AuditVi;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AuditMapper {


    List<AuditVi> getAuditBySid(int sid);

    List<AuditBu> getAuditByBid(int bid);

    int addAudit(Audit audit);

    int deleteAudit(Audit audit);

    int updateStatusBussiness(Audit audit);

    Audit getAuditByAid(Audit audit);



}
