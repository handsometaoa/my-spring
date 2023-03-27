package org.springframework.beans.context.support;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{
    @Override
    void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader=new XmlBeanDefinitionReader(beanFactory,this);
        String[] configLocations=getConfigLocations();
        if (null!=configLocations){
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    abstract String[] getConfigLocations();
}
