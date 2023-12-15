# k8s-app

# 一、微服务
## 1.服务
```
- portal: 8000
  - API
    - 本地调用/test
    - 远程调用/test/api-service
  - 技术
    - restTemplate
- api-service: 8001
  - API
    - 本地调用/test
```

## 2.网关
```
- K8S Ingress Gateway: 80
```

## 3.注册中心&微服务保护&负载均衡
```
- Istio Pilot/Envoy
```
