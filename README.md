Dubbo: 分布式通讯框架
======================================
Dubbo是一个高性能的分布式RPC框架，主要包括一下部分:

* Remoting(远程通信): a network communication framework provides sync-over-async and request-response messaging.
* Clustering(集群): a remote procedure call abstraction with load-balancing/failover/clustering capabilities.
* Registry(注册中心): a service directory framework for service registration and service event publish/subscription

文档地址: http://alibaba.github.io/dubbo-doc-static/Developer+Guide-zh.htm

### 和Dubbo 2.x的区别

* Java 8 only
* Spring Boot兼容
* 注册中心: 删除simple registry
* 通讯协议: 删除thrift，http，Grizzly，rmi等
* 容器: 取消Jetty支持，使用Spring Boot替换

### Quick Start

Please visit https://github.com/linux-china/spring-boot-dubbo for demo with Spring Boot integration.

### Development

Please execute build.sh to build project

### Todo

* 代码迁移到Java 8
* Consul注册中心
* javassist替换为byte-buddy
* 文档更新