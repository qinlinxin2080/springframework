package com.alex.sf.thinking.ioc.overview.dependency.injection;

import com.alex.sf.thinking.ioc.overview.annotation.Super;
import com.alex.sf.thinking.ioc.overview.dependency.repository.UserRepository;
import com.alex.sf.thinking.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.EventListener;
import java.util.Map;

/**
 * 依赖注入示例
 * @author alex_qlx
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        //配置xml
        //启动上下文context

        // ClassPathXmlApplicationContext <-- applicationConext <-- beanFactory
        // 在 ClassPathXmlApplicationContext 中组合了beanFactory的实现
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        //依赖来源一：自定义bean
        UserRepository userRepository = (UserRepository)applicationContext.getBean("userRepository");

        System.out.println("自定义的bean" + userRepository);

        System.out.println("注入的bean 是否和获取的bean相同 " +(userRepository.getBeanFactory() == applicationContext.getBeanFactory()));

        //依赖来源二：容器内建的依赖（依赖注入） 非bean
        System.out.println("容器内建的依赖 beanFatory:" + userRepository.getBeanFactory());

        //依赖来源三：容器内建的bean
        Environment environment =(Environment) applicationContext.getBean(Environment.class);
        System.out.println(" 容器内建的bean environment:" + environment);


        //依赖查找（beanfactory找不到 报错）
//        System.out.println("applicationContext 是否注入了 applicationContext:" + applicationContext.getBean(BeanFactory.class));
       // 依赖注入和依赖查找不是来自同一个地方（同源）


        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());


        ObjectFactory objectFactory1  = (ObjectFactory)applicationContext.getBean("objectFactory");
        System.out.println(objectFactory1.getObject());

        System.out.println(objectFactory == objectFactory1);


    }

}
