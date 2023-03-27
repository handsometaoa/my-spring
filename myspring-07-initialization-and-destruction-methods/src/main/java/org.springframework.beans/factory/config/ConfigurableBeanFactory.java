package org.springframework.beans.factory.config;

import org.springframework.beans.factory.HierarchicalBeanFactory;


/**
 * 同时继承了分层和单例类注册的功能
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory,SingletonBeanRegistry {

    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";


    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
