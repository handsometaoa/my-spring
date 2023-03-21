package org.springframework.beans.factory.support;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor constructor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        Object result = null;

        try {
            if (null != constructor) {
                result = clazz.getDeclaredConstructor(constructor.getParameterTypes()).newInstance(args);
            } else {
                result = clazz.getDeclaredConstructor().newInstance();
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            new BeansException("Failed to instantiate [" + clazz.getName() + "]", e);
        }
        return result;

    }
}
