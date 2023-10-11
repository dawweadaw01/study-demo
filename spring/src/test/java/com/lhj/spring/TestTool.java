package com.lhj.spring;

import com.lhj.spring.tool.TypeStringToInteger2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * @description：
 * @createTime：2023-10-0414:38
 * @author：banyanmei
 */
public class TestTool {
    @Test
    void testBatchCreate() throws Exception {
        BeanDefinitionRegistry registry = new SimpleBeanDefinitionRegistry();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(registry);
        xmlBeanDefinitionReader.loadBeanDefinitions("classpath:bean.xml");
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String name : beanDefinitionNames) {
            BeanDefinition beanDefinition = registry.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> aClass = Class.forName(beanClassName);
            BeanWrapperImpl beanWrapper = new BeanWrapperImpl(aClass);
            DefaultConversionService defaultConversionService = new DefaultConversionService();
            defaultConversionService.addConverter(new TypeStringToInteger2());
            beanWrapper.setConversionService(defaultConversionService);
            beanWrapper.setPropertyValues(beanDefinition.getPropertyValues());
            Object wrappedInstance = beanWrapper.getWrappedInstance();
            System.out.println(wrappedInstance);
        }
    }
}
