package org.springframework.beans.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.Cat;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("cat".equals(beanName)) {
            Cat cat = (Cat) bean;
            cat.setName("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
