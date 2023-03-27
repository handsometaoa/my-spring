package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.core.io.Resource;
import org.springframework.beans.core.io.ResourceLoader;

/**
 * 读取 Spring 配置文件中的内容，将其转换为 IoC 容器内部的数据结构：BeanDefinition
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();


    /**
     * 加载BeanDefinition
     */
    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;


}
