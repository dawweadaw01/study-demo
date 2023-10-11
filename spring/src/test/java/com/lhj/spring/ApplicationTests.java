package com.lhj.spring;

import com.lhj.spring.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Arrays;

@SpringBootTest
@Slf4j
class ApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testGenericBeanDefinition() {
        SimpleBeanDefinitionRegistry simpleBeanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClassName("com.lhj.spring.pojo.Dog");
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("name", "lhj");
        propertyValues.add("age", 18);
        genericBeanDefinition.setPropertyValues(propertyValues);
        simpleBeanDefinitionRegistry.registerBeanDefinition("dog", genericBeanDefinition);
        ChildBeanDefinition childBeanDefinition = new ChildBeanDefinition("dog");
        childBeanDefinition.setBeanClassName("com.lhj.spring.pojo.DogTel");
        childBeanDefinition.setScope("singleton");
        MutablePropertyValues propertyValues1 = new MutablePropertyValues();
        propertyValues1.add("telname", "lhj");
        childBeanDefinition.setPropertyValues(propertyValues1);
        simpleBeanDefinitionRegistry.registerBeanDefinition("dogTel", childBeanDefinition);
        System.out.println(simpleBeanDefinitionRegistry.getBeanDefinition("dog").getBeanClassName());
    }

    @Test
    void testXml() {
        SimpleBeanDefinitionRegistry simpleBeanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(simpleBeanDefinitionRegistry);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:bean.xml");
        String dog = xmlBeanDefinitionReader.getRegistry().getBeanDefinition("dog").getBeanClassName();
        System.out.println(dog);

    }

    @Test
    void testRegistryByScanner(){
        SimpleBeanDefinitionRegistry simpleBeanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
        new ClassPathBeanDefinitionScanner(simpleBeanDefinitionRegistry).scan("com.lhj.spring.pojo");
        log.info(Arrays.toString(simpleBeanDefinitionRegistry.getBeanDefinitionNames()));
    }

    @Test
    void testIntrospect1() throws Exception {
        BeanInfo beanInfo = Introspector.getBeanInfo(User.class, Object.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            log.info("{}", propertyDescriptor.getPropertyType());
            log.info("{}", propertyDescriptor.getReadMethod());
            log.info("{}", propertyDescriptor.getWriteMethod());
        }
    }
    @Test
    void testIntrospect2() throws Exception{
        User user = new User();
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name", User.class);
        Method writeMethod = propertyDescriptor.getWriteMethod();
        writeMethod.invoke(user, "lhj");
        System.out.println(propertyDescriptor.getReadMethod().invoke(user));
    }
    @Test
    void testBeanUtils() throws Exception{
        User user = new User();
        BeanUtils.setProperty(user, "name", "lhj");
        BeanUtils.setProperty(user, "age", 18);
        System.out.println(user);
    }
}