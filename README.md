Dubbo: 分布式通讯框架
======================================
Dubbo is a distributed service framework enpowers applications with service import/export capability with high performance RPC.
It's composed of three kernel parts:

* Remoting: a network communication framework provides sync-over-async and request-response messaging.
* Clustering: a remote procedure call abstraction with load-balancing/failover/clustering capabilities.
* Registry: a service directory framework for service registration and service event publish/subscription

For more, please refer to:

    http://code.alibabatech.com/wiki/display/dubbo


文档地址: http://alibaba.github.io/dubbo-doc-static/Developer+Guide-zh.htm

### Quick Start

Export remote service:

    <bean id="barService" class="com.foo.BarServiceImpl" />
	
    <dubbo:service interface="com.foo.BarService" ref="barService" />

Refer remote service:

    <dubbo:reference id="barService" interface="com.foo.BarService" />
	
    <bean id="barAction" class="com.foo.BarAction">
        <property name="barService" ref="barService" />
    </bean>

### Environment setup

* Please install Docker and Docker Compose first, then execute:


     docker-compose up -d

### Source Building

* Checkout the dubbo source code:

        cd ~
        git clone https://github.com/alibaba/dubbo.git dubbo

* Build the dubbo binary package:

        cd ~/dubbo
        ./build.sh

* Install the demo provider:

        cd ~/dubbo/dubbo-demo-provider/target
        tar zxvf dubbo-demo-provider-2.4.0-assembly.tar.gz
        cd dubbo-demo-provider-2.4.0/bin
        ./start.sh

* Install the demo consumer:

        cd ~/dubbo/dubbo-demo-consumer/target
        tar zxvf dubbo-demo-consumer-2.4.0-assembly.tar.gz
        cd dubbo-demo-consumer-2.4.0/bin
        ./start.sh
        cd ../logs
        tail -f stdout.log

* Install the simple monitor:

        cd ~/dubbo/dubbo-simple-monitor/target
        tar zxvf dubbo-simple-monitor-2.4.0-assembly.tar.gz
        cd dubbo-simple-monitor-2.4.0/bin
        ./start.sh
        http://127.0.0.1:8080

*  Install the admin console:

        cd ~/dubbo/dubbo-admin
        mvn jetty:run -Ddubbo.registry.address=zookeeper://127.0.0.1:2181
        http://root:root@127.0.0.1:8080

