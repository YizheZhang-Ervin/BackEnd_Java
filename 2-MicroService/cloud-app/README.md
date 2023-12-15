# cloud-app

# 一、微服务
## 1.生产者&消费者
```
- (OK) service-producer: 8901
  - API
    - /user/{id}
    - /user/prop
    - /user/now
    - /user/config
    - /actuator
  - 技术
    - 有sleuth+zipkin

- (OK) service-consumer: 8902
  - API
    - /order/{orderId}
    - /actuator
    - /actuator/hystrix.stream
  - 技术
    - 有feign
    - 有sleuth+zipkin
```

## 2.注册中心&配置中心
```
# 注册中心
- (OK) eureka-server: 9000
- (X) consul-server: 9000
  - 要配合consul


# 配置中心
- (X) config-server: 9001
  - 要集成rabbitmq: 5672
```

## 3.服务调用&负载均衡&微服务保护
```
# 服务调用&负载均衡
- (OK) feign-api
  - 技术
    - 已集成Ribbon
- (X) restTemplate

# 微服务保护
- (OK) hystrix-turbine: 9003
  - 接入地址
    - http://localhost:8901/actuator/hystrix.stream
  - API
    - /hystrix
```

## 4.网关
```
- (OK) gateway: 9002
  - 技术
   - 已集成Sentinel
  
- (OK) zuul: 9002
  - 技术
    - 已集成Hystrix
    - 已集成Ribbon
```

## 5.链路追踪
```
- (X) Sleuth+Zipkin
  - 要配合zipkin-server: 9004
```

---

# 二、中间件
## 1.Database: test
- Table: clouduser
  - id
  - username
  - info

- Table: cloudorder
  - id
  - name
  - description
  - userId
