/**
 * Project: dubbo.core.service.server-1.0.5-SNAPSHOT
 * 
 * File Created at 2009-12-27
 * $Id: StatusManager.java 181192 2012-06-21 05:05:47Z tony.chenl $
 * 
 * Copyright 2008 Alibaba.com Croporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Alibaba Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Alibaba.com.
 */
package com.alibaba.dubbo.registry.common;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.alibaba.dubbo.common.status.Status;
import com.alibaba.dubbo.common.status.Status.Level;
import com.alibaba.dubbo.common.status.StatusChecker;
import com.alibaba.dubbo.common.status.support.StatusUtils;

/**
 * StatusManager
 * 
 * @author william.liangf
 */
public class StatusManager {
    
    private static final StatusManager INSTANCE = new StatusManager();

    public static StatusManager getInstance() {
        return INSTANCE;
    }

    private StatusManager() {}
    
    private final Map<String, StatusChecker> statusHandlers = new ConcurrentHashMap<String, StatusChecker>();
    
    public void addStatusHandler(String name, StatusChecker statusHandler) {
        this.statusHandlers.put(name, statusHandler);
    }

    public void addStatusHandlers(Map<String, StatusChecker> statusHandlers) {
        this.statusHandlers.putAll(statusHandlers);
    }
    
    public void addStatusHandlers(Collection<StatusChecker> statusHandlers) {
        for (StatusChecker statusChecker : statusHandlers) {
            String name = statusChecker.getClass().getSimpleName();
            if (name.endsWith(StatusChecker.class.getSimpleName())) {
                name = name.substring(0, name.length() - StatusChecker.class.getSimpleName().length());
            }
            this.statusHandlers.put(name, statusChecker);
        }
    }

    public void removeStatusHandler(String name) {
        this.statusHandlers.remove(name);
    }

    public void clearStatusHandlers() {
        this.statusHandlers.clear();
    }
    
    public Map<String, Status> getStatusList() {
        return getStatusList(null);
    }
    
    /**
     * 过滤不需要汇总页面的监控项
     */
    public Map<String, Status> getStatusList(String[] excludes) {
        Map<String, Status> statuses = new HashMap<String, Status>();
        Map<String, StatusChecker> temp = new HashMap<String, StatusChecker>();
        temp.putAll(statusHandlers);
        if(excludes != null&&excludes.length>0){
            for(String exclude : excludes){
                temp.remove(exclude);
            }
        }
        for (Map.Entry<String, StatusChecker> entry : temp.entrySet()) {
                statuses.put(entry.getKey(), entry.getValue().check());
        }
        return statuses;
    }

    public static Status getStatusSummary(Map<String, Status> statusList) {
        return getSummaryStatus(statusList);
    }
    
    public static Status getSummaryStatus(Map<String, Status> statuses) {
        return StatusUtils.getSummaryStatus(statuses);
    }

}
