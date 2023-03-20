package org.springframework.beans.factory.support;

import org.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wang
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjectsMap = new HashMap<>();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjectsMap.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjectsMap.put(beanName, singletonObject);
    }

}
