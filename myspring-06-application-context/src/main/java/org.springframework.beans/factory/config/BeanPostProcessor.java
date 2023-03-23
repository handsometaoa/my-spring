package org.springframework.beans.factory.config;

import org.springframework.beans.BeansException;

public interface BeanPostProcessor {

    /**
     * bean 初始化之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessorBeforeInitialization(Object bean, String beanName) throws BeansException;


    /**
     * bean 初始化之前，执行此方法
 * @param bean~
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessorAfterInitialization(Object bean, String beanName) throws BeansException;


}
