package com.alex.sf.thinking.ioc.overview.container;

import com.alex.sf.thinking.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 *
 * 注解能力{@link org.springframework.context.ApplicationContext}  作为IOC容器
 *  * @author alex_qlx
 */
public class AnnotationApplicationContextAsIocContainerDemo {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        //将当前内作为配置class
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);
        //启动应用上下文
        applicationContext.refresh();

        lookupCollectionByType(applicationContext);

        //关闭应用上下文
        applicationContext.close();

    }


    @Bean
    public  User  user(){
        User  user = new User();
        user.setId(1L);
        user.setName("test");
        return user;
    }
    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if(beanFactory instanceof ListableBeanFactory){
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("复合类型查找：" + users);
        }
    }
}
