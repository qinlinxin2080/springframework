package com.alex.sf.thinking.ioc.overview.dependency.lookup;

import com.alex.sf.thinking.ioc.overview.annotation.Super;
import com.alex.sf.thinking.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * 依赖查找示例
 * @author alex_qlx
 */
public class DependencyLookupDemo {

    public static void main(String[] args) {
        //配置xml
        //启动上下文context

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");

        //实时查询
        lookupInRealTime(beanFactory);
        //根据类型查询bean
        lookupByType(beanFactory);
        //　复合类型查询
        lookupCollectionByType(beanFactory);

        lookupByAnnotationType(beanFactory);

        //延时查询bean
        lookupInLazy(beanFactory);


    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, Object> users = listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("注解方式查找：" + users);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String,User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("复合类型查找：" + users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("单一类型查找：" + user);

    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>)beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("延时查找：" + user);
    }

    public static void lookupInRealTime(BeanFactory beanFactory){
        User user = (User)beanFactory.getBean("user");
        System.out.println("实时查找：" + user);
    }


}
