package guru.springframework.didemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleBean Constructor");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("## The LifecycleBean has been terminated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("## The LifecycleBean has its properties set");

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("## The Factory has been set");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("## My Bean name is " + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("## Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("## The Post Construct annotated method has been called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("## The Predestroy annotated method has been called");
    }

    public void beforeInit() {
        System.out.println("## Before Init - Called by Bean Post Processor");
    }

    public void afterInit() {
        System.out.println("## After Init - Called by Bean Post Processor");
    }

    
    /*
        ## I'm in the LifeCycleBean Constructor
        ## My Bean name is lifeCycleDemoBean
        ## The Factory has been set
        ## Application context has been set
        ## Before Init - Called by Bean Post Processor
        ## The Post Construct annotated method has been called
        ## The LifecycleBean has its properties set
        ## After Init - Called by Bean Post Processor
        ## The Predestroy annotated method has been called
        ## The LifecycleBean has been terminated
    */
}
