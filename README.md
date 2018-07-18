Dubbo: 分布式通讯框架
======================================
Dubbo是一个高性能的分布式RPC框架，主要包括一下部分:

* Remoting(远程通信): a network communication framework provides sync-over-async and request-response messaging.
* Clustering(集群): a remote procedure call abstraction with load-balancing/failover/clustering capabilities.
* Registry(注册中心): a service directory framework for service registration and service event publish/subscription

文档地址: http://alibaba.github.io/dubbo-doc-static/Developer+Guide-zh.htm

### 和Dubbo 2.x的区别

* Java 8 only, hessian序列化支持Java 8 Optional，暂时不支持容器类，如List, Map
* 序列化调整到hessian2协议上
* zookeeper有zkClient调整到curator
* Spring Boot兼容
* 注册中心: 删除simple registry
* 通讯协议: 默认Netty4， 删除thrift，http，Grizzly，rmi等协议支持
* 容器: 取消Jetty支持，使用Spring Boot替换
* Docker: 在 Protocol 配置中增加了 exportHost 和 exportPort 参数, 区分容器内绑定的真实地址和注册到注册中心的宿主机地址

请参考presentation： https://gitpitch.com/linux-china/dubbo3


### Dubbo Spring Boot
不少同学会对Dubbo更多的需求，这当然是对，但是有一些特性可能做在Dubbo和某些框架的集成上更好，如Dubbo Spring Boot，这里列举一下特性：

* Metrics集成，这个在Dubbo Spring Boot中通过filter机制完成更方便
* DevOps API: 各种信息暴露

相信的请访问： https://github.com/linux-china/spring-boot-dubbo

### Quick Start

Please visit https://github.com/linux-china/spring-boot-dubbo for demo with Spring Boot integration.

### Development

Please execute build.sh to build project

### Todo

* 代码迁移到Java 8
* JSR 308 and Java Optional
* Consul注册中心，添加health checker，通过环境变量或者system properties
* 多数据中心
* javassist替换为byte-buddy
* Lombok？？？: 精简代码 https://projectlombok.org/index.html
* 文档更新
* Reactive支持: Reactor & RxJava