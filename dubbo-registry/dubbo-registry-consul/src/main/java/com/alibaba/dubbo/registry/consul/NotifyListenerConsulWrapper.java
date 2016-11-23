package com.alibaba.dubbo.registry.consul;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.NotifyListener;
import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.health.model.HealthService;

import java.util.ArrayList;
import java.util.List;

/**
 * consul wrapper for notify listener
 *
 * @author linux_china
 */
public class NotifyListenerConsulWrapper {

    private NotifyListener notifyListener;
    private ConsulClient consulClient;
    private String serviceInterface;
    private List<URL> providerUrls;

    public NotifyListenerConsulWrapper(NotifyListener notifyListener, ConsulClient consulClient, String serviceInterface) {
        this.notifyListener = notifyListener;
        this.consulClient = consulClient;
        this.serviceInterface = serviceInterface;
    }

    public void sync() {
        List<URL> tempUrls = getProviderUrls(serviceInterface);
        if (providerUrls == null) {
            providerUrls = tempUrls;
            notifyListener.notify(providerUrls);
            return;
        }
        boolean changed = false;
        for (URL tempUrl : tempUrls) {
            if (!this.providerUrls.contains(tempUrl)) {
                changed = true;
                break;
            }
        }
        if (changed) {
            this.providerUrls = tempUrls;
            notifyListener.notify(this.providerUrls);
        }
    }

    public List<URL> getProviderUrls(String serviceName) {
        List<URL> urls = new ArrayList<>();
        Response<List<HealthService>> healthServices = consulClient.getHealthServices(serviceName, true, null);
        for (HealthService healthService : healthServices.getValue()) {
            urls.add(URL.valueOf(healthService.getService().getAddress()));
        }
        return urls;
    }
}
