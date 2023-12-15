package com.ervin.consumer;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import com.ervin.consumer.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerServiceApplication {
    /**
     * sentinel支持对restTemplate的服务调用使用sentinel方法.在构造
     *  RestTemplate对象的时候,只需要加载@SentinelRestTemplate即可
     *
     *  资源名:
     *       httpmethod:schema://host:port/path ：协议、主机、端口和路径
     *       httpmethod:schema://host:port ：协议、主机和端口
     *
     *  @SentinelRestTemplate:
     *    异常降级
     *      fallback      : 降级方法
     *      fallbackClass : 降级配置类
     *    限流熔断
     *      blockHandler
     *      blockHandlerClass
     */
    @LoadBalanced
    @Bean
    @SentinelRestTemplate(fallbackClass = ExceptionUtils.class,fallback = "handleFallback",
            blockHandler = "handleBlock" ,blockHandlerClass = ExceptionUtils.class
    )
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceApplication.class, args);
    }

    @RestController
    public class TestController {

        private final RestTemplate restTemplate;

        @Autowired
        public TestController(RestTemplate restTemplate) {this.restTemplate = restTemplate;}

        @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
        public String echo(@PathVariable String str) {
            return restTemplate.getForObject("http://producer-service/echo/" + str, String.class);
        }
    }
}
