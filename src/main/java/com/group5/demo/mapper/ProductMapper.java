package com.group5.demo.mapper;

import com.group5.demo.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert(" INSERT INTO wmsDb.product ( "
            + "	    pid, category, pName, package , saleCount , price "
            + " ) "
            + " VALUE ( "
            + "	   #{pid}, #{category}, #{pName}, #{pPackage}, #{saleCount} , #{price} "
            + " ) ")
    public Integer insert( Product product);

    @Select(" SELECT "
            + "	   pid, category, pName, package as pPackage, saleCount , price"
            + " FROM "
            + "	  wmsDb.product "
            + " WHERE "
            + "	   pName = #{pName} ")
    public Product findProductByName(String pName);

    @Select(" SELECT "
            + "pid, category, pName, package as pPackage, saleCount , price"
            + " FROM "
            + "	  wmsDb.product ")
    public List<Product> findAllProducts();

    @Select("select * from product where pid = #{id}")
    public Product findById(String id);
}
