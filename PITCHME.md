---

#  Dubbo 3.0
##  雷卷


---

# Author Introduction

## 阿里巴巴Java软件工程师

* twitter: https://twitter.com/linux_china
* github: https://github.com/linux-china/

---

# Agenda

* Dubbo是什么？
* 为何开发3.0
* 3.0和2.0的特性对比
* 技术挑战
* FAQ

---

# Dubbo是什么
分布式的Java RPC框架

* 服务提供方和消费者: Provider, Consumer
* 网络通讯: Netty & NIO
* 序列化机制: hessian 2 protocol
* 负载均衡：Registry


---

# 为何开发3.0

* Dubbo 2年久失修
* 技术要升级: Spring Boot兼容等
* Metrics


---

# 3.0和2.0的特性对比


| Feature   | Dubbo 2.0              | Dubbo 3                  |
|:----------|:-----------------------|:-------------------------|
| Remoting  | Netty 3,Mina, Grizzy   | Netty 3,4                |
| Registry  | Simple,Redis,Zookeeper | Redis, ZooKeeper, Consul |
| Container | Jetty,Spring           | Spring Boot              |


---

# 技术挑战

* 基于Java 8重写
* 去除陈旧的技术和兼容集成
* Spring Boot完美集成



---

# FAQ {.big}

Any question???
