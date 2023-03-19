package factory;

import beans.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

class BeanFactoryTest {

    @Test
    void getBean() {


        BeanDefinition beanDefinition = new BeanDefinition(Person.class);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registryBeanDefinition("person", beanDefinition);

        // 第一次创建，放进单例池缓存
        Person person = (Person) beanFactory.getBean("person");
        person.show();
        // 第二次直接从单例池缓存读取
        Person person1 = (Person) beanFactory.getBean("person");
        person1.show();

    }
}