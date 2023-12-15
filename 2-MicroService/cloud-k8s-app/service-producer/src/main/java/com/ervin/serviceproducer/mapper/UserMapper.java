package com.ervin.serviceproducer.mapper;

import com.ervin.serviceproducer.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    
    @Select("select * from clouduser where id = #{id}")
    User findById(@Param("id") Long id);
}