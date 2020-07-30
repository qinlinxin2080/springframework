package com.alex.sf.thinking.ioc.overview.container;

import com.alex.sf.thinking.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * beanFactory{@link BeanFactory} 作为IOC容器
 * @author alex_qlx
 */
public class BeanFactoryAsIocContainerDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
        String path ="META-INF/dependency-lookup-context.xml";
        int beanCount = xmlBeanDefinitionReader.loadBeanDefinitions(path);

        System.out.println("bean 自定义加载的数量：" +  beanCount);
        lookupCollectionByType(defaultListableBeanFactory);

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("复合类型查找：" + users);
        }
    }
}
