package org.springframework.beans.factory.support;


import org.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registryBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
