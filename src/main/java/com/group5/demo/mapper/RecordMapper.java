package com.group5.demo.mapper;

import com.group5.demo.entity.Record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordMapper {
    @Insert(" INSERT INTO wmsDb.Record ( "
            + "	    pId, tId, salePrice, amount"
            + " ) "
            + " VALUE ( "
            + "	   #{pId}, #{tId}, #{salePrice}, #{amount} "
            + " ) ")
    public Integer insert( Record record);

    @Select(" SELECT "
            + "	    _id, uid, pid, browseTime"
            + " FROM "
            + "	  wmsDb.Record "
            + " WHERE "
            + "	   pId = #{pId} AND tId = #{tId} ")
    public Record findRecordByPidAndTid(String pId,String tId);

    @Select(" SELECT "
            + "*"
            + " FROM "
            + "	  wmsDb.Record ")
    public List<Record> findAllRecords();
}
