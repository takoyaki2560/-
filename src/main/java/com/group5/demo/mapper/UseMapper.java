package com.group5.demo.mapper;

import com.group5.demo.entity.Use;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UseMapper {
    @Insert(" INSERT INTO wmsDb.Use ( "
            + "	    INo, pId, amount"
            + " ) "
            + " VALUE ( "
            + "	   #{INo}, #{pId}, #{amount}"
            + " ) ")
    public Integer insert( Use use);

    @Select(" SELECT "
            + "	   INo, pId, amount"
            + " FROM "
            + "	  wmsDb.Use "
            + " WHERE "
            + "	   INo = #{INo} AND pId = #{pId} ")
    public Use findUseById(String INo,String pId);

    @Select(" SELECT "
            + "*"
            + " FROM "
            + "	  wmsDb.Use ")
    public List<Use> findAllUses();
}
