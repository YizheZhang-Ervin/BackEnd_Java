package com.ervin.serviceconsumer.controller;

import com.ervin.feignapi.pojo.User;
import com.ervin.serviceconsumer.pojo.Order;
import com.ervin.serviceconsumer.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("cmd/{orderId}")
    @HystrixCommand(fallbackMethod = "orderFallBack")
    public Order queryOrderByUserId2(@PathVariable("orderId") Long orderId) throws Exception {
        // 根据id查询订单并返回
        if(orderId != 1) {
            throw  new  RuntimeException("服务器异常");
        }
        return orderService.queryOrderById(orderId);
    }

    @GetMapping("/{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) throws Exception {
        // 根据id查询订单并返回
        return orderService.queryOrderById(orderId);
    }

    /**
     * 降级方法
     *  和需要收到保护的方法的返回值一致
     *  方法参数一致
     */
    public Order orderFallBack(Long id) {
        Order order = new Order();
        User user = new User();
        user.setUsername("触发降级方法");
        order.setUser(user);
        return order;
    }
}
