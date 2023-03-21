package org.springframework.beans.factory;


import org.junit.jupiter.api.Assertions;
import org.springframework.beans.Cat;
import org.springframework.beans.Person;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;


class BeanFactoryTest {

    @Test
    void getBean() {

        DefaultListableBeanFactory beanFactory=new DefaultListableBeanFactory();
        BeanDefinition beanDefinition1 = new BeanDefinition(Cat.class);
        beanFactory.registryBeanDefinition("cat",beanDefinition1);
        Cat cat = (Cat) beanFactory.getBean("cat");


        PropertyValue propertyValue1 = new PropertyValue("name","zhangsan");
        PropertyValue propertyValue2 =new PropertyValue("age",26);
        PropertyValue propertyValue3 =new PropertyValue("cat",new BeanReference("cat"));
        PropertyValues propertyValues=new PropertyValues();
        propertyValues.addPropertyValue(propertyValue1);
        propertyValues.addPropertyValue(propertyValue2);
        propertyValues.addPropertyValue(propertyValue3);
        BeanDefinition beanDefinition2 = new BeanDefinition(Person.class,propertyValues);
        Person person = (Person) beanFactory.createBean("person", beanDefinition2,new Object[]{});


        Assertions.assertEquals(cat.getName(),person.getCat().getName());



    }

}