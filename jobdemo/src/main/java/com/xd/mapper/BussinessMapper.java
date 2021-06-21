package com.xd.mapper;

import com.xd.pojo.Bussiness;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BussinessMapper {

    List<Bussiness> getBussinessList();

    Bussiness getBussinessById(int bid);

    int addBussiness(Bussiness bussiness);

    int updateBussiness(Bussiness bussiness);

    int deleteBussiness(int bid);

}
