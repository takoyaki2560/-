package com.group5.demo.mapper;

import com.group5.demo.entity.Browse;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BrowseMapper {
    @Insert(" INSERT INTO wmsDb.browse ( "
            + "	    _id, uid, pid, browseTime"
            + " ) "
            + " VALUE ( "
            + "	   #{_id}, #{uid}, #{pid}, #{browseTime} "
            + " ) ")
    public Integer insert( Browse browse);

    @Select(" SELECT "
            + "	    _id, uid, pid, browseTime"
            + " FROM "
            + "	  wmsDb.browse "
            + " WHERE "
            + "	   _id = #{_id} ")
    public Browse findBrowseById(String _id);
}
