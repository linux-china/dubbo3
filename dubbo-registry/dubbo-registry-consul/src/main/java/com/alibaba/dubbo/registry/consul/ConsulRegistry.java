/*
 * Copyright 1999-2012 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.registry.consul;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.NamedThreadFactory;
import com.alibaba.dubbo.registry.NotifyListener;
import com.alibaba.dubbo.registry.support.FailbackRegistry;

import java.util.concurrent.*;

/**
 * consul registry
 *
 * @author linux_china
 */
public class ConsulRegistry extends FailbackRegistry {

    private static final Logger logger = LoggerFactory.getLogger(ConsulRegistry.class);

    private static final int DEFAULT_CONSUL_PORT = 8500;

    private final static String DEFAULT_ROOT = "dubbo";

    private final ScheduledExecutorService expireExecutor = Executors.newScheduledThreadPool(1, new NamedThreadFactory("DubboRegistryExpireTimer", true));

    private ScheduledFuture<?> expireFuture;

    private String root;

    private int reconnectPeriod;

    private int expirePeriod;

    private volatile boolean admin = false;

    private boolean replicate;

    public ConsulRegistry(URL url) {
        super(url);
        if (url.isAnyHost()) {
            throw new IllegalStateException("registry address == null");
        }
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    protected void doRegister(URL url) {

    }

    @Override
    protected void doUnregister(URL url) {

    }

    @Override
    protected void doSubscribe(URL url, NotifyListener listener) {

    }

    @Override
    protected void doUnsubscribe(URL url, NotifyListener listener) {

    }
}
