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
import org.junit.Assert;
import org.junit.Test;

/**
 * consulRegistryTest
 *
 * @author linux_china
 */
public class ConsulRegistryTest {

    String service = "com.alibaba.dubbo.test.injvmServie";
    //"consul://127.0.0.1:8500/com.alibaba.dubbo.registry.RegistryService?interface=com.alibaba.dubbo.registry.RegistryService"
    URL registryUrl = URL.valueOf("consul://localhost:8500");
    //"dubbo://192.168.11.1:20880/com.alibaba.dubbo.test.injvmServie?anyhost=true&application=dubbo-uic-provider&dubbo=3.0.0-SNAPSHOT&generic=false&interface=org.mvnsearch.uic.UicTemplate&methods=findById&pid=28893&realport=20880&side=provider&threads=200&timestamp=1479892263598"
    URL serviceUrl = URL.valueOf("dubbo://192.168.11.1:20880/" + service + "?notify=false&methods=test1,test2");
    // consumer://192.168.11.1/com.alibaba.dubbo.test.injvmServie?application=dubbo-uic-consumer&category=consumers&check=false&dubbo=3.0.0-SNAPSHOT&interface=org.mvnsearch.uic.UicTemplate&methods=findById&pid=29084&side=consumer&timeout=3000&timestamp=1479892383523
    URL consumerUrl = URL.valueOf("consumer://192.168.11.1/" + service + "?notify=false&methods=test1,test2");
    ConsulRegistry registry = new ConsulRegistry(registryUrl);

    @Test
    public void testIsAvailable() {
        Assert.assertTrue(registry.isAvailable());
    }

    /**
     * test register service
     */
    @Test
    public void testRegister() {
        registry.register(serviceUrl);
    }

    /**
     * test register service
     */
    @Test
    public void testDeregister() {
        registry.unregister(serviceUrl);
    }

    /**
     * Test method for
     * .
     */
    @Test
    public void testSubscribe() {
        /*final String subscribearg = "arg1=1&arg2=2";
        // verify lisener.
        final AtomicReference<Map<String, String>> args = new AtomicReference<Map<String, String>>();
        registry.subscribe(service, new URL("dubbo", NetUtils.getLocalHost(), 0, StringUtils.parseQueryString(subscribearg)), new NotifyListener() {

            public void notify(List<URL> urls) {
                // FIXME assertEquals(RedisRegistry.this.service, service);
                args.set(urls.get(0).getParameters());
            }
        });
        assertEquals(serviceUrl.toParameterString(), StringUtils.toQueryString(args.get()));
        Map<String, String> arg = registry.getSubscribed(service);
        assertEquals(subscribearg, StringUtils.toQueryString(arg));*/

    }

}