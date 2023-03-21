package org.springframework.beans.factory;

import cn.hutool.json.JSONUtil;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.springframework.beans.Person;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class BeanFactoryTest {

    @Test
    void getBean() {

        BeanDefinition beanDefinition = new BeanDefinition(Person.class);
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registryBeanDefinition("person", beanDefinition);

        // 第一次创建，放进单例池缓存
        Person person = (Person) beanFactory.getBean("person", new Object[]{"wang", 23});
        System.out.println(JSONUtil.toJsonStr(person));
        // 第二次直接从单例池缓存读取
        Person person1 = (Person) beanFactory.getBean("person");
        System.out.println(JSONUtil.toJsonStr(person));
        System.out.println(person == person1);

    }

    @Test
    void testCglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Person.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });

        Person person = (Person) enhancer.create(new Class[]{String.class, Integer.class}, new Object[]{"wang", 23});
        System.out.println(JSONUtil.toJsonStr(person));

    }

    @Test
    void test_constructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getDeclaredConstructor(new Class[]{String.class, Integer.class});
        Person person = constructor.newInstance("wang", 23);
        System.out.println(JSONUtil.toJsonStr(person));
    }

}