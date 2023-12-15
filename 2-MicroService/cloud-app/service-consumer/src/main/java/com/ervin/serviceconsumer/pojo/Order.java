package com.ervin.serviceconsumer.pojo;

import com.ervin.feignapi.pojo.User;
import lombok.Data;

@Data
public class Order {
    private Long id;
    private String name;
    private String description;
    private Long userId;
    private User user;
}