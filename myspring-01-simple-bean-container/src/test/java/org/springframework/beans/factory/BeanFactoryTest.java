package org.springframework.beans.factory;

import org.springframework.beans.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;

class BeanFactoryTest {

    @Test
    void getBean() {

        // 1. 实例化一个Bean(这一步暂时这样做，以后会补充)
        Person person = new Person("tao", 18);
        // 2. 将其放进Bean定义
        BeanDefinition beanDefinition = new BeanDefinition(person);

        // 3. 创建Bean工厂,注册Bean信息
        BeanFactory beanFactory = new BeanFactory();
        beanFactory.registerBeanDefinition("person", beanDefinition);

        // 4. 通过工厂获取Bean实例
        Person person1 = (Person) beanFactory.getBean("person");
        Assertions.assertEquals(person1.getName(), "tao");
        Assertions.assertEquals(person1.getAge(), 18);


    }
}