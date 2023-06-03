package com.group5.demo.mapper;

import com.group5.demo.entity.Transaction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TransactionMapper {
    @Insert(" INSERT INTO wmsDb.Transaction ( "
            + "	    tId, mId, transTime"
            + " ) "
            + " VALUE ( "
            + "	   #{tId}, #{mId}, #{transTime}"
            + " ) ")
    public Integer insert( Transaction transaction);

    @Select(" SELECT "
            + "	   tId, mId, transTime"
            + " FROM "
            + "	  wmsDb.Transaction "
            + " WHERE "
            + "	   tId = #{tID} ")
    public Transaction findTransactionById(String tID);

    @Select(" SELECT "
            + "*"
            + " FROM "
            + "	  wmsDb.Transaction ")
    public List<Transaction> findAllTransactions();
}
