package com.group5.demo.mapper;

import com.group5.demo.entity.Material;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MaterialMapper {
    @Insert(" INSERT INTO wmsDb.material ( "
            + "	    mId, mType, mName, mNum"
            + " ) "
            + " VALUE ( "
            + "	   #{mId}, #{mType}, #{mName}, #{mNum}"
            + " ) ")
    public Integer insert( Material material);

    @Select(" SELECT "
            + "	   mId, mType, mName, mNum"
            + " FROM "
            + "	  wmsDb.material "
            + " WHERE "
            + "	   mName = #{mName} ")
    public Material findMaterialByName(String mName);

    @Select(" SELECT "
            + "*"
            + " FROM "
            + "	  wmsDb.material ")
    public List<Material> findAllMaterials();
}
