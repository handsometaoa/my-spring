package org.springframework.beans.factory.config;

public interface SingletonBeanRegistry {

    /**
     * 获取单例对象的接口
     * @param beanName 单例beanName
     * @return 单例对象实例
     */
    Object getSingleton(String beanName);
}
