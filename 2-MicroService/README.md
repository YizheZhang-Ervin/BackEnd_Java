# DevOps_MicroServicesV2

# 一、概述
## 1.技术对比
- Spring Cloud
  - 注册中心: Eureka/Nacos/Consul/Zookeeper
  - 配置中心: Config+Bus/Nacos/Consul/Apollo/Disconf/Zookeeper
  - 网关: Zuul/Gateway
  - 微服务保护: Hystrix+Turbine/Sentinel
  - 负载均衡/服务调用: RestTemplate/Feign+Ribbon/LoadBalancer

- K8S & Istio
  - 注册中心: Istio Pilot/Envoy+K8S CoreDNS
  - 配置中心: K8S Configmap/Secret
  - 网关: K8S Ingress
  - 微服务保护: Istio Pilot/Envoy
  - 负载均衡/服务调用: Istio Pilot/Envoy
  - 监控/追踪/日志API: Istio Mixer/Adapter
  - 安全: Istio citadel

- 通用组件
  - 链路追踪: Sleuth+Zipkin/Skywalking/Jaeger/Pinpoint
  - 监控: Spectator+Atlas+Servo/Prometheus+Grafana
  - 日志: ELK/EFK
  - 数据库: Mysql+Seata+Canal
  - 缓存: Redis
  - 消息队列: Stream+Kafka
  - 协调服务: Zookeeper
  - 代理: Nginx/Haproxy

## 2.架构
| 方案 | 注册中心 + 配置中心 + 网关 + 微服务保护 + 负载均衡 + 服务调用 + 链路追踪 |
| ------ | ------ |
| 1) Cloud | Eureka + Config + Zuul + Hystrix + Ribbon + Feign + Sleuth&Zipkin |
| 2) Cloud | Nacos + Nacos + Gateway + Sentinel + Ribbon + RestTemplate + Skywalking |
| 3) Cloud K8S | K8S-Discovery + K8S-Config + Gateway + K8S-Hystrix + K8S-Ribbon&K8S-LoadBalancer + Feign + Sleuth&K8S-Zipkin |
| 4) Istio K8S | Pilot/Envoy + Configmap&Secret + Ingress + Pilot/Envoy + Pilot/Envoy + Pilot/Envoy + Jaeger |

# 二、项目结构
## 1.cloud-app
- 基于Spring Cloud的微服务框架
  - Eureka/Consul
  - Config
  - Gateway/Zuul
  - Hystrix
  - Ribbon
  - Feign
  - Sleuth&Zipkin

## 2.cloud-app-2
- 基于Spring Cloud的微服务框架
  - Nacos
  - Gateway
  - Sentinel
  - Ribbon
  - RestTemplate
  - Skywalking

## 3.cloud-k8s-app
- 基于Spring Cloud 和 K8S的微服务框架
  - K8S-Discovery
  - K8S-Config
  - Gateway
  - Hystrix
  - Ribbon
  - Feign
  - Sleuth&Zipkin

## 4.k8s-app
- 基于Istio 和 K8S的微服务框架
  - Istio Pilot/Envoy
  - K8S Ingress Gateway
  - RestTemplate
