package com.group5.demo.mapper;

import com.group5.demo.entity.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TransactionMapper {
    @Insert(" INSERT INTO wmsDb.browse ( "
            + "	    tId, mId, transTime"
            + " ) "
            + " VALUE ( "
            + "	   #{tId}, #{mId}, #{transTime}"
            + " ) ")
    public Integer insert( Transaction transaction);

    @Select(" SELECT "
            + "	   tId, mId, transTime"
            + " FROM "
            + "	  wmsDb.Record "
            + " WHERE "
            + "	   tId = #{tID} ")
    public Transaction findTransactionById(String tID);
}
