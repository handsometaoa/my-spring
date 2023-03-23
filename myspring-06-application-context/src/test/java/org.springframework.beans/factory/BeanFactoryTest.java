package org.springframework.beans.factory;


import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.Cat;
import org.springframework.beans.Person;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.core.io.DefaultResourceLoader;
import org.springframework.beans.core.io.Resource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.io.IOException;
import java.io.InputStream;


class BeanFactoryTest {

    @Test
    void getBean() {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition1 = new BeanDefinition(Cat.class);
        beanFactory.registerBeanDefinition("cat", beanDefinition1);
        Cat cat = (Cat) beanFactory.getBean("cat");


        PropertyValue propertyValue1 = new PropertyValue("name", "zhangsan");
        PropertyValue propertyValue2 = new PropertyValue("age", 26);
        PropertyValue propertyValue3 = new PropertyValue("cat", new BeanReference("cat"));
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(propertyValue1);
        propertyValues.addPropertyValue(propertyValue2);
        propertyValues.addPropertyValue(propertyValue3);
        BeanDefinition beanDefinition2 = new BeanDefinition(Person.class, propertyValues);
        Person person = (Person) beanFactory.createBean("person", beanDefinition2, new Object[]{});

        Assertions.assertEquals(cat.getName(), person.getCat().getName());

    }


    @Test
    public void test_classpath() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("classpath:application.properties");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IoUtil.readUtf8(inputStream));//name:hello
    }


    @Test
    public void test_URL() throws IOException {
        Resource resource = new DefaultResourceLoader().getResource("https://github.com/DerekYRC/mini-spring/blob/main/README.md");
        InputStream inputStream = resource.getInputStream();
        System.out.println(IoUtil.readUtf8(inputStream));
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. 获取Bean对象调用方法
        Cat cat = (Cat) beanFactory.getBean("cat");
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(JSONUtil.toJsonStr(person));//{"name":"xiaowang","age":28,"cat":{"name":"miaomiao"}}
        System.out.println(cat == person.getCat());//ture
    }


}