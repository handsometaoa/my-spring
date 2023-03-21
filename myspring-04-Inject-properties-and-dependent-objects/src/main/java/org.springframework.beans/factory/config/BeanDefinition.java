package org.springframework.beans.factory.config;

import org.springframework.beans.PropertyValues;

public class BeanDefinition {
    private Class beanClass;

    PropertyValues propertyValues;

    public BeanDefinition() {
    }

    public BeanDefinition(Class beanClass) {
        this(beanClass, new PropertyValues());
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
