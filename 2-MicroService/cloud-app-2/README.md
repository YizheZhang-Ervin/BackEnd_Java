# cloud-app-2

# 一、微服务
## 1.生产者&消费者
```
- (OK) producer-service: 8901
  - /echo/{string}
  
- (OK) consumer-service: 8902
  - 技术
    - sentinel
    - ribbon
    - restTemplate
  - API
    - /main/{id}

- (OK) config-service: 8903
```

## 2.注册中心&配置中心
```
- (OK) nacos: 8848
  - 使用  
    - UsageManual/Nacos使用.md
  - 功能
    - 获取某个配置
      - /config/get
```

## 3.服务调用&负载均衡&微服务保护
```
# 服务调用&负载均衡
- (OK) restTemplate

# 微服务保护
- (OK) Sentinel: 9001
  - 使用  
    - UsageManual/Sentinel使用.md
  - 技术  
    - 配合Ribbon
    - 配合RestTemplate
```

## 4.网关
```
- (OK) gateway: 9002
  - 技术  
    - 已集成Sentinel
  - API
    - /echo/{string}
    - /main/{id}
```

## 5.链路追踪
```
- (OK) Skywalking: 9003
  - 功能
    - UsageManual/Skywalking使用.md
```