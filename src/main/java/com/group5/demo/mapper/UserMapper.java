package com.group5.demo.mapper;

import com.group5.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Insert(" INSERT INTO wmsDb.users ( "
            + "	   _id, name, password, role, Address, phone, email "
            + " ) "
            + " VALUE ( "
            + "	   #{_id}, #{name}, #{password}, #{role}, #{Address}, #{phone}, #{email}"
            + " ) ")
    public Integer insert(User user);

    @Select(" SELECT "
            + "	   _id, name, password, role, Address, phone, email "
            + " FROM "
            + "	  wmsDb.users "
            + " WHERE "
            + "	   name = #{username} ")
    public User findUerByName(String username);

    @Update(" UPDATE "
            + "	   wmsDb.users "
            + " SET "
            + "	   password = #{password},"
            + " WHERE "
            + "	   _id = #{_id} ")
    public Integer update(User user);

    @Select(" SELECT "
            + "*"
            + " FROM "
            + "	  wmsDb.users ")
    public List<User> findAllUsers();

    @Select("select users.name " +
            "from users " +
            "where _id = #{id}")
    public String findById(String id);
}
