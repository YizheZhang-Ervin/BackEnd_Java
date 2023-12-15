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

- (OK) admin-service: 8903
  - Actuator应用监控中心
```

## 2.注册中心&配置中心
```
# 注册中心
- (OK) Kubernetes CoreDNS
  - K8S Discovery

# 配置中心
- (OK) config-service: 9001
  - K8S Config
```

## 3.服务调用&负载均衡&微服务保护
```
# 服务调用&负载均衡
- (OK) feign-api
  - 集成K8S Ribbon & K8S LoadBalancer

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
```

## 5.链路追踪
```
- (X) Sleuth+Zipkin
  - 要集成zipkin-server: 9004
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

---

# 三、SpringCloudK8S相关依赖
- 注册中心
  - k8s-discovery 
  - fabric8-discovery
- 配置中心
  - k8s-config/k8s-archaius
  - fabric8-config
- 微服务保护
  - k8s-hystrix
- 负载均衡/服务调用
  - k8s-ribbon/k8s-loadbalancer
  - fabric8-loadbalancer
- 链路追踪
  - k8s-zipkin
- 其他
  - k8s-leader/k8s-istio
  - fabric8-leader/fabric8-istio
