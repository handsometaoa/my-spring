package org.springframework.beans.factory;

import org.springframework.beans.factory.config.BeanDefinition;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tao
 */

public class BeanFactory {

    private final Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();


    /**
     * 注册BeanDefinition-Bean定义信息
     *
     * @param name           Bean实例名称
     * @param beanDefinition Bean定义信息
     */
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

    /**
     * 根据名称或取Bean实例
     *
     * @param name Bean实例名称
     * @return Bean实例
     */
    public Object getBean(String name) {
        return beanDefinitionMap.get(name).getBean();
    }


}
