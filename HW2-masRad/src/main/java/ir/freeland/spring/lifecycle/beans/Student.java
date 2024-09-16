package ir.freeland.spring.lifecycle.beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SuppressWarnings("unused")
public class Student implements BeanNameAware, ApplicationContextAware, InitializingBean, DisposableBean, BeanFactoryAware {
	
    private String name;
    
    
	private String beanName;    
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;


	private Course course;

    public Student() {
        System.out.println("Instantiation: A new Student has been enrolled.");
        this.name = "Mas";
    }



    public void setItem(Course course) {
        this.course = course;
        System.out.println("Based on chart: Adding " + course.getName() + " to " + getName() );
    }

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware: Setting bean name: " + name);
        this.beanName = name;
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("BeanFactoryAware: Setting bean factory for " + getName());
    }
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware: Setting application context.");
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct: " + getName() + "  has enrolled.");
    }
	@Override
	public void afterPropertiesSet() throws Exception {
        System.out.println("Hello " + getName() );	
	}
	@Override
	public void destroy() throws Exception {
	System.out.println( getName() + " is leaving ");
	sayGoodbye();	
	}
    private void study() {
    	System.out.println("Student : "+ getName() + " is studing()");
	}
    private void sayGoodbye() {
        System.out.println("Our Student : " + getName() + " says goodbye.");
    }    

    @PreDestroy
    public void preDestroy() {
        System.out.println("@PreDestroy: " + getName() + " deleted " + course.getName());
    }


}
