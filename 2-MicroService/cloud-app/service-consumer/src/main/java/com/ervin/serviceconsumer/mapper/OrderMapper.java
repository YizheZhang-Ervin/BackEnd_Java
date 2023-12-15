package com.ervin.serviceconsumer.mapper;

import com.ervin.serviceconsumer.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface OrderMapper {

    @Select({"select * from cloudorder where id = #{id}"})
    Order findById(Long id);
}
