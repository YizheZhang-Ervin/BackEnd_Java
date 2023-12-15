package com.ervin.serviceconsumer.service;

import com.ervin.feignapi.clients.UserClient;
import com.ervin.feignapi.pojo.User;
import com.ervin.feignapi.clients.ProducerFeignClientCallBack;
import com.ervin.serviceconsumer.mapper.OrderMapper;
import com.ervin.serviceconsumer.pojo.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderMapper orderMapper;

    @Qualifier("com.ervin.feignapi.clients.UserClient")
    @Autowired
     private UserClient userClient;

//    @Autowired
//    private ProducerFeignClientCallBack producerFeignClientCallBack;

    public Order queryOrderById(Long orderId) throws Exception {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.用Feign远程调用
        User user = userClient.findById(order.getUserId());

        // 触发降级
//        if(orderId != 1) {
//			int i = 1/0;
//			throw new Exception("太忙了");
//		}
//        User user = producerFeignClientCallBack.findById(order.getUserId());
        // 3.封装user到Order
        order.setUser(user);
        // 4.返回
        return order;
    }

    /*
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
	private DiscoveryClient discoveryClient;

    public Order queryOrderById(Long orderId) {
		
		List<ServiceInstance> instances = discoveryClient.getInstances("service-producer");
		ServiceInstance instance = instances.get(0);
       
        Order order = orderMapper.findById(orderId);

        String url = "http://service-producer/user/"+order.getUserId();
        // 或 String url = "http://"+instance.getHost()+":"+instance.getPort()+"/user/"+order.getUserId();
        
        User user = restTemplate.getForObject(url, User.class);
        order.setUser(user);
        return order;
    }*/
}
