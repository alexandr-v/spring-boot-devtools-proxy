package com.example.spring;

import com.example.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component
public class TestBeanPostProcessor implements BeanPostProcessor {
    
    @Override
    public Object postProcessBeforeInitialization(Object bean, String s) throws BeansException {
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization(Object bean, String s) throws BeansException {
        
        if (bean instanceof TestService){
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    ClassUtils.getAllInterfaces(bean),
                    (proxy, method, args) -> method.invoke(bean, args)
            );
        }
        
        
        return bean;
    }
}
