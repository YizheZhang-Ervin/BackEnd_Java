package com.ervin.feignapi.clients;

import com.ervin.feignapi.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class ProducerFeignClientCallBack implements UserClient {

	/**
	 * 熔断降级的方法
	 */
	public User findById(Long id) {
		User user = new User();
		user.setUsername("feign调用触发熔断降级方法");
		return user;
	}
}
