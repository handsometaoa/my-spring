package org.springframework.beans.factory;


import org.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    /**
     * 重载一个含有入参的getBean 方法
     */
    Object getBean(String name, Object... args) throws BeansException;


    /**
     * 根据类型获取 bean
     */
    <T> T getBean(String name,Class<T> requiredType);



}
