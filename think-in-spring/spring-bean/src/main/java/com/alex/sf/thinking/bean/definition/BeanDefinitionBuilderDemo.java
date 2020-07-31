package com.alex.sf.thinking.bean.definition;

import com.alex.sf.thinking.ioc.overview.domain.User;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * {@link org.springframework.beans.factory.config.BeanDefinition}  bean构建示例
 * @author alex_qlx
 */
public class BeanDefinitionBuilderDemo {
    public static void main(String[] args) {
        //1. 通过BeanDefinitionBuilder 来构建beanDefinition
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        //设置bean属性
        builder.addPropertyValue("id",1);
        builder.addPropertyValue("name","xiaoxiin");

        //获取beandefinition实例
        BeanDefinition beanDefinition =  builder.getBeanDefinition();

        //2. AbstractBeanDefinition 来构建beanDefinition
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置bean的类型
        genericBeanDefinition.setBeanClass(User.class);
        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();

        //设置bean的属性
        mutablePropertyValues.addPropertyValue("id",1);
        mutablePropertyValues.addPropertyValue("name","xiaoxiin");
        genericBeanDefinition.setPropertyValues(mutablePropertyValues);


    }
}
